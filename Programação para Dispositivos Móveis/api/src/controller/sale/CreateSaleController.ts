import { Request, Response } from "express";
import { CreateSaleService } from "../../service/Sale/CreateSaleService";

class CreateSaleController {
    async handle(request: Request, response: Response){
        const { date, product, client, quantity, total} = request.body;

        const createSaleService = new CreateSaleService();

        const sale = await createSaleService.execute({date, product, client, quantity, total});
        
        response.json({sale});
    }
}
export { CreateSaleController };