import { getCustomRepository } from "typeorm";
import { ProductsRepositories } from "../../repositories/ProductsRepositories";


class ListProductService {
    async execute() {
        const productsRepositories = getCustomRepository(ProductsRepositories);

        const products = await productsRepositories.find();

        return products;
    }
}
export { ListProductService };