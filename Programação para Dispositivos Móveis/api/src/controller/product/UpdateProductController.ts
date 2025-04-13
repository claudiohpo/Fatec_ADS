import { Request, Response } from "express";
import { UpdateProductService } from "../../service/Product/UpdateProductService";

class UpdateProductController {
    async handle(request: Request, response: Response){
        const { name, category, description, price} = request.body;
        
        const id = request.params.id;
        
        const updateProductService = new UpdateProductService();

        const product = await updateProductService.execute({id, name, category, description, price});
       
        // Retorna uma mensagem de sucesso e os dados do produto atualizado
        response.json({
            message: `Registro ${id} atualizado com sucesso`,
            product
        });
    }
}
export { UpdateProductController};