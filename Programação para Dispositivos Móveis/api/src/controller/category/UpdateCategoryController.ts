import { Request, Response } from "express";
import { UpdateCategoryService } from "../../service/Category/UpdateCategoryService";

class UpdateCategoryController {
    async handle(request: Request, response: Response){
        const { name, description } = request.body;
        const id = request.params.id;

        const updateCategoryService = new UpdateCategoryService

        const category = await updateCategoryService.execute({
            id, 
            name, 
            description});
        // Retorna uma mensagem de sucesso e os dados da categoria atualizada
        response.json({
            message: `Registro ${id} atualizado com sucesso`,
            category
        });
    }
}
export { UpdateCategoryController };