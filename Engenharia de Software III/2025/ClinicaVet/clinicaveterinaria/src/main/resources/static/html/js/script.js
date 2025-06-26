document.addEventListener("DOMContentLoaded", () => {
  const buttons = document.querySelectorAll(".button-group button");
  const viewContainer = document.getElementById("view-container");

  // Mapeia data-view → arquivo HTML correspondente
  const viewMap = {
    "cadastro-animal-dono": "/html/cadastro-animal-dono.html",
    "cadastro-receituario": "/html/cadastro-receituario.html",
    "cadastro-medicamento": "/html/cadastro-medicamento.html",
    "cadastro-veterinario": "/html/cadastro-veterinario.html",
    "cadastro-pet": "/html/cadastro-pet.html",
    "cadastro-cliente": "/html/cadastro-cliente.html",
    "cadastro-agendamento": "/html/cadastro-agendamento.html",
    "list-cliente": "/html/list-cliente.html",
    "list-pet": "/html/list-pet.html",
    "list-receituario": "/html/list-receituario.html",
    "list-medicamento": "/html/list-medicamento.html",
    "list-veterinario": "/html/list-veterinario.html",
    "list-agendamento": "/html/list-agendamento.html",
  };

  // Função para carregar a view no container
  async function loadView(viewKey) {
    buttons.forEach((btn) =>
      btn.classList.toggle("active", btn.dataset.view === viewKey)
    );

    // Se for a "home" (Início), mostrar welcome
    if (viewKey === "welcome") {
      try {
        const res = await fetch("/html/homepage.html");
        if (!res.ok) throw new Error("Erro ao carregar a homepage");
        const html = await res.text();
        viewContainer.innerHTML = html;
      } catch (error) {
        viewContainer.innerHTML = "<p>Erro ao carregar a página inicial.</p>";
        console.error(error);
      }
      return;
    }

    // Busca o HTML externo
    const url = viewMap[viewKey];
    try {
      const res = await fetch(url);
      if (!res.ok) throw new Error(`Erro ao carregar ${url}`);
      const html = await res.text();
      viewContainer.innerHTML = html;
      bindFormListeners(viewKey);
    } catch (err) {
      viewContainer.innerHTML = `<p class="error">Não foi possível carregar a página.</p>`;
      console.error(err);
    }
  }

  // Após injetar o HTML, associa os listeners conforme a tela
  function bindFormListeners(viewKey) {
    
    // === Tela de Cadastro de Agendamento: cadastro + botão Listar ===
    if (viewKey === "cadastro-agendamento") {
      const form = document.getElementById("formAgendamento");
      const petSelect = form.petId;
      const vetSelect = form.veterinarianId;

      // Mapas auxiliares
      const ownerMap = {},
        petMap = {};

      // 1) Carrega donos e pets
      Promise.all([
        fetch("/api/owner").then((r) => r.json()),
        fetch("/api/pet").then((r) => r.json()),
      ])
        .then(([owners, pets]) => {
          owners.forEach((o) => (ownerMap[o.id] = o.name));
          pets.forEach((p) => (petMap[p.id] = p.ownerId));

          // Popula dropdown de Pet – Dono
          pets.forEach((p) => {
            const opt = document.createElement("option");
            opt.value = p.id;
            opt.textContent = `${p.name} - ${ownerMap[p.ownerId] || ""}`;
            petSelect.appendChild(opt);
          });
        })
        .catch((err) => console.error("Erro ao carregar pets ou donos:", err));

      // 2) Carrega veterinários
      fetch("/api/veterinarian")
        .then((r) => r.json())
        .then(
          (vets) =>
            (vetSelect.innerHTML += vets
              .map((v) => `<option value="${v.id}">${v.nome}</option>`)
              .join(""))
        )
        .catch((err) => console.error("Erro ao carregar veterinários:", err));

      // 3) Botão Listar
      document
        .getElementById("btn-list-agendamentos")
        .addEventListener("click", () => loadView("list-agendamento"));

      // 4) Submit (POST ou PUT)
      form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const petId = petSelect.value;
        const data = {
          petId,
          ownerId: petMap[petId],
          veterinarianId: vetSelect.value,
          anamnese: form.anamnese.value,
          date: form.date.value,
        };

        const editId = form.dataset.editId;
        const method = editId ? "PUT" : "POST";
        const url = editId ? `/api/appointment/${editId}` : "/api/appointment";

        try {
          const res = await fetch(url, {
            method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data),
          });
          if (!res.ok) throw new Error(res.statusText);

          alert(editId ? "Agendamento atualizado!" : "Agendamento criado!");
          form.reset();
          delete form.dataset.editId;
          loadView("list-agendamento");
        } catch (err) {
          console.error("Erro ao salvar agendamento:", err);
          alert("Erro ao salvar agendamento.");
        }
      });
    }

    // === Tela de Listagem de Agendamentos ===
    if (viewKey === "list-agendamento") {
      Promise.all([
        fetch("/api/owner").then((r) => r.json()),
        fetch("/api/pet").then((r) => r.json()),
        fetch("/api/veterinarian").then((r) => r.json()),
        fetch("/api/appointment").then((r) => r.json()),
      ])
        .then(([owners, pets, vets, apps]) => {
          const ownerMap = {},
            petMap = {},
            vetMap = {};
          owners.forEach((o) => (ownerMap[o.id] = o.name));
          pets.forEach((p) => (petMap[p.id] = p.name));
          vets.forEach((v) => (vetMap[v.id] = v.nome));

          const tbody = document.querySelector("#table-agendamentos tbody");
          tbody.innerHTML = apps
            .map(
              (a) => `
        <tr data-id="${a.id}">
          <td>${petMap[a.petId] || ""}</td>
          <td>${ownerMap[a.ownerId] || ""}</td>
          <td>${vetMap[a.veterinarianId] || ""}</td>
          <td>${a.anamnese}</td>
          <td>${new Date(a.date).toLocaleString()}</td>
          <td>
            <button class="btn-action btn-edit" data-id="${
              a.id
            }">Editar</button>
            <button class="btn-action btn-delete" data-id="${
              a.id
            }">Excluir</button>
          </td>
        </tr>`
            )
            .join("");

          // Editar
          document.querySelectorAll(".btn-edit").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              const id = btn.dataset.id;
              const a = await (await fetch(`/api/appointment/${id}`)).json();
              loadView("cadastro-agendamento");
              setTimeout(() => {
                const f = document.getElementById("formAgendamento");
                f.petId.value = a.petId;
                f.veterinarianId.value = a.veterinarianId;
                f.anamnese.value = a.anamnese;
                f.date.value = a.date;
                f.dataset.editId = a.id;
                f.querySelector('button[type="submit"]').textContent =
                  "Atualizar Agendamento";
              }, 300);
            });
          });

          // Excluir
          document.querySelectorAll(".btn-delete").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              if (!confirm("Excluir este agendamento?")) return;
              await fetch(`/api/appointment/${btn.dataset.id}`, {
                method: "DELETE",
              });
              btn.closest("tr").remove();
            });
          });
        })
        .catch((err) => {
          console.error("Erro ao carregar agendamentos:", err);
          viewContainer.innerHTML = `<p class="error">Erro ao carregar agendamentos.</p>`;
        });
    }

    // === Tela de Veterinário: cadastro + listar ===
    if (viewKey === "cadastro-veterinario") {
      // Botão Listar Veterinários
      const form = document.getElementById("formVet");
      const btnList = document.getElementById("btn-list-veterinarios");
      btnList?.addEventListener("click", () => loadView("list-veterinario"));

      form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const vetData = {
          nome: form.nome.value,
          crmv: form.crmv.value,
          especialidade: form.especialidade.value,
          telefone: form.telefone.value,
          dataNascimento: form.dataNascimento.value,
        };
        const editId = form.getAttribute("data-edit-id");
        const method = editId ? "PUT" : "POST";
        const url = editId
          ? `/api/veterinarian/${editId}`
          : "/api/veterinarian";
        const res = await fetch(url, {
          method,
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(vetData),
        });
        alert(
          res.ok
            ? editId
              ? "Veterinário atualizado!"
              : "Veterinário cadastrado!"
            : "Erro ao salvar veterinário."
        );
        form.reset();
        if (editId) {
          form.removeAttribute("data-edit-id");
          loadView("list-veterinario");
        } else {
          loadView("cadastro-veterinario");
        }
      });
    }

    // === Tela de Listagem de Veterinários ===
    if (viewKey === "list-veterinario") {
      fetch("/api/veterinarian")
        .then((r) => r.json())
        .then((vets) => {
          const tbody = document.querySelector("#table-veterinarios tbody");
          tbody.innerHTML = vets
            .map((v) => {
              const dt = new Date(v.dataNascimento).toISOString().split("T")[0];
              return `
          <tr data-id="${v.id}">
            <td>${v.nome}</td>
            <td>${v.crmv}</td>
            <td>${v.especialidade}</td>
            <td>${v.telefone}</td>
            <td>${dt}</td>
            <td>
              <button class="btn-action btn-edit" data-id="${v.id}">Editar</button>
              <button class="btn-action btn-delete" data-id="${v.id}">Excluir</button>
            </td>
          </tr>`;
            })
            .join("");

          // Editar
          document.querySelectorAll(".btn-edit").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              const id = e.target.dataset.id;
              const v = await (await fetch(`/api/veterinarian/${id}`)).json();
              loadView("cadastro-veterinario");
              setTimeout(() => {
                const f = document.getElementById("formVet");
                f.nome.value = v.nome;
                f.crmv.value = v.crmv;
                f.especialidade.value = v.especialidade;
                f.telefone.value = v.telefone;
                f.dataNascimento.value = v.dataNascimento.split("T")[0];
                f.setAttribute("data-edit-id", v.id);
                f.querySelector('button[type="submit"]').textContent =
                  "Atualizar Veterinário";
              }, 300);
            });
          });

          // Excluir
          document.querySelectorAll(".btn-delete").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              if (!confirm("Excluir este veterinário?")) return;
              await fetch(`/api/veterinarian/${e.target.dataset.id}`, {
                method: "DELETE",
              });
              e.target.closest("tr").remove();
            });
          });
        })
        .catch((err) => {
          console.error(err);
          viewContainer.innerHTML = `<p class="error">Erro ao carregar veterinários.</p>`;
        });
    }

    // === Tela de Medicamento: cadastro + listar ===
    if (viewKey === "cadastro-medicamento") {
      // Botão Listar Medicamentos
      const form = document.getElementById("formMedicamento");
      const btnList = document.getElementById("btn-list-medicamentos");
      btnList?.addEventListener("click", () => loadView("list-medicamento"));

      form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const med = {
          name: form.name.value,
          manufacturer: form.manufacturer.value,
          dosage: parseFloat(form.dosage.value),
          unit: form.unit.value,
          stock: parseInt(form.stock.value, 10),
        };
        const editId = form.getAttribute("data-edit-id");
        const method = editId ? "PUT" : "POST";
        const url = editId ? `/api/medication/${editId}` : "/api/medication";
        const res = await fetch(url, {
          method,
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(med),
        });
        alert(
          res.ok
            ? editId
              ? "Medicamento atualizado com sucesso!"
              : "Medicamento cadastrado com sucesso!"
            : "Erro ao salvar medicamento."
        );
        form.reset();
        if (editId) {
          form.removeAttribute("data-edit-id");
          loadView("list-medicamento");
        } else loadView("cadastro-medicamento");
      });
    }

    // === Tela de Listagem de Medicamentos ===
    if (viewKey === "list-medicamento") {
      fetch("/api/medication")
        .then((r) => r.json())
        .then((meds) => {
          const tbody = document.querySelector("#table-madicamentos tbody");
          tbody.innerHTML = meds
            .map((m) => {
              return `
              <tr data-id="${m.id}">
                <td>${m.name}</td>
                <td>${m.manufacturer}</td>
                <td>${m.dosage}</td>
                <td>${m.unit}</td>
                <td>${m.stock}</td>
                <td>
                  <button class="btn-action btn-edit" data-id="${m.id}">Editar</button>
                  <button class="btn-action btn-delete" data-id="${m.id}">Excluir</button>
                </td>
              </tr>`;
            })
            .join("");
          // Editar
          document.querySelectorAll(".btn-edit").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              const id = e.target.dataset.id;
              const med = await (await fetch(`/api/medication/${id}`)).json();
              loadView("cadastro-medicamento");
              setTimeout(() => {
                const form = document.getElementById("formMedicamento");
                form.name.value = med.name;
                form.manufacturer.value = med.manufacturer;
                form.dosage.value = med.dosage;
                form.unit.value = med.unit;
                form.stock.value = med.stock;
                form.setAttribute("data-edit-id", med.id);
                form.querySelector('button[type="submit"]').textContent =
                  "Atualizar Medicamento";
              }, 300);
            });
          });
          // Excluir
          document.querySelectorAll(".btn-delete").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              if (!confirm("Deseja excluir este medicamento?")) return;
              await fetch(`/api/medication/${e.target.dataset.id}`, {
                method: "DELETE",
              });
              e.target.closest("tr").remove();
            });
          });
        })
        .catch((err) => {
          console.error(err);
          viewContainer.innerHTML = `<p class="error">Erro ao carregar medicamentos.</p>`;
        });
    }

    // === Tela de Cliente: cadastro + botão Listar ===
    if (viewKey === "cadastro-cliente") {
      //Botão Listar Clientes
      const btnList = document.getElementById("btn-list-clientes");
      btnList?.addEventListener("click", () => loadView("list-cliente"));

      const form = document.getElementById("form-cliente");
      form?.addEventListener("submit", async (e) => {
        e.preventDefault();
        const cliente = {
          name: form.name.value,
          birthDate: form.birthDate.value,
          address: form.address.value,
          phone: form.phone.value,
          cpf: form.cpf.value,
        };
        const editId = form.getAttribute("data-edit-id");
        const method = editId ? "PUT" : "POST";
        const url = editId ? `/api/owner/${editId}` : "/api/owner";
        try {
          const res = await fetch(url, {
            method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(cliente),
          });
          if (!res.ok) throw new Error(`${method} falhou`);
          alert(
            editId
              ? "Cliente atualizado com sucesso!"
              : "Cliente cadastrado com sucesso!"
          );
          form.reset();
          if (editId) {
            form.removeAttribute("data-edit-id");
            loadView("list-cliente");
          } else {
            loadView("cadastro-cliente");
          }
        } catch (err) {
          console.error(err);
          alert("Erro ao salvar cliente");
        }
      });
    }

    // === Tela de Listagem de Clientes ===
    if (viewKey === "list-cliente") {
      fetch("/api/owner")
        .then((res) => res.json())
        .then((owners) => {
          const tbody = document.querySelector("#table-clientes tbody");
          tbody.innerHTML = owners
            .map((o) => {
              const data = new Date(o.birthDate).toISOString().split("T")[0];
              return `
              <tr data-id="${o.id}">
                <td>${o.name}</td>
                <td>${data}</td>
                <td>${o.address || ""}</td>
                <td>${o.phone}</td>
                <td>${o.cpf}</td>
                <td>
                  <button class="btn-action btn-edit" data-id="${
                    o.id
                  }">Editar</button>
                  <button class="btn-action btn-delete" data-id="${
                    o.id
                  }">Excluir</button>
                </td>
              </tr>`;
            })
            .join("");
          // Editar
          document.querySelectorAll(".btn-edit").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              const id = e.target.dataset.id;
              const res = await fetch(`/api/owner/${id}`);
              const data = await res.json();
              loadView("cadastro-cliente");
              setTimeout(() => {
                const form = document.getElementById("form-cliente");
                form.elements["name"].value = data.name;
                form.elements["birthDate"].value = data.birthDate.split("T")[0];
                form.elements["address"].value = data.address;
                form.elements["phone"].value = data.phone;
                form.elements["cpf"].value = data.cpf;
                form.setAttribute("data-edit-id", data.id);
                form.querySelector('button[type="submit"]').textContent =
                  "Atualizar Cliente";
              }, 300);
            });
          });
          // Excluir
          document.querySelectorAll(".btn-delete").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              const id = e.target.dataset.id;
              if (!confirm("Deseja realmente excluir este cliente?")) return;
              await fetch(`/api/owner/${id}`, { method: "DELETE" });
              e.target.closest("tr").remove();
            });
          });
        })
        .catch((err) => console.error(err));
    }

    // === Tela de Pet: cadastro + botão Listar ===
    if (viewKey === "cadastro-pet") {
      const ownerSelect = document.querySelector('select[name="ownerId"]');
      fetch("/api/owner")
        .then((res) => res.json())
        .then((owners) =>
          owners.forEach((o) => {
            const opt = document.createElement("option");
            opt.value = o.id;
            opt.textContent = o.name;
            ownerSelect.appendChild(opt);
          })
        );
      // Botão Listar Pets
      const btnList = document.getElementById("btn-list-pets");
      btnList?.addEventListener("click", () => loadView("list-pet"));

      const form = document.getElementById("form-pet");
      form?.addEventListener("submit", async (e) => {
        e.preventDefault();
        const petData = {
          name: form.name.value,
          breed: form.breed.value,
          birthDate: form.birthDate.value,
          color: form.color.value,
          weight: parseFloat(form.weight.value),
          allergies: form.allergies.value,
          ownerId: form.ownerId.value,
        };
        const editId = form.getAttribute("data-edit-id");
        const method = editId ? "PUT" : "POST";
        const url = editId ? `/api/pet/${editId}` : "/api/pet";
        const res = await fetch(url, {
          method,
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(petData),
        });
        alert(
          res.ok
            ? editId
              ? "Pet atualizado com sucesso!"
              : "Pet cadastrado com sucesso!"
            : "Erro ao salvar pet."
        );
        form.reset();
        if (editId) {
          form.removeAttribute("data-edit-id");
          loadView("list-pet");
        } else loadView("cadastro-pet");
      });
    }

    // === Tela de Listagem de Pets ===
    if (viewKey === "list-pet") {
      Promise.all([
        fetch("/api/owner").then((r) => r.json()),
        fetch("/api/pet").then((r) => r.json()),
      ])
        .then(([owners, pets]) => {
          const ownerMap = {};
          owners.forEach((o) => (ownerMap[o.id] = o.name));

          const tbody = document.querySelector("#table-pets tbody");
          tbody.innerHTML = pets
            .map((p) => {
              const dt = new Date(p.birthDate).toISOString().split("T")[0];
              const ownerName = ownerMap[p.ownerId] || "";
              return `
              <tr data-id="${p.id}">
                <td>${p.name}</td>
                <td>${p.breed}</td>
                <td>${dt}</td>
                <td>${p.color}</td>
                <td>${p.weight.toFixed(2)}</td>
                <td>${p.allergies || ""}</td>
                <td>${ownerName}</td>
                <td>
                  <button class="btn-action btn-edit" data-id="${
                    p.id
                  }">Editar</button>
                  <button class="btn-action btn-delete" data-id="${
                    p.id
                  }">Excluir</button>
                </td>
              </tr>`;
            })
            .join("");
          // Editar
          document.querySelectorAll(".btn-edit").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              const id = e.target.dataset.id;
              const pet = await (await fetch(`/api/pet/${id}`)).json();
              loadView("cadastro-pet");
              setTimeout(() => {
                const form = document.getElementById("form-pet");
                form.name.value = pet.name;
                form.breed.value = pet.breed;
                form.birthDate.value = pet.birthDate.split("T")[0];
                form.color.value = pet.color;
                form.weight.value = pet.weight;
                form.allergies.value = pet.allergies;
                form.ownerId.value = pet.ownerId;
                form.setAttribute("data-edit-id", pet.id);
                form.querySelector('button[type="submit"]').textContent =
                  "Atualizar Pet";
              }, 300);
            });
          });
          // Excluir
          document.querySelectorAll(".btn-delete").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              if (!confirm("Deseja excluir este pet?")) return;
              await fetch(`/api/pet/${e.target.dataset.id}`, {
                method: "DELETE",
              });
              e.target.closest("tr").remove();
            });
          });
        })
        .catch((err) => console.error(err));
    }

    // === Tela de Receituário: cadastro + botão Listar ===
    if (viewKey === "cadastro-receituario") {
      const form = document.getElementById("formReceituario");
      const petSelect = form.petId;
      const vetSelect = form.veterinarianId;

      // 1) Carrega donos e pets para montar dropdown de Pet - Dono
      const ownerMap = {};
      Promise.all([
        fetch("/api/owner").then((r) => r.json()),
        fetch("/api/pet").then((r) => r.json()),
      ])
        .then(([owners, pets]) => {
          owners.forEach((o) => (ownerMap[o.id] = o.name));
          pets.forEach((p) => {
            const opt = document.createElement("option");
            opt.value = p.id;
            opt.textContent = `${p.name} - ${ownerMap[p.ownerId] || ""}`;
            petSelect.appendChild(opt);
          });
        })
        .catch((err) => console.error("Erro ao carregar pets ou donos:", err));

      // 2) Carrega os veterinários
      fetch("/api/veterinarian")
        .then((r) => r.json())
        .then((vets) => {
          vets.forEach((v) => {
            const opt = document.createElement("option");
            opt.value = v.id;
            opt.textContent = v.nome;
            vetSelect.appendChild(opt);
          });
        })
        .catch((err) => console.error("Erro ao carregar veterinários:", err));

      // 3) Botão listar
      document
        .getElementById("btn-list-receituarios")
        .addEventListener("click", () => loadView("list-receituario"));

      // 4) Submit
      form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const data = {
          petId: form.petId.value,
          veterinarianId: form.veterinarianId.value,
          description: form.description.value,
          prescription: form.prescription.value,
          date: form.date.value,
        };

        const editId = form.getAttribute("data-edit-id");
        const method = editId ? "PUT" : "POST";
        const url = editId
          ? `/api/consultation/${editId}`
          : "/api/consultation";

        try {
          const res = await fetch(url, {
            method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data),
          });
          if (!res.ok) throw new Error(res.statusText);

          alert(editId ? "Receituário atualizado!" : "Receituário cadastrado!");
          form.reset();
          if (editId) {
            form.removeAttribute("data-edit-id");
            loadView("list-receituario");
          } else {
            loadView("cadastro-receituario");
          }
        } catch (err) {
          console.error("Erro ao salvar receituário:", err);
          alert("Erro ao salvar receituário.");
        }
      });
    }

    // === Tela de Listagem de Receituários ===
    if (viewKey === "list-receituario") {
      Promise.all([
        fetch("/api/pet").then((r) => r.json()),
        fetch("/api/veterinarian").then((r) => r.json()),
        fetch("/api/consultation").then((r) => r.json()),
      ])
        .then(([pets, vets, recs]) => {
          const petMap = {};
          pets.forEach((p) => (petMap[p.id] = p.name));
          const vetMap = {};
          vets.forEach((v) => (vetMap[v.id] = v.nome));
          const tbody = document.querySelector("#table-receituarios tbody");
          tbody.innerHTML = recs
            .map((r) => {
              const dt = new Date(r.date).toLocaleString();
              return `
              <tr data-id="${r.id}">
                <td>${petMap[r.petId] || ""}</td>
                <td>${vetMap[r.veterinarianId] || ""}</td>
                <td>${r.description}</td>
                <td>${r.prescription}</td>
                <td>${dt}</td>
                <td>
                  <button class="btn-action btn-edit" data-id="${
                    r.id
                  }">Editar</button>
                  <button class="btn-action btn-delete" data-id="${
                    r.id
                  }">Excluir</button>
                </td>
              </tr>`;
            })
            .join("");
          // Editar
          document.querySelectorAll(".btn-edit").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              const id = e.target.dataset.id;
              const rec = await (await fetch(`/api/consultation/${id}`)).json();
              loadView("cadastro-receituario");
              setTimeout(() => {
                const form = document.getElementById("formReceituario");
                form.petId.value = rec.petId;
                form.veterinarianId.value = rec.veterinarianId;
                form.description.value = rec.description;
                form.prescription.value = rec.prescription;
                form.date.value = rec.date;
                form.setAttribute("data-edit-id", rec.id);
                form.querySelector('button[type="submit"]').textContent =
                  "Atualizar Receituário";
              }, 300);
            });
          });
          // Excluir
          document.querySelectorAll(".btn-delete").forEach((btn) => {
            btn.addEventListener("click", async (e) => {
              if (!confirm("Excluir este receituário?")) return;
              await fetch(`/api/consultation/${e.target.dataset.id}`, {
                method: "DELETE",
              });
              e.target.closest("tr").remove();
            });
          });
        })
        .catch((err) => {
          console.error(err);
          viewContainer.innerHTML = `<p class="error">Erro ao carregar receituários.</p>`;
        });
    }
  }

  // Inicializa com a tela "welcome"
  loadView("welcome");

  // Escuta cliques nos botões principais
  buttons.forEach((btn) => {
    btn.addEventListener("click", () => loadView(btn.dataset.view));
  });
});