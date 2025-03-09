//Esse arquivo define um controlador para criar usuários.

import { Request, Response } from "express";
import { CreateUserService } from "../../service/User/CreateUserService";

class CreateUserController {
    async handle(request: Request, response: Response){
        const { name, email, admin, password} = request.body; // Recebe os dados do corpo da requisição
        
        const createUserService = new CreateUserService(); // Cria um objeto de serviço
        
        const user = await createUserService.execute({name, email, admin, password}); // Cria um objeto user com os dados recebidos
        
        
        response.json(user);  
    }
}
export { CreateUserController };