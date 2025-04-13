//Esse arquivo define um controlador para criar usuários.
import { Request, Response } from "express";
import { CreateUserService } from "../../service/User/CreateUserService";

class CreateUserController {
    async handle(request: Request, response: Response){
        const { name, email, admin, password} = request.body; // Recebe os dados do corpo da requisição
        
        const createUserService = new CreateUserService(); // Cria um objeto de serviço
        
        try {
            const user = await createUserService.execute({
                name, 
                email, 
                admin, 
                password}); // Cria um objeto user com os dados recebidos
            return response.status(201).json(user); // Retorna o usuário criado com status 201
        } catch (error) {
            if (error instanceof Error) {
                return response.status(400).json({ message: error.message }); // Retorna erro 400 se houver erro
            }
            return response.status(500).json({ message: "Erro interno do servidor" }); // Retorna erro 500 para erros internos
        }
    }
}
export { CreateUserController };