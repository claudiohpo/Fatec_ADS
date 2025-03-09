import { Request, Response } from "express";
import { DeleteClientService } from "../../service/Client/DeleteClientService";

class DeleteClientController {
    async handle(request: Request, response: Response){
    const id = request.params.id;
    const deleteClientService = new DeleteClientService(); // Cria um objeto de serviço
    const msg = await deleteClientService.execute(id); // Chama o método execute do serviço
    
        response.json({message:"Registro " + id + " excluído com Sucesso"});
    }
}
export { DeleteClientController };