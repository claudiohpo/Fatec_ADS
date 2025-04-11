import { IClientRequest } from "../../Interface/IClientInterface";
import { ClientsRepositories } from "../../repositories/ClientsRepositories";
import { getCustomRepository } from "typeorm";

class UpdateClientService {
    async execute({ id, name, email, phone, address, neighborhood, city, state }: IClientRequest & { id: string }) {
        if(!id) {
            throw new Error("ID vazio!");
        }
        if (!email) {
            throw new Error("Email incorreto!");
        }
        
        const clientsRepositories = getCustomRepository(ClientsRepositories);
        const clientAlreadyExists = await clientsRepositories.findOne({
            id,
        });
        if (!clientAlreadyExists) {
            throw new Error("Cliente não existe!");
        }

        clientAlreadyExists.name = name
        clientAlreadyExists.email = email
        clientAlreadyExists.phone = phone
        clientAlreadyExists.address = address
        clientAlreadyExists.neighborhood = neighborhood
        clientAlreadyExists.city = city
        clientAlreadyExists.state = state
        clientAlreadyExists.updated_at = new Date()
        await clientsRepositories.update(id, clientAlreadyExists)

        return clientAlreadyExists;
    }
}
export { UpdateClientService };