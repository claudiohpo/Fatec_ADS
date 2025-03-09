import { IClientRequest } from "../../Interface/IClientInterface";

class UpdateClientService {
    async execute({ id, name, email, phone, address, neighborhood, city, state }: IClientRequest & { id: string }) {
        if (!email) {
            throw new Error("Email incorreto!");
        }
        var vclient = {
            id: id,
            name: name,
            email: email,
            phone: phone,
            address: address,
            neighborhood: neighborhood,
            city: city,
            state: state
        };
        return vclient;
    }
}
export { UpdateClientService };