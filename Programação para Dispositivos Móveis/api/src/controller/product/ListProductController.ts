import { Request, Response} from "express";
import { ListProductService } from "../../service/Product/ListProductService";

class ListProductController {
    async handle(request: Request, response: Response){
        const listProductService = new ListProductService();
        const products = await listProductService.execute();

        response.json(products);
    };
}

export {ListProductController};