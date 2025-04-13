import { Request, Response } from "express";
import { CreateSaleService } from "../../service/Sale/CreateSaleService";

class CreateSaleController {
    async handle(request: Request, response: Response){
        const { date, product, client, quantity, total} = request.body;

        const createSaleService = new CreateSaleService();

        try {
            const sale = await createSaleService.execute({
                date, 
                product, 
                client, 
                quantity, 
                total});
            return response.status(201).json(sale); 
        } catch (error) {
            if (error instanceof Error) {
                return response.status(400).json({ message: error.message });
            }
            return response.status(500).json({ message: "Erro interno do servidor" });
        }
    }
}
export { CreateSaleController };