import { ICategoryRequest } from "../../Interface/ICategoryInterface";

class UpdateCategoryService {
    async execute({ id, name, description }: ICategoryRequest) {
        if(!name) {
            throw new Error("Nome incorreto!");
        }
        var vcategory = {
            id: id,
            name: name,
            description: description
        };
        return vcategory;
    }
}
export { UpdateCategoryService };