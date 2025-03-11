import { IClientRequest } from "../../Interface/IClientInterface";

class CreateClientService {
    async execute({ name, email, address, neighborhood, city, state }: IClientRequest) {
        if (!email) {
            throw new Error("Email incorreto!");
        }
        if (!address) {
            throw new Error("Endereço não pode ser vazio!");
        }
        var vclient = {
            name: name,
            email: email,
            address: address,
            neighborhood: neighborhood,
            city: city,
            state: state
        };
        return vclient;
    }
}
export { CreateClientService };