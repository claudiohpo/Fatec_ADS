import { Request, Response } from "express";
import { DeleteProductService } from "../../service/Product/DeleteProductService";

class DeleteProductController {
    async handle(request: Request, response: Response){
    const id = request.params.id;
    
    const deleteProductService = new DeleteProductService(); // Cria um objeto de serviço
    
    const msg = await deleteProductService.execute(id); // Chama o método execute do serviço

    response.json({msg});
    }
}
export { DeleteProductController };