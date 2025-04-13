import { IClientRequest } from "../../Interface/IClientInterface";
import { ClientsRepositories } from "../../repositories/ClientsRepositories";
import { getCustomRepository } from "typeorm";

class UpdateClientService {
    async execute({ id, name, email, phone, address, neighborhood, city, state }: IClientRequest & { id: string }) {
        if(!id) {
            throw new Error("ID vazio!");
        }
               
        const clientsRepositories = getCustomRepository(ClientsRepositories);
        const clientAlreadyExists = await clientsRepositories.findOne({
            id,
        });
        if (!clientAlreadyExists) {
            throw new Error("Cliente não existe!");
        }

        if (name !== undefined) clientAlreadyExists.name = name
        if (email !== undefined) clientAlreadyExists.email = email
        if (phone !== undefined) clientAlreadyExists.phone = phone
        if (address !== undefined) clientAlreadyExists.address = address
        if (neighborhood !== undefined) clientAlreadyExists.neighborhood = neighborhood
        if (city !== undefined) clientAlreadyExists.city = city
        if (state !== undefined) clientAlreadyExists.state = state
        clientAlreadyExists.updated_at = new Date()
        await clientsRepositories.update(id, clientAlreadyExists)

        return clientAlreadyExists;
    }
}
export { UpdateClientService };