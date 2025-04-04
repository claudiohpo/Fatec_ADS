import { IUserRequest } from "../../Interface/IUserInterface";
import { UsersRepositories } from "../../repositories/UsersRepositories";
import { getCustomRepository } from "typeorm";
import { hash } from "bcryptjs";


class UpdateUserService {
    async execute({ id, name, email, admin = false, password }: IUserRequest) {
        if(!email) {
            throw new Error("Email incorreto!");
        }
        const usersRepositories = getCustomRepository(UsersRepositories);
        const userAlreadyExists = await usersRepositories.findOne({
            id,
        });
        if (!userAlreadyExists) {
            throw new Error("Usuário não existe!");
        }
        const passwordhash = await hash(password, 8)
        userAlreadyExists.name = name
        userAlreadyExists.email = email
        userAlreadyExists.admin = admin
        userAlreadyExists.updated_at = new Date()
        userAlreadyExists.password = passwordhash
        return await usersRepositories.update(id ,userAlreadyExists)
    }
}
export { UpdateUserService };