import { EntityRepository, Repository } from "typeorm";
import { Sale } from "../entities/Sale";

@EntityRepository(Sale)
class SalesRepositories extends Repository<Sale> {}

export { SalesRepositories };