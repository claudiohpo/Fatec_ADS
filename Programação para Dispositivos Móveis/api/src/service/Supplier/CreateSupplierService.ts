import { ISupplierRequest } from "../../Interface/ISupplierInterface";
import { SuppliersRepositories } from "../../repositories/SuppliersRepositories";
import { getCustomRepository } from "typeorm";

class CreateSupplierService {
    async execute({ name, cnpj, email, phone, address, neighborhood, city, state, zipCode, bank, agency, account, accountType }: ISupplierRequest) {
        if (!name) {
            throw new Error("Nome vazio!");
        }
        if (!cnpj) {
            throw new Error("CNPJ vazio!");
        }
        if (!email) {
            throw new Error("Email vazio!");
        }
        if (!phone) {
            throw new Error("Telefone vazio!");
        }
        if (!address || !neighborhood || !city || !state || !zipCode) {
            throw new Error("Endereço incompleto, revise os dados!");
        }
        if(!bank || !agency || !account || !accountType) {
            throw new Error("Dados bancários obrigatórios vazios!");
        }
        const suppliersRepositories = getCustomRepository(SuppliersRepositories);
        const supplierAlreadyExists = await suppliersRepositories.findOne({cnpj,});
        if (supplierAlreadyExists) {
            throw new Error("Fornecedor já existe!");
        }

        const supplier = suppliersRepositories.create({name, cnpj, email, phone, address, neighborhood, city, state, zipCode, bank, agency, account, accountType});
        
        // Salvar no banco de dados
        await suppliersRepositories.save(supplier);
        return supplier;
    }
}
export { CreateSupplierService };