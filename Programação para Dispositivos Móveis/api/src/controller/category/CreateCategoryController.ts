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

        // try {
        //     const category = await createCategoryService.execute({
        //         name, 
        //         description
        //     });
        //     return response.status(201).json(category);  // Retorna uma mensagem de sucesso
        // }catch (error) {
        //     return response.status(400).json({ error: error.message }); // Retorna uma mensagem de erro
        // }
    }
}
export { CreateCategoryController };