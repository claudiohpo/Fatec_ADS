//Inicia o servidor Express.
import express, { NextFunction,Response,Request} from "express";
import {router} from "./routes";
import "express-async-errors"; // Permite que o express entenda erros assíncronos
import "reflect-metadata";
import "./database/index"; // Importa a configuração do banco de dados

const app = express();

app.use(express.json()); // Permite que a API entenda JSON no body das requisições

app.use(router); // Aplica as rotas definidas em routes.ts

app.use(
    (err: Error, request: Request, response: Response, next: NextFunction) => {
        if (err instanceof Error) {
                response.status(400).send(err.message)
            }
            else{
                response.status(500).send("Erro interno do servidor")
            }
        }
)

console.log("Start at =>3000"); //mostrar msg no console

app.listen(3000);