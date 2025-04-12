import { getCustomRepository } from "typeorm";
import { SuppliersRepositories } from "../../repositories/SuppliersRepositories";

class ListSupplierService {
    async execute() {
        const suppliersRepositories = getCustomRepository(SuppliersRepositories);

        const suppliers = await suppliersRepositories.find();

        return suppliers;
    }
}
export { ListSupplierService };