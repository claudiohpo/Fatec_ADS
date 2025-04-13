import { Request, Response } from "express";
import { UpdateClientService } from "../../service/Client/UpdateClientService";

class UpdateClientController {
    async handle(request: Request, response: Response){
        const {name, phone, email, address, neighborhood, city, state} = request.body; 
        const id = request.params.id;

        const updateClientService = new UpdateClientService

        const client = await updateClientService.execute({id, name, phone, email, address, neighborhood, city, state});

        // Retorna uma mensagem de sucesso e os dados do cliente atualizado
        response.json({
            message: `Registro ${id} atualizado com sucesso`,
            client
        });
    }
}
export { UpdateClientController };