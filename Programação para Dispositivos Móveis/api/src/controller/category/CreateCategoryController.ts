import { Request, Response } from "express";
import { CreateCategoryService } from "../../service/Category/CreateCategoryService";

class CreateCategoryController {
    async handle(request: Request, response: Response){
        const { name, description } = request.body; 
        
        const createCategoryService = new CreateCategoryService();

        const category = await createCategoryService.execute({
            name, 
            description
        });
           
        response.json(category); // Retorna uma mensagem de sucesso
    }
}
export { CreateCategoryController };