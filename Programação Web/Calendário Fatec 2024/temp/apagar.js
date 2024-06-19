const monthNames = [
    "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
    "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
];
const dayContents = {
    // Preencher com os conteúdos de cada dia
    "2024-01-01": "Conteúdo do dia 1 de Janeiro",
    "2024-01-02": "Conteúdo do dia 2 de Janeiro",
    // Continue preenchendo conforme necessário
};

let currentMonth = new Date().getMonth();
let currentYear = new Date().getFullYear();

function generateCalendar(month, year) {
    const calendar = document.getElementById('calendar');
    calendar.innerHTML = '';

    const firstDay = new Date(year, month).getDay();
    const daysInMonth = new Date(year, month + 1, 0).getDate();

    document.getElementById('month-year').textContent = `${monthNames[month]} ${year}`;

    for (let i = 0; i < firstDay; i++) {
        calendar.innerHTML += '<div></div>';
    }

    for (let day = 1; day <= daysInMonth; day++) {
        const date = `${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
        const dayDiv = document.createElement('div');
        dayDiv.textContent = day;
        dayDiv.addEventListener('mouseover', () => showDayContent(date));
        calendar.appendChild(dayDiv);
    }
}

function showDayContent(date) {
    const dayContent = document.getElementById('day-content');
    dayContent.textContent = dayContents[date] || 'Sem conteúdo';
    dayContent.classList.add('active');
}

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

generateCalendar(currentMonth, currentYear);
