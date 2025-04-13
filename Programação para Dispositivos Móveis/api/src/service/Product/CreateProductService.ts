import { IProductRequest } from '../../Interface/IProductInterface';
import { ProductsRepositories } from '../../repositories/ProductsRepositories';
import { getCustomRepository } from 'typeorm';

class CreateProductService {
    async execute({ name, description, price, category }: IProductRequest) {
        if (!name) {
            throw new Error("Nome incorreto!");
        }
        if (!description) {
            throw new Error("Descrição não pode ser vazia!");
        }
        if (!price || price <= 0) {
            throw new Error("Preço não pode ser vazio!");
        }
        if (!category) {
            throw new Error("Categoria não pode ser vazia!");
        }

        const productsRepositories = getCustomRepository(ProductsRepositories);
        const productAlreadyExists = await productsRepositories.findOne({ name });
        if (productAlreadyExists) {
            throw new Error("Produto já existe!");
        }

        const product = productsRepositories.create({
            name,
            description,
            price,
            category,
        });

        await productsRepositories.save(product);
        
        return product;
    }
}
export { CreateProductService };