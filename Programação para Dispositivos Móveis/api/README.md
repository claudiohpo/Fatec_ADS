
# 📱 API Backend para Aplicativo de Gerenciamento Comercial

![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white)
![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Express](https://img.shields.io/badge/Express.js-000000?style=for-the-badge&logo=express&logoColor=white)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge)

> Projeto desenvolvido como parte da disciplina **Programação para Dispositivos Móveis** 🎓.

---

## 🧾 Descrição Geral

Esta aplicação backend fornece uma API RESTful para gerenciamento de um sistema comercial. Ela foi projetada para ser consumida por um aplicativo móvel, permitindo o controle completo de usuários, produtos, clientes, fornecedores, vendas e categorias. O sistema oferece autenticação via JWT, organização modular de código e integração com banco de dados relacional.

---

## 🧩 Funcionalidades

- 🔐 Autenticação de usuários (JWT)
- 👤 CRUD de Usuários
- 🧍‍♂️ CRUD de Clientes
- 🏷️ CRUD de Categorias
- 📦 CRUD de Produtos
- 🧾 CRUD de Vendas
- 🚚 CRUD de Fornecedores

---

## 📁 Estrutura de Pastas

```
src/
├── controller/          # Lida com requisições HTTP
├── service/             # Regras de negócio
├── repositories/        # Requisições ao banco
├── entities/            # Modelos das tabelas
├── Interface/           # Tipagens TypeScript
├── middleware/          # Autenticação JWT
├── database/            # Migrations e conexão com BD
├── routes.ts            # Rotas da aplicação
└── server.ts            # Ponto de entrada da API
```

---

## 🛠️ Tecnologias Utilizadas

- Node.js + Express
- TypeScript
- PostgreSQL (TypeORM)
- JWT para autenticação
- Yarn/NPM para gerenciamento de pacotes

---

## 🧪 Como Executar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio

# Instale as dependências
yarn install

# Configure o banco de dados no ormconfig.json

# Rode as migrations
yarn typeorm migration:run

# Inicie o servidor
yarn dev
```

---

## 🧑‍🏫 Projeto Acadêmico

Este projeto foi desenvolvido como parte da disciplina **Programação para Dispositivos Móveis**, com o objetivo de aplicar conceitos de backend no contexto de aplicações móveis, simulando um sistema de controle de estoque e vendas para pequenas empresas.

---

## 👨‍💻 Autor

**Seu Nome Aqui**  
📧 claudiohpo@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/claudiohpo/)

---