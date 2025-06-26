# 🐾 Clínica Veterinária – Projeto de Software

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![Spark–Java](https://img.shields.io/badge/Spark–Java-E31B23?style=for-the-badge&logo=apache-spark&logoColor=white)
![Status](https://img.shields.io/badge/status-concluído-brightgreen?style=for-the-badge)

> Sistema de gestão de clínica veterinária, desenvolvido em equipe para a disciplina **Engenharia de Software III** 🎓.

---

## 📄 Sumário

1. [Equipe](#-equipe)  
2. [Visão Geral](#-visão-geral)  
3. [Principais Funcionalidades](#-principais-funcionalidades)  
4. [Arquitetura e Padrões de Projeto](#-arquitetura-e-padrões-de-projeto)  
5. [Estrutura do Projeto](#-estrutura-do-projeto)  
6. [Tecnologias Utilizadas](#-tecnologias-utilizadas)  
7. [Como Executar](#-como-executar)  
8. [Fluxo de Uso](#-fluxo-de-uso)  
9. [Licença](#-licença)  

---

## 👥 Equipe

- **Cláudio Henrique** 
- **Mariana Gomes** 
- **Gabriel Meireles**  

---

## 🔍 Visão Geral

Este projeto consiste em uma aplicação **full-stack** para gerenciar operações em uma clínica veterinária, incluindo:

- **Backend**: API RESTful em **Java** com **Spark Framework**, persistência em **MongoDB**.  
- **Frontend**: SPA em **HTML/CSS/JavaScript** (vanilla), consumindo a API para CRUD de pets, donos, veterinários e consultas.  

O foco da disciplina foi aplicar boas práticas de engenharia de software, organizar o código em camadas e utilizar padrões de projeto para garantir manutenibilidade e escalabilidade.

---

## ⭐ Principais Funcionalidades

1. **Gestão de Médicos Veterinários**
   - Cadastro, listagem, edição e exclusão de médicos veterinários.

2. **Gestão de Donos e Pets**  
   - Cadastro, listagem, edição e exclusão de donos.  
   - Cadastro, associação e histórico de pets por dono.  

3. **Atendimentos e Consultas**  
   - Agendamento de consultas.  
   - Registro de diagnóstico e prescrição de medicamentos.  
   - Controle de histórico de atendimentos.  

4. **Controle de Estoque de Medicamentos**  
   - CRUD de medicamentos.  
   - Controle de quantidade em estoque (alertas de baixo estoque em evolução).  

---

## 🏗️ Arquitetura e Padrões de Projeto

O projeto segue uma arquitetura em camadas, separando responsabilidades para facilitar testes e evolução:

- **Camada de API (`com.clinicaveterinaria.api`)**  
  Controladores REST usando *Spark Framework* para definir rotas HTTP.

- **Camada de Serviço**  
  Lógica de negócio isolada em classes `Service`, garantindo regras consistentes.

- **Camada DAO (`.dao`)**  
  Acesso a dados no **MongoDB** via padrão **DAO** (Data Access Object).

- **Singleton**  
  A classe `MongoDBConnection` garante única instância de conexão com o banco.

- **Adapter**  
  `DocumentAdapter` converte documentos Mongo para objetos de domínio e vice-versa.

- **MVC (no Frontend)**  
  - **Model**: objetos JavaScript que espelham as entidades.  
  - **View**: templates HTML injetados dinamicamente.  
  - **Controller**: `script.js` gerencia chamadas à API e manipulação de DOM.

---

## 📂 Estrutura do Projeto

```
ClinicaVet/
├── backend/
│   ├── src/
│   │   ├── api/                      # Controllers REST (Spark)
│   │   ├── service/                  # Regras de negócio
│   │   ├── dao/                      # Data Access Objects (MongoDB)
│   │   ├── model/                    # Entidades (Owner, Pet, Consultation…)
│   │   ├── singleton/                # MongoDBConnection (Singleton)
│   │   └── adapter/                  # DocumentAdapter
│   ├── pom.xml                       # Configuração Maven
│   └── README.md                     # Instruções específicas do backend
│
└── frontend/
    ├── index.html                   # SPA principal
    ├── css/
    │   └── style.css                # Estilos gerais
    ├── js/
    │   └── script.js                # Lógica de View/Controller
    └── assets/                      # Imagens e ícones
```

---

## 🔧 Tecnologias Utilizadas

| Camada      | Tecnologia                        |
|-------------|-----------------------------------|
| **Backend** | Java • Spark Framework • MongoDB  |
| **Frontend**| HTML5 • CSS3 • JavaScript (ES6)   |
| **Build**   | Maven                             |
| **Testes**  | Postman (coleções de API)         |

---

### 🚀 Como Executar

#### 1. Backend

1. Configure o MongoDB (local ou Docker) na porta padrão (27017).  
2. No diretório `backend/`:
   ```bash
   mvn clean install
   mvn exec:java
   ```
3. A API ficará disponível em `http://localhost:4567/`.

#### 2. Frontend

1. Abra `frontend/index.html` diretamente no navegador (não necessita servidor).  
2. A SPA consumirá a API em `http://localhost:4567/`.

---

### 🔄 Fluxo de Uso

1. **Cadsatro de Veternário**: preencha dados e clique em "Cadastrar Veterinário".   
3. **Cadastro de Dono(Cliente)**: preencha dados e clique em "Cadastrar Cliente".  
4. **Cadastro de Pet**: selecione dono, informe dados do pet e clique em "Cadastrar Pet".  
5. **Agendamento de Consulta**: escolha pet, data, hora, descritivo e clique em "Salvar Agendamento". 
6. **Receituário**:  escolha pet, veterinário, adicione diagnóstico, medicamentos prescritos, data do atendimento e clique em "Salvar Receituário".
7. **Cadastro de Medicamentos**: preencha os dados e clique em "Cadastrar Medicamento". 


---
## 👨‍💻 Autores

> Desenvolvido por Cláudio Henrique, Mariana Gomes e Gabriel Meireles.
> Fatec Mogi das Cruzes - SP
