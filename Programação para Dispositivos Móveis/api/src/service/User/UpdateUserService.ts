import { IUserRequest } from "../../Interface/IUserInterface";
class UpdateUserService {
    async execute({ id, name, email, admin = false, password }: IUserRequest) {
        if(!email) {
            throw new Error("Email incorreto!");
        }
        var vuser = {
            id:id,
            name: name,
            email: email,
            admin: admin,
            password: password
        };
        return vuser;
    }
}
export { UpdateUserService };