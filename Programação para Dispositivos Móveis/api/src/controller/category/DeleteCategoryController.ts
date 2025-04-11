import { Request, Response } from "express";
import { DeleteCategoryService } from "../../service/Category/DeleteCategoryService";

class DeleteCategoryController {
    async handle(request: Request, response: Response){
    const id = request.params.id;
    const deleteCategoryService = new DeleteCategoryService(); // Cria um objeto de serviço
    const msg = await deleteCategoryService.execute(id); // Chama o método execute do serviço

        response.json({message: "Registro " + id + "excluido com Sucesso!"});  // Retorna uma mensagem de sucesso
    }
}
export { DeleteCategoryController };