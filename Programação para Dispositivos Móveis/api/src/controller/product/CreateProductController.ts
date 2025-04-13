import { Request, Response } from "express";
import { CreateProductService } from "../../service/Product/CreateProductService";

class CreateProductController {
    async handle(request: Request, response: Response){
        const { name, category, description, price} = request.body; 
        
        const createProductService = new CreateProductService();
        
        try {
            const product = await createProductService.execute({
                name, 
                category, 
                description, 
                price});
            return response.status(201).json(product); 
        } catch (error) {
            if (error instanceof Error) {
                return response.status(400).json({ message: error.message });
            }
            return response.status(500).json({ message: "Erro interno do servidor" });
        }
    }
}
export { CreateProductController };