import { getCustomRepository } from "typeorm"; 
import { ClientsRepositories } from "../../repositories/ClientsRepositories";

class ListClientService {
    async execute() {
        const clientsRepositories = getCustomRepository(ClientsRepositories);

        const clients = await clientsRepositories.find();
        
        return clients;
    }
}
export { ListClientService };