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
        
        if (name !== undefined) supplierAlreadyExists.name = name;
        if (cnpj !== undefined) supplierAlreadyExists.cnpj = cnpj;
        if (email !== undefined) supplierAlreadyExists.email = email;
        if (phone !== undefined) supplierAlreadyExists.phone = phone;
        if (address !== undefined) supplierAlreadyExists.address = address;
        if (neighborhood !== undefined) supplierAlreadyExists.neighborhood = neighborhood;
        if (city !== undefined) supplierAlreadyExists.city = city;
        if (state !== undefined) supplierAlreadyExists.state = state;
        if (zipCode !== undefined) supplierAlreadyExists.zipCode = zipCode;
        if (bank !== undefined) supplierAlreadyExists.bank = bank;
        if (agency !== undefined) supplierAlreadyExists.agency = agency;
        if (account !== undefined) supplierAlreadyExists.account = account;
        if (accountType !== undefined) supplierAlreadyExists.accountType = accountType;
        supplierAlreadyExists.updated_at = new Date();
        
        await suppliersRepositories.update(id, supplierAlreadyExists);
        return supplierAlreadyExists;
    }
}
export { UpdateSupplierService };