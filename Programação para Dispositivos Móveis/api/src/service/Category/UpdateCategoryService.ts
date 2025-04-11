import { ICategoryRequest } from "../../Interface/ICategoryInterface";
import { CategoriesRepositories } from "../../repositories/CategoriesRepositories";
import { getCustomRepository } from "typeorm";

class UpdateCategoryService {
    async execute({ id, name, description }: ICategoryRequest) {
        if(!id) {
            throw new Error("ID vazio!");
        }
        if(!name) {
            throw new Error("Nome incorreto!");
        }

        const categoriesRepositories = getCustomRepository(CategoriesRepositories);
        const categoryAlreadyExists = await categoriesRepositories.findOne({
            id,
        });
        if (!categoryAlreadyExists) {
            throw new Error("Categoria não existe!");
        }

        categoryAlreadyExists.name = name
        categoryAlreadyExists.description = description
        categoryAlreadyExists.updated_at = new Date()
        await categoriesRepositories.update(id ,categoryAlreadyExists)

        return categoryAlreadyExists;
    }
}
export { UpdateCategoryService };