import { Request, Response } from "express";
import { DeleteSaleService } from "../../service/Sale/DeleteSaleService";

class DeleteSaleController {
    async handle(request: Request, response: Response){
    const id = request.params.id;

    const deleteSaleService = new DeleteSaleService(); // Cria um objeto de serviço
    
    const msg = await deleteSaleService.execute(id); // Chama o método execute do serviço
    
    response.json({msg});  
    }
}
export { DeleteSaleController };