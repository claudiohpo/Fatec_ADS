import { IProductRequest } from '../../Interface/IProductInterface';
import { ProductsRepositories } from '../../repositories/ProductsRepositories';
import { getCustomRepository } from 'typeorm';

class UpdateProductService {
    async execute({ id, name, description, price, category }: IProductRequest) {
        if(!id) {
            throw new Error("ID vazio!");
        }
        
        const productsRepositories = getCustomRepository(ProductsRepositories);
        const productAlreadyExists = await productsRepositories.findOne({   
            id,
        });
        if (!productAlreadyExists) {
            throw new Error("Produto não existe!");
        }

        if (name !== undefined) productAlreadyExists.name = name
        if (description !== undefined) productAlreadyExists.description = description
        if (price !== undefined) productAlreadyExists.price = price
        if (category !== undefined) productAlreadyExists.category = category
        
        productAlreadyExists.updated_at = new Date()
        await productsRepositories.update(id ,productAlreadyExists)

        return productAlreadyExists;
    }
}
export { UpdateProductService };