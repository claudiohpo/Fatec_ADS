import { Request, Response } from "express";
class UpdateCategoryController {
    async handle(request: Request, response: Response){
        const { name } = request.body;
        const id = request.params.id;

        const category =
        {
            name:name
        };

        response.json({message:"Registro "+id + " atualizado com Sucesso"});  // Retorna uma mensagem de sucesso
    }
}
export { UpdateCategoryController };