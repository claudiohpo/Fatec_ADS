import { getCustomRepository } from "typeorm";
import { UsersRepositories } from "../../repositories/UsersRepositories";

class DeleteUserService {
    async execute(id: string) {
        const usersRepositories = getCustomRepository(UsersRepositories);	// Cria uma instância do repositório de usuários
        const userAlreadyExists = await usersRepositories.findOne({ id });	// Verifica se o usuário existe

        if (!userAlreadyExists) {	// Se não existir, lança um erro
            throw new Error("Usuário não existe!");
        }
        await usersRepositories.delete(id);	// Deleta o usuário do banco de dados
        
        var msg = {
            message: "Registro " + id + " deletado com Sucesso!!"	// Retorna uma mensagem de sucesso
        }
        return msg;
    }
}
export { DeleteUserService };