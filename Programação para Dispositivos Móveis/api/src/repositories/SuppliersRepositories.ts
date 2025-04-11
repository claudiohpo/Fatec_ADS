import { EntityRepository, Repository } from "typeorm";
import { Supplier } from "../entities/Supplier";

@EntityRepository(Supplier)
class SuppliersRepositories extends Repository<Supplier> {}

export { SuppliersRepositories };