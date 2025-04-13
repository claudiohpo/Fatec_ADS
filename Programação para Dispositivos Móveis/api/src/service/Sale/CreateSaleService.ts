import { ISaleRequest } from "../../Interface/ISaleInterface";
import { SalesRepositories } from "../../repositories/SalesRepositories";
import { getCustomRepository } from "typeorm";

class CreateSaleService {
    async execute({ date, product, client, quantity, total }: ISaleRequest) {
        if (!date) {
            throw new Error("Data vazia!");
        }
        if (!product) {
            throw new Error("Produto vazio!");
        }
        if (!client) {
            throw new Error("Cliente vazio!");
        }
        if (!quantity || quantity <= 0) {
            throw new Error("Quantidade vazia ou menor que zero!");
        }
        if (!total) {
            throw new Error("Total vazio!");
        }
            
        //Acessar o repositório de vendas
        const saleRepository = getCustomRepository(SalesRepositories);

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