package com.clinicaveterinaria.api;

import static spark.Spark.*;

import com.clinicaveterinaria.dao.*;
import com.clinicaveterinaria.model.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class VetApi {

    public static void main(String[] args) throws Exception {
        // --- Configuração do servidor Spark ---
        port(4567);
        staticFiles.location("/static/html");

        // --- Configuração do Jackson para java.time ---
        ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // =====================================================================
        //                            ROTAS HTML
        // =====================================================================

        get("/", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/index.html")));
        });

        get("/html/homepage.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/homepage.html")));
        });

        get("/html/cadastro-receituario.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/cadastro-receituario.html")));
        });

        get("/html/cadastro-medicamento.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/cadastro-medicamento.html")));
        });

        get("/html/cadastro-veterinario.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/cadastro-veterinario.html")));
        });

        get("/html/cadastro-pet.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/cadastro-pet.html")));
        });

        get("/html/cadastro-cliente.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/cadastro-cliente.html")));
        });

        get("/html/cadastro-agendamento.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/cadastro-agendamento.html")));
        });

        get("/html/list-agendamento.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/list-agendamento.html")));
        });

        get("/html/list-cliente.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/list-cliente.html")));
        });

        get("/html/list-pet.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/list-pet.html")));
        });

        get("/html/list-receituario.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/list-receituario.html")));
        });

        get("/html/list-medicamento.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/list-medicamento.html")));
        });

        get("/html/list-veterinario.html", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(
                Paths.get("src/main/resources/static/html/list-veterinario.html")));
        });

        // =====================================================================
        //                     CRUD Appointment (Agendamento)
        // =====================================================================

        post("/api/appointment", (req, res) -> {
            Appointment a = mapper.readValue(req.body(), Appointment.class);
            new AppointmentDAO().insert(a);
            res.status(201);
            res.type("application/json");
            return mapper.writeValueAsString(a);
        });

        get("/api/appointment", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(new AppointmentDAO().findAll());
        });

        get("/api/appointment/:id", (req, res) -> {
            Appointment a = new AppointmentDAO().findById(req.params("id"));
            if (a == null) {
                res.status(404);
                return "{\"error\":\"Agendamento não encontrado\"}";
            }
            res.type("application/json");
            return mapper.writeValueAsString(a);
        });

        put("/api/appointment/:id", (req, res) -> {
            String id = req.params("id");
            Appointment a = mapper.readValue(req.body(), Appointment.class);
            a.setId(id);
            UpdateResult result = new AppointmentDAO().update(id, a);
            if (result.getModifiedCount() == 0) {
                res.status(404);
                return "{\"error\":\"Agendamento não encontrado ou sem alterações\"}";
            }
            res.status(200);
            res.type("application/json");
            return mapper.writeValueAsString(a);
        });

        delete("/api/appointment/:id", (req, res) -> {
            DeleteResult result = new AppointmentDAO().delete(req.params("id"));
            res.type("application/json");
            return mapper.writeValueAsString(result);
        });

        // =====================================================================
        //                         CRUD Owner (Cliente)
        // =====================================================================

        post("/api/owner", (req, res) -> {
            Owner o = mapper.readValue(req.body(), Owner.class);
            new OwnerDAO().insert(o);
            res.status(201);
            res.type("application/json");
            return mapper.writeValueAsString(o);
        });

        get("/api/owner", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(new OwnerDAO().findAll());
        });

        get("/api/owner/:id", (req, res) -> {
            Owner o = new OwnerDAO().findById(req.params("id"));
            if (o == null) {
                res.status(404);
                return "{\"error\":\"Cliente não encontrado\"}";
            }
            res.type("application/json");
            return mapper.writeValueAsString(o);
        });

        put("/api/owner/:id", (req, res) -> {
            String id = req.params("id");
            Owner o = mapper.readValue(req.body(), Owner.class);
            o.setId(id);
            UpdateResult result = new OwnerDAO().update(id, o);
            if (result.getModifiedCount() == 0) {
                res.status(404);
                return "{\"error\":\"Cliente não encontrado ou sem alterações\"}";
            }
            res.status(200);
            res.type("application/json");
            return mapper.writeValueAsString(o);
        });

        delete("/api/owner/:id", (req, res) -> {
            DeleteResult result = new OwnerDAO().delete(req.params("id"));
            res.type("application/json");
            return mapper.writeValueAsString(result);
        });

        // =====================================================================
        //                          CRUD Pet
        // =====================================================================

        post("/api/pet", (req, res) -> {
            Pet p = mapper.readValue(req.body(), Pet.class);
            new PetDAO().insert(p);
            res.status(201);
            res.type("application/json");
            return mapper.writeValueAsString(p);
        });

        get("/api/pet", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(new PetDAO().findAll());
        });

        get("/api/pet/:id", (req, res) -> {
            Pet p = new PetDAO().findById(req.params("id"));
            if (p == null) {
                res.status(404);
                return "{\"error\":\"Pet não encontrado\"}";
            }
            res.type("application/json");
            return mapper.writeValueAsString(p);
        });

        put("/api/pet/:id", (req, res) -> {
            String id = req.params("id");
            Pet p = mapper.readValue(req.body(), Pet.class);
            p.setId(id);
            UpdateResult result = new PetDAO().update(id, p);
            if (result.getModifiedCount() == 0) {
                res.status(404);
                return "{\"error\":\"Pet não encontrado ou sem alterações\"}";
            }
            res.status(200);
            res.type("application/json");
            return mapper.writeValueAsString(p);
        });

        delete("/api/pet/:id", (req, res) -> {
            DeleteResult result = new PetDAO().delete(req.params("id"));
            res.type("application/json");
            return mapper.writeValueAsString(result);
        });

        // =====================================================================
        //                      CRUD Medication (Medicamento)
        // =====================================================================

        post("/api/medication", (req, res) -> {
            Medication m = mapper.readValue(req.body(), Medication.class);
            new MedicationDAO().insert(m);
            res.status(201);
            res.type("application/json");
            return mapper.writeValueAsString(m);
        });

        get("/api/medication", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(new MedicationDAO().findAll());
        });

        get("/api/medication/:id", (req, res) -> {
            Medication m = new MedicationDAO().findById(req.params("id"));
            if (m == null) {
                res.status(404);
                return "{\"error\":\"Medicamento não encontrado\"}";
            }
            res.type("application/json");
            return mapper.writeValueAsString(m);
        });

        put("/api/medication/:id", (req, res) -> {
            String id = req.params("id");
            Medication m = mapper.readValue(req.body(), Medication.class);
            m.setId(id);
            UpdateResult result = new MedicationDAO().update(id, m);
            if (result.getModifiedCount() == 0) {
                res.status(404);
                return "{\"error\":\"Medicamento não encontrado ou sem alterações\"}";
            }
            res.status(200);
            res.type("application/json");
            return mapper.writeValueAsString(m);
        });

        delete("/api/medication/:id", (req, res) -> {
            DeleteResult result = new MedicationDAO().delete(req.params("id"));
            res.type("application/json");
            return mapper.writeValueAsString(result);
        });

        // =====================================================================
        //                    CRUD Consultation (Receituário)
        // =====================================================================

        post("/api/consultation", (req, res) -> {
            Consultation c = mapper.readValue(req.body(), Consultation.class);
            new ConsultationDAO().insert(c);
            res.status(201);
            res.type("application/json");
            return mapper.writeValueAsString(c);
        });

        get("/api/consultation", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(new ConsultationDAO().findAll());
        });

        get("/api/consultation/:id", (req, res) -> {
            Consultation c = new ConsultationDAO().findById(req.params("id"));
            if (c == null) {
                res.status(404);
                return "{\"error\":\"Receituário não encontrado\"}";
            }
            res.type("application/json");
            return mapper.writeValueAsString(c);
        });

        put("/api/consultation/:id", (req, res) -> {
            String id = req.params("id");
            Consultation c = mapper.readValue(req.body(), Consultation.class);
            c.setId(id);
            UpdateResult result = new ConsultationDAO().update(id, c);
            if (result.getModifiedCount() == 0) {
                res.status(404);
                return "{\"error\":\"Receituário não encontrado ou sem alterações\"}";
            }
            res.status(200);
            res.type("application/json");
            return mapper.writeValueAsString(c);
        });

        delete("/api/consultation/:id", (req, res) -> {
            DeleteResult result = new ConsultationDAO().delete(req.params("id"));
            res.type("application/json");
            return mapper.writeValueAsString(result);
        });

        // =====================================================================
        //                    CRUD Veterinarian (Veterinário)
        // =====================================================================

        post("/api/veterinarian", (req, res) -> {
            Veterinarian v = mapper.readValue(req.body(), Veterinarian.class);
            new VeterinarianDAO().insert(v);
            res.status(201);
            res.type("application/json");
            return mapper.writeValueAsString(v);
        });

        get("/api/veterinarian", (req, res) -> {
            res.type("application/json");
            return mapper.writeValueAsString(new VeterinarianDAO().findAll());
        });

        get("/api/veterinarian/:id", (req, res) -> {
            Veterinarian v = new VeterinarianDAO().findById(req.params("id"));
            if (v == null) {
                res.status(404);
                return "{\"error\":\"Veterinário não encontrado\"}";
            }
            res.type("application/json");
            return mapper.writeValueAsString(v);
        });

        put("/api/veterinarian/:id", (req, res) -> {
            String id = req.params("id");
            Veterinarian v = mapper.readValue(req.body(), Veterinarian.class);
            v.setId(id);
            UpdateResult result = new VeterinarianDAO().update(id, v);
            if (result.getModifiedCount() == 0) {
                res.status(404);
                return "{\"error\":\"Veterinário não encontrado ou sem alterações\"}";
            }
            res.status(200);
            res.type("application/json");
            return mapper.writeValueAsString(v);
        });

        delete("/api/veterinarian/:id", (req, res) -> {
            DeleteResult result = new VeterinarianDAO().delete(req.params("id"));
            res.type("application/json");
            return mapper.writeValueAsString(result);
        });
    }
}