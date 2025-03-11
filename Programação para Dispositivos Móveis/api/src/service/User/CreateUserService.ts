import { IUserRequest } from "../../Interface/IUserInterface";

class CreateUserService {
    async execute({ name, email, admin = false, password }: IUserRequest) {
        if (!email) {
            throw new Error("Email incorreto!");
        }
        if (password.length < 6) {
            throw new Error("A senha deve ter pelo menos 6 caracteres!");
        }
        var vuser = {
            name: name,
            email: email,
            admin: false,
            password: password
        };
        return vuser;
    }
}
export { CreateUserService };