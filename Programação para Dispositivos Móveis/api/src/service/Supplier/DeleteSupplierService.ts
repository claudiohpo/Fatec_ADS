import { getCustomRepository } from "typeorm";
import { SuppliersRepositories } from "../../repositories/SuppliersRepositories";

class DeleteSupplierService{
    async execute(id: string) {
        const suppliersRepositories = getCustomRepository(SuppliersRepositories);
        const supplierAlreadyExists = await suppliersRepositories.findOne({id});
        
        if (!supplierAlreadyExists) {
            throw new Error("Fornecedor não existe!");
        }
        await suppliersRepositories.delete(id);

        var msg = {
            message: "Fornecedor " + id + " deletado com Sucesso!!"
        }
        return msg;
    }
}
export { DeleteSupplierService };