import { EntityRepository, Repository } from "typeorm";
import { Product } from "../entities/Product";

@EntityRepository(Product)
class ProductsRepositories extends Repository<Product> {}

export { ProductsRepositories };