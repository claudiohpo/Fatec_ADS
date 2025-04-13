import { Request, Response } from "express";
import { CreateClientService } from "../../service/Client/CreateClientService";

class CreateClientController {
    async handle(request: Request, response: Response){
        const {name, phone, email, address, neighborhood, city, state} = request.body;
        
        const createClientService = new CreateClientService();
       
        try {
            const client = await createClientService.execute(
                {
                    name, 
                    phone, 
                    email, 
                    address, 
                    neighborhood, 
                    city, 
                    state
                }
            );
            return response.status(201).json(client); 
        } catch (error) {
            if (error instanceof Error) {
                return response.status(400).json({ message: error.message });
            }
            return response.status(500).json({ message: "Erro interno do servidor" });
        }
    }
}
export { CreateClientController };