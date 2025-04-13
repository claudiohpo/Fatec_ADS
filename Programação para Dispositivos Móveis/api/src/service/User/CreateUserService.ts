import { IUserRequest } from "../../Interface/IUserInterface";
import { UsersRepositories } from "../../repositories/UsersRepositories";
import { getCustomRepository } from "typeorm";
import { hash } from "bcryptjs";

class CreateUserService {
    async execute({ name, email, admin = false, password }: IUserRequest) {
        if (!name) {
            throw new Error("Nome vazio!");
        }
        if (!email || !email.includes("@")) {
            throw new Error("Email vazio ou incorreto!");
        }
        if (!password) {
            throw new Error("Senha vazia!");
        }
        if (password.length < 6) {
            throw new Error("Senha deve ter no mínimo 6 caracteres!");
        }
        if (!admin) {
            throw new Error("Admin não definido!");
        }

        const usersRepositories = getCustomRepository(UsersRepositories);
        const userAlreadyExists = await usersRepositories.findOne({email,});
        if (userAlreadyExists) {
            throw new Error("Usuário já existe!");
        }

        const passwordHash = await hash(password, 8);

        const user = usersRepositories.create({
            name, 
            email, 
            admin, 
            password: passwordHash,});
        
        // Salvar no banco de dados
        await usersRepositories.save(user);
        return user;
    }
}
export { CreateUserService };