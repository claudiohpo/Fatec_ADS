const monthNames = [
    "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
    "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
];

let currentMonth = new Date().getMonth();
let currentYear = new Date().getFullYear();

const monthData = {
    //Janeiro
    "2024-01-01": "Confraternização Universal - Feriado",
    "2024-01-15": "Período das inscrições para vagas remanescentes e transferência / Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-01-16": "Período das inscrições para vagas remanescentes e transferência / Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-01-17": "Período das inscrições para vagas remanescentes e transferência / Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-01-18": "Período das inscrições para vagas remanescentes e transferência / Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-01-19": "Divulgação da classificação geral - Vestibular / Período das inscrições para vagas remanescentes e transferência / Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-01-20": "Período das inscrições para vagas remanescentes e transferência / Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-01-21": "Período das inscrições para vagas remanescentes e transferência / Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-01-22": "Matrícula da 1ª chamada - Vestibular",
    "2024-01-23": "Matrícula da 1ª chamada - Vestibular",
    "2024-01-24": "Matrícula da 1ª chamada - Vestibular",
    "2024-01-26": "Divulgação da classificação geral - Provão Paulista",
    "2024-01-29": "Divulgação da classificação geral - Provão Paulista",
    "2024-01-30": "Divulgação da classificação geral - Provão Paulista",

    //Fevereiro
    "2024-02-01": "Início do 1º semestre letivo de 2024 / Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-02": "Divulgação da lista da 2ª chamada - Vestibular / Divulgação da lista da 2ª chamada - Provão Paulista / Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-03": "Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-04": "Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-05": "Matrícula da 2ª chamada - Vestibular / Matrícula da 2ª chamada - Provão Paulista / Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-06": "Matrícula da 2ª chamada - Provão Paulista / Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-07": "Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-08": "Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-09": "Prazo máximo de validação dos dados dos alunos concluintes no SIGA pela Unidade de Ensino / Semana de Planejamento e Aperfeiçoamento Pedagógico - XIV SPAP",
    "2024-02-10": "Não haverá aula - Feriado - Carnaval/Quarta-feira de Cinzas",
    "2024-02-11": "Não haverá aula - Feriado - Carnaval/Quarta-feira de Cinzas",
    "2024-02-12": "Não haverá aula - Feriado - Carnaval/Quarta-feira de Cinzas",
    "2024-02-13": "Não haverá aula - Feriado - Carnaval/Quarta-feira de Cinzas",
    "2024-02-14": "Não haverá aula - Feriado - Carnaval/Quarta-feira de Cinzas",
    "2024-02-15": "Início das Aulas do 1º semestre letivo de 2024 (Presencial e EAD) / Acolhimento dos Calouros - Direção/Coordenadores de Curso",
    "2024-02-16": "Acolhimento dos Calouros - Direção/Coordenadores de Curso",
    "2024-02-17": "Acolhimento dos Calouros - Direção/Coordenadores de Curso",
    "2024-02-22": "Prazo máximo para aplic. de Exames de Proficiência com possibilidade de acomodação de matrícula para todos os alunos / Prazo final de matrículas para vagas remanescentes e transferências",
    "2024-02-23": "Prazo final de alterações de matrículas para acomodação de horários (art. 33 Regulamento)",
    "2024-02-25": "Prazo final para os docentes inserirem Plano de Ensino no SIGA",
    "2024-02-26": "Matrícula de alunos especiais nas disciplinas em que houver vaga (art. 33 Regulamento §2º)",
    "2024-02-29": "Prazo final para as Coordenadorias de Curso aprovarem e publicarem os planos de ensino inseridos no SIGA entregue pelos docentes - Portaria 36/2016 e IN Cesu 03/2018. / Cancelamento de alunos ingressantes com ausência injustificada nas 2 primeiras semanas de aulas ( Art. 36 Inciso I)",
    
    //Março
    "2024-03-01": "Matrícula de alunos por ocasião de cancelamento de matrículas, quando houver (Art. 36 Regulamento)",
    "2024-03-02": "Reposição de aula referente à quarta-feira AGRO, ADS, LOG e RH",
    "2024-03-15": "Prazo final de matrícula de ingressantes (Fechamento do sistema de matrícula remota) / DSA envia mensagem ao aluno com trancamento automático para manutenção da vaga, via SIGA.",
    "2024-03-16": "Prazo máximo para Aplicação de Exames de Proficiência sem possibilidade de acomodação de matrícula / Reposição de aula referente à sexta-feira AGRO, ADS, LOG e RH",
    "2024-03-17": "Prazo máximo para envio do Relatório de Autoavaliação CPA para CESU/protocolar sistema e-Mec (Portaria Cesu 09/2019)",
    "2024-03-18": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-19": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-20": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-21": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024 / Validação dos Dados do SIGA pela Unidade de Ensino - (Fechamento do SIGA - Port. CESU 09/2019)",
    "2024-03-22": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-23": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-24": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-25": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-26": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-27": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024",
    "2024-03-28": "Prazo para entrega da disponibilidade de horário para 2º semestre de 2024 / Coleta de dados estatísticos pela CESU / Envio do relatório mensal de progressão das HAEs",
    "2024-03-29": "Não haverá aula - Emenda de Feriado - Paixão de Cristo/Páscoa",
    "2024-03-30": "Não haverá aula - Emenda de Feriado - Paixão de Cristo/Páscoa",

    //Abril
    "2024-04-01": "Confecção dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso",
    "2024-04-02": "Confecção dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso",
    "2024-04-03": "Confecção dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso",
    "2024-04-04": "Confecção dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso",
    "2024-04-05": "Confecção dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso",
    "2024-04-06": "Confecção dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso / Reposição de aula referente ao sábado AGRO, ADS, LOG e RH",
    "2024-04-08": "Entrega dos horários de aulas do 2º/2024 aos docentes a fim de conferência (Instrução Normativa 02/2009)",
    "2024-04-16": "Entrega dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso a Diretoria Administrativa",
    "2024-04-17": "Entrega dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso a Diretoria Administrativa",
    "2024-04-18": "Entrega dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso a Diretoria Administrativa",
    "2024-04-19": "Entrega dos horários de aulas do 2º/2024 pelas Coordenadorias de Curso a Diretoria Administrativa",
    "2024-04-20": "Prazo final para lançamento de notas do 1o bimestre no Siga - IN Cesu 03/2018.",
    "2024-04-21": "Tiradentes",
    "2024-04-22": "Conferência dos horários de aulas do 2º/2024 pela Diretoria Administrativa",
    "2024-04-23": "Conferência dos horários de aulas do 2º/2024 pela Diretoria Administrativa",
    "2024-04-24": "Conferência dos horários de aulas do 2º/2024 pela Diretoria Administrativa",
    "2024-04-25": "Conferência dos horários de aulas do 2º/2024 pela Diretoria Administrativa",
    "2024-04-26": "Conferência dos horários de aulas do 2º/2024 pela Diretoria Administrativa",
    "2024-04-27": "Conferência dos horários de aulas do 2º/2024 pela Diretoria Administrativa",
    "2024-04-24": "Prazo final para desistência de disciplina (Art. 34 Regulamento)",
    "2024-04-30": "Envio do relatório mensal de progressão das HAEs",

    //Maio
    "2024-05-01": "Não haverá aula - Feriado Dia do Trabalho",
    "2024-05-04": "Avaliações presenciais do EaD - P1",
    "2024-05-06": "Avaliações presenciais do EAD - P1 Substitutiva",
    "2024-05-18": "Prazo final para trancamento de matrículas, exceto para alunos ingressantes (Art. 35 Regulamento)",
    "2024-05-29": "Envio do relatório mensal de progressão das HAEs",
    "2024-05-30": "Não haverá aula - Emenda de Feriado - Corpus Christi",
    "2024-05-31": "Não haverá aula - Emenda de Feriado - Corpus Christi",

    //Junho
    "2024-06-01": "Não haverá aula - Emenda de Feriado - Corpus Christi",
    "2024-06-05": "Workshop dos Trabalhos de Graduação - Cursos Logística e Gestão de Recursos Humanos",
    "2024-06-06": "Workshop dos Trabalhos de Graduação - Cursos Logística e Gestão de Recursos Humanos",
    "2024-06-07": "Workshop dos Trabalhos de Graduação - Cursos Logística e Gestão de Recursos Humanos",
    "2024-06-17": "Workshop dos Trabalhos de Graduação - Curso Análise Desenvolvimento de Sistemas",
    "2024-06-18": "Workshop dos Trabalhos de Graduação - Curso Análise Desenvolvimento de Sistemas e Curso Agronegócio",
    "2024-06-19": "Workshop dos Trabalhos de Graduação - Curso Análise Desenvolvimento de Sistemas e Curso Agronegócio",
    "2024-06-20": "Workshop dos Trabalhos de Graduação - Curso Análise Desenvolvimento de Sistemas / Entrega do relatório final das HAEs",
    "2024-06-21": "Workshop dos Trabalhos de Graduação - Curso Análise Desenvolvimento de Sistemas",
    "2024-06-22": "Avaliações presenciais do EaD - P2",
    "2024-06-24": "Avaliações presenciais do EaD - P2 substitutiva / Reunião de fechamento com a direção",
    "2024-06-24": "Envio da Chave de Segurança do sistema SIGA para fechamento do sistema com 20 semanas letivas pelos docentes",
    "2024-06-29": "Avaliações presenciais do EaD - Prova final",

    //Julho
    "2024-07-03": "Prazo final para entrega de médias finais pelos docentes (Presencial e EaD)",
    "2024-07-06": "Término das aulas do 1º semestre de 2024",
    "2024-07-08": "Prazo final para os alunos solicitarem revisão de notas - (art. 41 Regulamento)",
    "2024-07-09": "Dia da Revolução Constitucionalista",
    "2024-07-13": "Divulgação pelos docentes dos resultados de revisão de notas / Prazo final para dos docentes fazerem erratas (Art. 41)",
    "2024-07-15": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-16": "Não haverá aula - Recesso escolar docente e discente",
    "2024-07-17": "Não haverá aula - Recesso escolar docente e discente",
    "2024-07-18": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-19": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-20": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-21": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-22": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-23": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-24": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-25": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-26": "Dia da Padroeira da cidade - Nossa Sra. de Sant´Ana / Não haverá aula - Recesso escolar docente e discente",
    "2024-07-27": "Não haverá aula - Recesso escolar docente e discente", 
    "2024-07-28": "Não haverá aula - Recesso escolar docente e discente",         
    "2024-07-29": "Previsão - Período das Inscrições para vagas remanescentes e transferências / Previsão - Rematrícula de Alunos Veteranos (Presencial e EaD) / Não haverá aula - Recesso escolar docente e discente",
    "2024-07-30": "Previsão - Período das Inscrições para vagas remanescentes e transferências / Previsão - Rematrícula de Alunos Veteranos (Presencial e EaD) / Não haverá aula - Recesso escolar docente e discente",
    "2024-07-31": "Previsão - Período das Inscrições para vagas remanescentes e transferências / Previsão - Rematrícula de Alunos Veteranos (Presencial e EaD) / Não haverá aula - Recesso escolar docente e discente",


    //Agosto
    "2024-08-01": "Previsão de Início do 2º Semestre Letivo 2024 / Previsão - Período das Inscrições para vagas remanescentes e transferências / Previsão - Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-08-02": "Previsão - Período das Inscrições para vagas remanescentes e transferências / Previsão - Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-08-03": "Previsão - Período das Inscrições para vagas remanescentes e transferências / Previsão - Rematrícula de Alunos Veteranos (Presencial e EaD)",
    "2024-08-05": "Previsão de Início das aulas do 2º Semestre Letivo de 2024",

    //Setembro

    //Outubro

    //Novembro

    //Dezembro
};

