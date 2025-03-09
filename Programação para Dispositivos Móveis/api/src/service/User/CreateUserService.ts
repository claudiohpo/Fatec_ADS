import { IUserRequest } from "../../Interface/IUserInterface";

class CreateUserService {
    async execute({ name, email, admin = false, password }: IUserRequest) {
        if(!email) {
            throw new Error("Email incorreto!");
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