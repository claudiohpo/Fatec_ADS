import { Request, Response } from "express";
import { UpdateSaleService } from "../../service/Sale/UpdateSaleService";

class UpdateSaleController {
    async handle(request: Request, response: Response){
        const { date, product, client, quantity, total} = request.body;

        const id = request.params.id;

        const updateSaleService = new UpdateSaleService();

        const sale = await updateSaleService.execute({id, date, product, client, quantity, total});

        response.json({sale});
    }
}
export { UpdateSaleController };