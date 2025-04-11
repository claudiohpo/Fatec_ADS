import { getCustomRepository } from "typeorm";
import { ClientsRepositories } from "../../repositories/ClientsRepositories";

class DeleteClientService {
    async execute(id: string) {
        const clientsRepositories = getCustomRepository(ClientsRepositories);
        const clientAlreadyExists = await clientsRepositories.findOne({ id }); // Verifica se o cliente existe

        if (!clientAlreadyExists) { // Se não existir, lança um erro
            throw new Error("Cliente não existe!");
        }
        await clientsRepositories.delete(id); // Deleta o cliente do banco de dados
        
        var msg = {
            message: "Registro " + id + " deletado com Sucesso!!" // Retorna uma mensagem de sucesso
        };
        return msg;
    }
}
export { DeleteClientService };