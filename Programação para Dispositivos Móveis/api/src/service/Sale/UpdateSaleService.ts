import { ISaleRequest } from "../../Interface/ISaleInterface";
import { SalesRepositories } from "../../repositories/SalesRepositories";
import { getCustomRepository } from "typeorm";

class UpdateSaleService {
    async execute({ id, date, product, client, quantity, total }: ISaleRequest) {
        if(!id) {
            throw new Error("ID vazio!");
        }
              
        const salesRepositories = getCustomRepository(SalesRepositories);
        const saleAlreadyExists = await salesRepositories.findOne({
            id,
        });
        if (!saleAlreadyExists) {
            throw new Error("Venda não existe!");
        }

        if (date !== undefined) saleAlreadyExists.date = date
        if (product !== undefined) saleAlreadyExists.product = product
        if (client !== undefined) saleAlreadyExists.client = client
        if (quantity !== undefined) saleAlreadyExists.quantity = quantity
        if (total !== undefined) saleAlreadyExists.total = total
        saleAlreadyExists.updated_at = new Date()
        await salesRepositories.update(id ,saleAlreadyExists)
        
        return saleAlreadyExists;
    }
}
export { UpdateSaleService };