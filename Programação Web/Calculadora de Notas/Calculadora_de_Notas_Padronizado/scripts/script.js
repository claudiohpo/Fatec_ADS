let resultados = [];
        function adicionarDisciplina() {
            const disciplinasContainer = document.getElementById('disciplinas');
            const novaDisciplina = document.createElement('div');
            novaDisciplina.classList.add('disciplina');
            novaDisciplina.innerHTML = `
                <input type="text" placeholder="Nome da Disciplina">
                <input type="number" placeholder="Nota M1">
                <input type="number" placeholder="Nota M2">
                <button onclick="removerDisciplina(this)">Remover</button>`;
            disciplinasContainer.appendChild(novaDisciplina);
        }

        function calcularMedia() {
            const disciplinas = document.querySelectorAll('.disciplina');
            resultados = []; 

            disciplinas.forEach(disciplina => {
                const nomeDisciplina = disciplina.querySelector('input:nth-of-type(1)').value;
                const notaM1 = parseFloat(disciplina.querySelector('input:nth-of-type(2)').value);
                const notaM2 = parseFloat(disciplina.querySelector('input:nth-of-type(3)').value);

                
                if (nomeDisciplina === '')
                {
                        resultados.push(`<p>Campo "Nome da Disciplina" vazio, informe o nome e prossiga.</p>`);
                }
                else
                {
                    if (!isNaN(notaM1) && !isNaN(notaM2)) 
                    {
                    if (notaM1 >= 0 && notaM1 <= 10 && notaM2 >= 0 && notaM2 <= 10) 
                    {
                        const mediaFinal = (notaM1 * 4 + notaM2 * 6) / 10;
                        const status = mediaFinal >= 6 ? 'Aprovado' : 'Reprovado';
                        const cor = mediaFinal >= 6 ? 'darkblue' : 'red';
                        resultados.push(`<p><b>${nomeDisciplina}:</b> | Média Final: <strong style="color: ${cor}; font-weight: bold">${mediaFinal.toFixed(2)}</strong> | <strong>***</strong><span class="${status === 'Aprovado' ? 'Aprovado' : 'Reprovado'}">${status}</span><strong>***</strong></p>`);
                    } 
                    else 
                    {
                        resultados.push(`<p><strong>${nomeDisciplina}:</strong> Insira notas válidas (entre 0 e 10) para calcular a média.</p>`);
                    }
                } 
                else 
                {
                    resultados.push(`<p><strong>${nomeDisciplina}:</strong> Insira notas válidas para calcular a média.</p>`);
                }
                } 
            });
            
            document.getElementById('resultados').innerHTML = resultados.join('');
        }

        function limparDisciplinas() {
            const disciplinasContainer = document.getElementById('disciplinas');
            disciplinasContainer.innerHTML = '';
        }

        function limparCalculos() {
            const resultadoContainer = document.getElementById('resultados');
            resultadoContainer.innerHTML = '';
        }

        function toggleInstrucoes() {
            var balao = document.getElementById('balao-instrucoes');
            var overlay = document.getElementById('overlay');
            if (balao.style.display === 'block') {
                balao.style.display = 'none';
                overlay.style.display = 'none'; 
            } else {
                balao.style.display = 'block';
                overlay.style.display = 'block'; 
            }
        }

        function fecharInstrucoes() {
            var balao = document.getElementById('balao-instrucoes');
            var overlay = document.getElementById('overlay');
            balao.style.display = 'none';
            overlay.style.display = 'none'; 
        }

        function removerDisciplina(botao) {
            botao.parentNode.remove();
        }

        
        function mostrarOverlay() {
            var overlay = document.getElementById('overlay');
            overlay.style.display = 'block';
        }

        
        function ocultarOverlay() {
            var overlay = document.getElementById('overlay');
            overlay.style.display = 'none';
        }