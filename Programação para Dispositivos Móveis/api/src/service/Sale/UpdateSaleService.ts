import { ISaleRequest } from "../../Interface/ISaleInterface";

class UpdateSaleService {
    async execute({ id, date, product, client, quantity, total }: ISaleRequest) {
        if(!date) {
            throw new Error("Data incorreta!");
        }
        if(!product) {
            throw new Error("Produto incorreto!");
        }
        if(!client) {
            throw new Error("Cliente incorreto!");
        }
        if(!quantity) {
            throw new Error("Quantidade incorreta!");
        }
        if(!total) {
            throw new Error("Total incorreto!");
        }
        var vsale = {
            id:id,
            date: date,
            product: product,
            client: client,
            quantity: quantity,
            total: total
        };
        return vsale;
    }
}
export { UpdateSaleService };