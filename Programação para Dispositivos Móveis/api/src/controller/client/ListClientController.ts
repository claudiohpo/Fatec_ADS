import { Request, Response} from "express";
import { ListClientService } from "../../service/Client/ListClientService";

class ListClientController {
    async handle(request: Request, response: Response){
    const listClientService = new ListClientService();
    const clients = await listClientService.execute();
    
    response.json(clients);
    };
}

export {ListClientController};