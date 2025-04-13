import { IClientRequest } from "../../Interface/IClientInterface";
import { ClientsRepositories } from "../../repositories/ClientsRepositories";
import { getCustomRepository } from "typeorm";

class CreateClientService {
    async execute({ name, email, phone, address, neighborhood, city, state }: IClientRequest) {
        if(!name) {
            throw new Error("Nome não pode estar vazio!");
        }
        if (!email) {
            throw new Error("Email vazio!");
        }
        if (!phone) {
            throw new Error("Telefone vazio!");
        }
        if (!address) {
            throw new Error("Endereço vazio!");
        }
        if (!neighborhood) {
            throw new Error("Bairro vazio!");
        }
        if (!city) {
            throw new Error("Cidade vazio!");
        }
        if (!state) {
            throw new Error("Estado vazio!");
        }

        const clientRepository = getCustomRepository(ClientsRepositories);

        const clientAlreadyExists = await clientRepository.findOne({
            where: [
                { email: email },
                { phone: phone }
            ]
        });
        
        if (clientAlreadyExists) {
            throw new Error("Cliente já existe! Verique email e telefone!");
        }

        const client = clientRepository.create({
            name,
            email,
            phone,
            address,
            neighborhood,
            city,
            state
        });

        await clientRepository.save(client);

        return client;

    }
}
export { CreateClientService };