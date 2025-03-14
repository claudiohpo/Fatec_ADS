import { Request, Response, NextFunction } from "express";
import { verify } from "jsonwebtoken";

interface IPayload {
    sub: string;email: string;
}
export function ensureAuthenticated(request: Request, response: Response, next: NextFunction) {
    //Receber o Token 
    const authToken = request.headers.authorization;
    //Validar se o token está preenchido
    if (!authToken) {
        return response.status(401).end();
    }
    const [, token] = authToken.split(" ");
    try {
        //Validar se o token é válido
        const {sub,email} = verify(token, "mobilefatec") as IPayload;
        console.log(email);
        console.log(sub);
        return next();
    }
    catch (err) {
        return response.status(401).end();
    }
}