function generateCalendar(month, year) {
    const calendar = document.getElementById('calendar');
    calendar.innerHTML = '';

    const firstDay = new Date(year, month).getDay();
    const daysInMonth = new Date(year, month + 1, 0).getDate();

    document.getElementById('month-year').textContent = `${monthNames[month]} ${year}`;

    for (let day = 0; day < 7; day++) {
        const span = document.createElement('span');
        span.textContent = ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'][day];
        calendar.appendChild(span);
    }

    // Adiciona divs vazias apenas se o primeiro dia do mês não for domingo (valor 0)
    if (firstDay !== 0) {
        for (let i = 0; i < firstDay; i++) {
            const emptyDayDiv = document.createElement('div');
            emptyDayDiv.classList.add('empty-day');
            calendar.appendChild(emptyDayDiv);
        }
    }

    for (let day = 1; day <= daysInMonth; day++) {
        const date = `${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
        const dayDiv = document.createElement('div');
        dayDiv.textContent = day;
        dayDiv.dataset.date = date; // Adiciona atributo data-date com a data
        dayDiv.addEventListener('mouseover', () => showDayContent(date));
        dayDiv.addEventListener('mouseout', hideDayContent);
        calendar.appendChild(dayDiv);
    }
    highlightDaysWithContent();
}

// Função para realizar uma varredura inicial e destacar os dias com conteúdo no calendário
function highlightDaysWithContent() {
    const calendar = document.getElementById('calendar');

    for (const date in monthData) {
        if (monthData.hasOwnProperty(date)) {
            const dayElement = calendar.querySelector(`[data-date='${date}']`);
            if (dayElement) {
                dayElement.style.backgroundColor = 'lightblue';
            }
        }
    }
}

function showDayContent(date) {
    const dayContent = document.getElementById('day-content');
    const content = monthData[date] || 'Sem conteúdo';
    if (content !== 'Sem conteúdo') {
        dayContent.textContent = content;
        dayContent.classList.add('active');
    } else {
        dayContent.classList.remove('active');
        dayContent.textContent = '';
    }
}

function hideDayContent() {
    const dayContent = document.getElementById('day-content');
    dayContent.classList.remove('active');
}

/*
function adjustCalendarSize() {
    const calendar = document.getElementById('calendar');
    const dayDivs = calendar.querySelectorAll('div');
    dayDivs.forEach(dayDiv => {
        dayDiv.style.width = '50px';  // Ajuste a largura conforme necessário
        dayDiv.style.height = '50px'; // Ajuste a altura conforme necessário
    });
}
*/

document.addEventListener('DOMContentLoaded', () => {
    adjustCalendarSize();
});


document.getElementById('prev-month').addEventListener('click', () => {
    if (currentMonth === 0) {
        currentMonth = 11;
        currentYear--;
    } else {
        currentMonth--;
    }
    generateCalendar(currentMonth, currentYear);
});

document.getElementById('next-month').addEventListener('click', () => {
    if (currentMonth === 11) {
        currentMonth = 0;
        currentYear++;
    } else {
        currentMonth++;
    }
    generateCalendar(currentMonth, currentYear);
});

// Carregar o calendário inicial
generateCalendar(currentMonth, currentYear);
