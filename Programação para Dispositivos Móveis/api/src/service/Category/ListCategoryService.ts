import { getCustomRepository } from "typeorm";
import { CategoriesRepositories } from "../../repositories/CategoriesRepositories";

class ListCategoryService{
    async execute(){
        const categoriesRepositories = getCustomRepository(CategoriesRepositories);

        const categories = await categoriesRepositories.find();
            
        return categories;
    }
}
export { ListCategoryService };