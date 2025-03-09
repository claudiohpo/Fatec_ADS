import { Request, Response} from "express";
import { ListCategoryService } from "../../service/Category/ListCategoryService";

class ListCategoryController {
    async handle(request: Request, response: Response){
        const categories=
        [
            {
                "name":"Categoria 1",
                "description":"Descrição da Categoria 1"
            },
            {
                "name":"Categoria 2",
                "description":"Descrição da Categoria 2"
            }
        ]
        response.json(categories);
    };
}

export {ListCategoryController};