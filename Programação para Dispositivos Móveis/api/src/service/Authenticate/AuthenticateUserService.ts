import { IAuthenticateRequest } from "../../Interface/IAuthenticateUserInterface";
import { sign } from "jsonwebtoken";
import { hash } from "bcryptjs";
import { compare } from "bcryptjs";
import { UsersRepositories } from "../../repositories/UsersRepositories";
import { getCustomRepository } from "typeorm";

class AuthenticateUserService{
    async execute({ email, password }: IAuthenticateRequest){
        //return "OK";
        if (!email) {
            throw new Error("Email incorreto!");
        }
        if (!password) {
            throw new Error("Senha incorreta!");
        }
        const usersRepositories = getCustomRepository(UsersRepositories);
        const user = await usersRepositories.findOne({
            email,
        });
        if (!user) {
            throw new Error("Email incorreto!");
        }

       // const passwordHash = await hash("fatec", 8);
        const passwordMatch = await compare(password, user?.password);

        if (!passwordMatch) {
            throw new Error("Senha incorreta!");
        }
        
        //Gerar Token
        const token = sign(
            { email:email,},
            "mobilefatec",
            {subject: ("others"), expiresIn: "1d"}
        );
        return token;
    }
}
export { AuthenticateUserService }; // Exporta a classe AuthenticateUserService