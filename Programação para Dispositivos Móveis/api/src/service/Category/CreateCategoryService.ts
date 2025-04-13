import { ICategoryRequest } from "../../Interface/ICategoryInterface";
import { CategoriesRepositories } from "../../repositories/CategoriesRepositories";
import { getCustomRepository } from "typeorm";

class CreateCategoryService {
    async execute({ name, description }: ICategoryRequest) {
        if(!name) {
            throw new Error("Nome não pode estar vazio!");
        }

        if(!description) {
            throw new Error("Descrição não pode ser vazia!");
        }

        const categoriesRepositories = getCustomRepository(CategoriesRepositories);
        const categoryAlreadyExists = await categoriesRepositories.findOne({ name });
        if (categoryAlreadyExists) {
            throw new Error("Categoria já existe!");
        }
        const category = categoriesRepositories.create({
            name,
            description,
        });

        await categoriesRepositories.save(category);
        
        return category;
    }
}
export { CreateCategoryService };