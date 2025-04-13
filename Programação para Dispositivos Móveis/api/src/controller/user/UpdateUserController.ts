//Esse arquivo define um controlador para atualizar usuários.

import { Request, Response } from "express";
import { UpdateUserService } from "../../service/User/UpdateUserService";

class UpdateUserController {
    async handle(request: Request, response: Response){
        const { name, email, admin, password } = request.body; // Recebe os dados do corpo da requisição
        const id = request.params.id;

        const updateUserService = new UpdateUserService(); // Cria um objeto de serviço

        // Cria um objeto user com os dados recebidos
        const user = await updateUserService.execute({ id, name, email, admin, password });

        // Retorna uma mensagem de sucesso e os dados do usuário atualizado
        response.json({
            message: `Registro ${id} atualizado com sucesso`,
            user
        });
    }
}
export { UpdateUserController };