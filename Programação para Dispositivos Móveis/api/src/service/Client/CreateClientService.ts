import { IClientRequest } from "../../Interface/IClientInterface";
import { ClientsRepositories } from "../../repositories/ClientsRepositories";
import { getCustomRepository } from "typeorm";

class CreateClientService {
    async execute({ name, email, phone, address, neighborhood, city, state }: IClientRequest) {
        if (!email) {
            throw new Error("Email incorreto!");
        }
        if (!address) {
            throw new Error("Endereço não pode ser vazio!");
        }

        const clientRepository = getCustomRepository(ClientsRepositories);

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