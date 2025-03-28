import { IUserRequest } from "../../Interface/IUserInterface";
import { UsersRepositories } from "../../repositories/UsersRepositories";
import { getCustomRepository } from "typeorm";
import { hash } from "bcryptjs";

class CreateUserService {
    async execute({ name, email, admin = false, password }: IUserRequest) {
        if (!email) {
            throw new Error("Email incorreto!");
        }

        const usersRepositories = getCustomRepository(UsersRepositories);
        const userAlreadyExists = await usersRepositories.findOne({email,});
        if (userAlreadyExists) {
            throw new Error("Usuário já existe!");
        }

        const passwordHash = await hash(password, 8);

        const user = usersRepositories.create({name, email, admin, password: passwordHash,});
        
        // Salvar no banco de dados
        await usersRepositories.save(user);
        return user;
    }
}
export { CreateUserService };