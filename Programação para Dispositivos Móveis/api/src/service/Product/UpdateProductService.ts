import { IProductRequest } from '../../Interface/IProductInterface';

class UpdateProductService {
    async execute({ id, name, description, price, category }: IProductRequest) {
        if(!name) {
            throw new Error("Nome incorreto!");
        }
        var vproduct = {
            id:id,
            name: name,
            description: description,
            price: price,
            category: category
        };
        return vproduct;
    }
}
export { UpdateProductService };