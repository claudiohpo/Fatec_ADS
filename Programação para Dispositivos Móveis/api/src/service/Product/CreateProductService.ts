import { IProductRequest } from '../../Interface/IProductInterface';

class CreateProductService {
    async execute({ name, description, price, category }: IProductRequest) {
        if(!name) {
            throw new Error("Nome incorreto!");
        }
        var vproduct = {
            name: name,
            description: description,
            price: price,
            category: category
        };
        return vproduct;
    }
}
export { CreateProductService };