import { IUserRequest } from "../../Interface/IUserInterface";
import { UsersRepositories } from "../../repositories/UsersRepositories";
import { getCustomRepository } from "typeorm";
import { hash } from "bcryptjs";

class UpdateUserService {
    async execute({ id, name, email, admin = false, password }: IUserRequest) {
        if (!id) {
            throw new Error("ID vazio!");
        }

        const usersRepositories = getCustomRepository(UsersRepositories);
        const userAlreadyExists = await usersRepositories.findOne({ id });

        if (!userAlreadyExists) {
            throw new Error("Usuário não existe!");
        }

        if (name !== undefined) userAlreadyExists.name = name;
        if (email !== undefined) userAlreadyExists.email = email;
        if (admin !== undefined) userAlreadyExists.admin = admin;

        // Validar a senha e substituir se for fornecida
        if (password !== undefined) {
            if (password.trim() === "") {
                throw new Error("Senha não pode ser vazia!");
            }
            const passwordHash = await hash(password, 8);
            userAlreadyExists.password = passwordHash;
        }

        userAlreadyExists.updated_at = new Date();
        await usersRepositories.update(id, userAlreadyExists);

        return userAlreadyExists;
    }
}
export { UpdateUserService };