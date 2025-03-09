import { Request, Response } from "express";
import { CreateProductService } from "../../service/Product/CreateProductService";

class CreateProductController {
    async handle(request: Request, response: Response){
        const { name, category, description, price} = request.body; 
        const createProductService = new CreateProductService();
        const product = await createProductService.execute({name, category, description, price});
        
        response.json({product});
    }
}
export { CreateProductController };