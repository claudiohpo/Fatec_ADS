# 📱 Mobile App Frontend - Programação para Dispositivos Móveis

![Expo](https://img.shields.io/badge/Expo-000020?style=for-the-badge&logo=expo&logoColor=white)
![React Native](https://img.shields.io/badge/React_Native-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge)

> Projeto de frontend desenvolvido para a disciplina **Programação para Dispositivos Móveis** 🎓.

---

## 📝 Descrição

Este projeto é o **front-end** de um aplicativo móvel criado com **Expo** e **React Native**, integrado à API backend desenvolvida na disciplina. Ele inclui telas de autenticação, recuperação de senha, cadastro de usuário e listagem de produtos.

- As **telas iniciais** de **Login**, **Recuperação de Senha** (esqueci senha, verificação de e-mail e redefinição de senha) foram apresentadas pelo professor e implementadas em aula.
- As demais telas (**Cadastro de Usuário**: dados pessoais, foto de perfil e endereço, e **Home/Produtos**) foram implementadas por mim.

---

## 📸 Telas

- **Start**: tela inicial com logo
- **Signin**: login
- **Forget Password**: solicitação de redefinição
- **Check Email**: instruções de verificação
- **Password**: nova senha
- **Account Data**: dados pessoais
- **Personal Data**: informações de usuário
- **Profile Photo**: upload de foto
- **Address** e **Address2**: formulário de endereço
- **Profile Created**: confirmação de cadastro
- **Home**: página inicial de produtos
- **Products**: listagem de produtos

---

## 📂 Estrutura do Projeto

```
.
├── App.tsx                # Entry point
├── src/
│   ├── screens/           # Telas da aplicação
│   │   ├── start/         # Tela inicial
│   │   ├── signin/        # Login
│   │   ├── forget_password/
│   │   ├── check_email/
│   │   ├── password/
│   │   ├── account_data/
│   │   ├── personanal_data/
│   │   ├── profile_photo/
│   │   ├── address/
│   │   ├── address2/
│   │   ├── profile_created/
│   │   ├── home/
│   │   └── products/
│   ├── navigation/        # Configuração de rotas (React Navigation)
│   └── assets/            # Imagens e ícones
├── assets/                # Splash e ícones
├── app.json               # Configuração do Expo
└── package.json
```

---

## 🚀 Tecnologias

- **Expo**  
- **React Native**  
- **TypeScript**  
- **React Navigation** (`@react-navigation/native`, `@react-navigation/stack`)  
- **Mask Input** (`react-native-mask-input`)  
- **Expo Linear Gradient**  
- **Google Fonts** (`@expo-google-fonts/nunito`)

---

## 💻 Como Executar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio

# Instale as dependências
yarn install
# ou
npm install

# Inicie o aplicativo
yarn expo start
# ou
npm run expo start
```

Use um emulador ou o **Expo Go** no seu dispositivo móvel para testar.

---

## 👨‍💻 Autor

**Cláudio Oliveira**  
📧 claudio.oliveira@example.com  
🔗 [LinkedIn](https://www.linkedin.com/in/claudio-oliveira)
