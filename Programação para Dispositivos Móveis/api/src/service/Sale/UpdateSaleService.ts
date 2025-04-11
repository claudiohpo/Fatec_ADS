import { ISaleRequest } from "../../Interface/ISaleInterface";
import { SalesRepositories } from "../../repositories/SalesRepositories";
import { getCustomRepository } from "typeorm";

class UpdateSaleService {
    async execute({ id, date, product, client, quantity, total }: ISaleRequest) {
        if(!id) {
            throw new Error("ID vazio!");
        }
        if(!date) {
            throw new Error("Data incorreta!");
        }
        if(!product) {
            throw new Error("Produto vazio!");
        }
        if(!client) {
            throw new Error("Cliente vazio!");
        }
        if(!quantity) {
            throw new Error("Quantidade vazia!");
        }
        if(!total) {
            throw new Error("Total vazio!");
        }
        
        const salesRepositories = getCustomRepository(SalesRepositories);
        const saleAlreadyExists = await salesRepositories.findOne({
            id,
        });
        if (!saleAlreadyExists) {
            throw new Error("Venda não existe!");
        }

        saleAlreadyExists.date = date
        saleAlreadyExists.product = product
        saleAlreadyExists.client = client
        saleAlreadyExists.quantity = quantity
        saleAlreadyExists.total = total
        saleAlreadyExists.updated_at = new Date()
        await salesRepositories.update(id ,saleAlreadyExists)
        
        return saleAlreadyExists;
    }
}
export { UpdateSaleService };