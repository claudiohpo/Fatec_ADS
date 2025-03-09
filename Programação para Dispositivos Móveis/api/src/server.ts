//Inicia o servidor Express.

import express from "express";
import {router} from "./routes";

const app = express();

app.use(express.json()); // Permite que a API entenda JSON no body das requisições

app.use(router); // Aplica as rotas definidas em routes.ts

console.log("Start at =>3000"); //mostrar msg no console

app.listen(3000);