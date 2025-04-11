import { getCustomRepository } from "typeorm";
import { CategoriesRepositories } from "../../repositories/CategoriesRepositories";

class DeleteCategoryService {
    async execute(id: string) {
        const categoriesRepositories = getCustomRepository(CategoriesRepositories); // Cria uma instância do repositório de categorias
        const categoryAlreadyExists = await categoriesRepositories.findOne({ id }); // Verifica se a categoria existe

        if (!categoryAlreadyExists) { // Se não existir, lança um erro
            throw new Error("Categoria não existe!");
        }
        await categoriesRepositories.delete(id); // Deleta a categoria do banco de dados

        var msg = {
            message: "Categoria " + id + " deletada com Sucesso!!" // Retorna uma mensagem de sucesso
        };
        return msg;
    }
}
export { DeleteCategoryService };