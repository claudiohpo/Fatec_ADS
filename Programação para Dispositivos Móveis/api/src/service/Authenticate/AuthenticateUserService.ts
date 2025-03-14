import { IAuthenticateRequest } from "../../Interface/IAuthenticateUserInterface";
import { sign } from "jsonwebtoken";
import { hash } from "bcryptjs";
import { compare } from "bcryptjs";

class AuthenticateUserService{
    async execute({ email, password }: IAuthenticateRequest){
        //return "OK";
        if (!email) {
            throw new Error("Email incorreto!");
        }
        if (!password) {
            throw new Error("Senha incorreta!");
        }

        const passwordHash = await hash("fatec", 8);
        const passwordMatch = await compare(password, passwordHash);

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