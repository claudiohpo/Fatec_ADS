import { IClientRequest } from "../../Interface/IClientInterface";
import { ClientsRepositories } from "../../repositories/ClientsRepositories";
import { getCustomRepository } from "typeorm";

class CreateClientService {
    async execute({ name, email, phone, address, neighborhood, city, state }: IClientRequest) {
        if(!name) {
            throw new Error("Nome incorreto!");
        }
        if (!email) {
            throw new Error("Email incorreto!");
        }
        if (!phone) {
            throw new Error("Telefone incorreto!");
        }

        const clientRepository = getCustomRepository(ClientsRepositories);

        const clientAlreadyExists = await clientRepository.findOne({
            where: [{ email }, { phone }],
        });
        if (clientAlreadyExists) {
            throw new Error("Cliente já existe!");
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