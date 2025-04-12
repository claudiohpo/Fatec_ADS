import { ISupplierRequest } from "../../Interface/ISupplierInterface";
import { SuppliersRepositories } from "../../repositories/SuppliersRepositories";
import { getCustomRepository } from "typeorm";

class UpdateSupplierService {
    async execute({ id, name, cnpj, email, phone, address, neighborhood, city, state, zipCode, bank, agency, account, accountType }: ISupplierRequest) {
        if (!id) {
            throw new Error("ID vazio!");
        }
        
        const suppliersRepositories = getCustomRepository(SuppliersRepositories);
        const supplierAlreadyExists = await suppliersRepositories.findOne({
            id,
        });
        if (!supplierAlreadyExists) {
            throw new Error("Fornecedor não existe!");
        }
        supplierAlreadyExists.name = name;
        supplierAlreadyExists.cnpj = cnpj;
        supplierAlreadyExists.email = email;
        supplierAlreadyExists.phone = phone;
        supplierAlreadyExists.address = address;
        supplierAlreadyExists.neighborhood = neighborhood;
        supplierAlreadyExists.city = city;
        supplierAlreadyExists.state = state;
        supplierAlreadyExists.zipCode = zipCode;
        supplierAlreadyExists.bank = bank;
        supplierAlreadyExists.agency = agency;
        supplierAlreadyExists.account = account;
        supplierAlreadyExists.accountType = accountType;
        supplierAlreadyExists.updated_at = new Date();
        return await suppliersRepositories.update(id, supplierAlreadyExists);
    }
}
export { UpdateSupplierService };