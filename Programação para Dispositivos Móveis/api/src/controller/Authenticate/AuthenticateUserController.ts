import { Request, Response } from "express";
import { AuthenticateUserService } from "../../service/Authenticate/AuthenticateUserService";

class AuthenticateUserController {
    async handle(request: Request, response: Response){
        const { email, password} = request.body; // Recebe os dados do corpo da requisição
        
        const authenticateUserService = new AuthenticateUserService(); // Cria um objeto de serviço
        
        const token = await authenticateUserService.execute({
            email, 
            password
        }); // Cria um objeto token com os dados recebidos
        
        response.json({message:token}); // Retorna o token em formato JSON
    }
}

export { AuthenticateUserController };