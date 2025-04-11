import { getCustomRepository } from "typeorm";
import { SalesRepositories } from "../../repositories/SalesRepositories";

class ListSaleService {
    async execute() {
        const salesRepositories = getCustomRepository(SalesRepositories);
        const sales = await salesRepositories.find();

        
        
        // const sales = [
        //     {
        //         id: "1",
        //         date: "2021-09-01",
        //         product: "Produto 1",
        //         client: "Cliente 1",
        //         quantity: 1,
        //         total: 100.00,
        //     },
        //     {
        //         id: "2",
        //         date: "2021-09-02",
        //         product: "Produto 2",
        //         client: "Cliente 2",    
        //         quantity: 2,
        //         total: 200.00,
                
        //     }
        // ];
        return sales;
    }
}
export { ListSaleService };