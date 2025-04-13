import { Request, Response } from "express";
import { CreateCategoryService } from "../../service/Category/CreateCategoryService";

class CreateCategoryController {
    async handle(request: Request, response: Response) {
        const { name, description } = request.body;

        const createCategoryService = new CreateCategoryService();

        try {
            const category = await createCategoryService.execute({
                name,
                description
            });
            // Retorna status 201 (Created) com os dados da categoria
            return response.status(201).json({
                message: `Categoria criada com sucesso:`,
                category});
        } catch (error) {
            if (error instanceof Error) {
                // Retorna 400 (Bad Request) com a mensagem do erro lançado no service
                return response.status(400).json({ message: error.message });
            }
            // Caso o erro não seja do tipo Error (algo mais grave/incomum)
            return response.status(500).json({ message: "Erro interno do servidor" });
        }
    }
}
export { CreateCategoryController };