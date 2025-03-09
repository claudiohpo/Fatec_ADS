import { Request, Response} from "express";
import { ListSaleService } from "../../service/Sale/ListSaleService";

class ListSaleController {
    async handle(request: Request, response: Response){
        const listSaleService = new ListSaleService();

        const sale = await listSaleService.execute();

        response.json(sale);
    };
}
export {ListSaleController};