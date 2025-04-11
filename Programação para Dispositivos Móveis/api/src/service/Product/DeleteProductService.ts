import { getCustomRepository } from "typeorm";
import { ProductsRepositories } from "../../repositories/ProductsRepositories";

class DeleteProductService {
    async execute(id: string) {
        const productsRepositories = getCustomRepository(ProductsRepositories);
        const productAlreadyExists = await productsRepositories.findOne({ id });	// Verifica se o produto existe

        if (!productAlreadyExists) {	// Se não existir, lança um erro
            throw new Error("Produto não existe!");
        }
        await productsRepositories.delete(id);	// Deleta o produto do banco de dados

        var msg = {
            message: "Produto " + id + " deletado com Sucesso!!"	// Retorna uma mensagem de sucesso
        }
        return msg;
    }
}
export { DeleteProductService };