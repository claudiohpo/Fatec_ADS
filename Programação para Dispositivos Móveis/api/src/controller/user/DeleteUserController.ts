//Esse arquivo define um controlador para apagar usuários.

import { Request, Response } from "express";
import { DeleteUserService } from "../../service/User/DeleteUserService";

class DeleteUserController {
    async handle(request: Request, response: Response){
    const id = request.params.id;
    const deleteUserService = new DeleteUserService(); // Cria um objeto de serviço
    const msg = await deleteUserService.execute(id); // Chama o método execute do serviço

    response.json(msg);  // Retorna a mensagem de sucesso
    }
}
export { DeleteUserController };