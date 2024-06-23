document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('error-message');
    
    if (username != 'admin') {
        errorMessage.textContent = 'Usuário não encontrado.';
    } else {
        if (password != 'admin') {
            errorMessage.textContent = 'Senha incorreta.';
        } else {
            window.location.href = 'main/main.html';
        }
    }
});

document.getElementById('forgot-password').addEventListener('click', function() {
    document.getElementById('reset-password-dialog').style.display = 'flex';
});

document.querySelector('.dialog .close').addEventListener('click', function() {
    document.getElementById('reset-password-dialog').style.display = 'none';
    document.getElementById('reset-message').textContent = '';
});

function isValidCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g,'');
    if (cpf.length !== 11 || /^(\d)\1{10}$/.test(cpf)) {
        return false;
    }
    let sum = 0, remainder;
    for (let i = 1; i <= 9; i++) {
        sum += parseInt(cpf.substring(i-1, i)) * (11 - i);
    }
    remainder = (sum * 10) % 11;
    if (remainder === 10 || remainder === 11) {
        remainder = 0;
    }
    if (remainder !== parseInt(cpf.substring(9, 10))) {
        return false;
    }
    sum = 0;
    for (let i = 1; i <= 10; i++) {
        sum += parseInt(cpf.substring(i-1, i)) * (12 - i);
    }
    remainder = (sum * 10) % 11;
    if (remainder === 10 || remainder === 11) {
        remainder = 0;
    }
    if (remainder !== parseInt(cpf.substring(10, 11))) {
        return false;
    }
    return true;
}

document.getElementById('cpf').addEventListener('input', function(event) {
    this.value = this.value.replace(/[^\d]/g, '').slice(0, 11);
});


document.getElementById('send-cpf').addEventListener('click', function() {
    const cpf = document.getElementById('cpf').value;
    const resetMessage = document.getElementById('reset-message');
    
    if (cpf && isValidCPF(cpf)) {
        resetMessage.textContent = 'Confira sua caixa de e-mail para recuperar sua senha.';
        setTimeout(function() {
            document.getElementById('reset-password-dialog').style.display = 'none';
            document.getElementById('reset-message').textContent = '';
        }, 10000);
    } else {
        resetMessage.textContent = 'CPF inválido. Por favor, insira um CPF válido.';
    }
});