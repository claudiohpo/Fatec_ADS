import { ICategoryRequest } from "../../Interface/ICategoryInterface";

class CreateCategoryService {
    async execute({ name, description }: ICategoryRequest) {
        if(!name) {
            throw new Error("Nome incorreto!");
        }
        var vcategory = {
            name: name,
            description: description
        };
        return vcategory;
    }
}
export { CreateCategoryService };