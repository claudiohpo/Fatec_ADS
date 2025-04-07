import { ISaleRequest } from "../../Interface/ISaleInterface";
import { SaleRepository } from "../../repositories/SaleRepository";
import { getCustomRepository } from "typeorm";

class CreateSaleService {
    async execute({ date, product, client, quantity, total }: ISaleRequest) {
        if (!date) {
            throw new Error("Data incorreta!");
        }
        if (!product) {
            throw new Error("Produto incorreto!");
        }
        if (!client) {
            throw new Error("Cliente incorreto!");
        }
        if (quantity <= 0) {
            throw new Error("Quantidade deve ser maior que zero!");
        }
        if (!total) {
            throw new Error("Total incorreto!");
        }
        
        //Acessar o repositório de vendas
        const saleRepository = getCustomRepository(SaleRepository);

        //cria a venda
        const sale = saleRepository.create({
            date,
            product,
            client,
            quantity,
            total,
        });

        // Salvar no banco de dados
        await saleRepository.save(sale);

        
        return sale;
    }
}
export { CreateSaleService };