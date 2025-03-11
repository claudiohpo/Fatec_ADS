import { Request, Response } from "express";
import { CreateClientService } from "../../service/Client/CreateClientService";

class CreateClientController {
    async handle(request: Request, response: Response){
        const {name, phone, email, address, neighborhood, city, state} = request.body;
        
        const createClientService = new CreateClientService();
        
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
        
        response.json({client}); 
    }
}
export { CreateClientController };