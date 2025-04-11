import { Request, Response} from "express";
import { ListCategoryService } from "../../service/Category/ListCategoryService";

class ListCategoryController {
    async handle(request: Request, response: Response){
    const listCategoryService = new ListCategoryService();
    const categories = await listCategoryService.execute();
        response.json(categories);
    };
}

export {ListCategoryController};