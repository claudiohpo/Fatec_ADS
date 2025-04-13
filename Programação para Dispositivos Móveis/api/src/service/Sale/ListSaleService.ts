import { getCustomRepository } from "typeorm";
import { SalesRepositories } from "../../repositories/SalesRepositories";

class ListSaleService {
    async execute() {
        const salesRepositories = getCustomRepository(SalesRepositories);
        
        const sales = await salesRepositories.find();

        return sales;
    }
}
export { ListSaleService };