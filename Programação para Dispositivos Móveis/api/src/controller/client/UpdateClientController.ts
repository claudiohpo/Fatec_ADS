import { Request, Response } from "express";
class UpdateClientController {
    async handle(request: Request, response: Response){
        const {name, phone, email, address, neighborhood, city, state} = request.body; 
        const id = request.params.id;

        const client =
        {
            id:id,
            name:name,
            phone:phone,
            email:email,
            address:address,
            neighborhood:neighborhood,
            city:city,
            state:state
        };
        response.json({message:"Registro "+id + " atualizado com Sucesso"}); 
    }
}
export { UpdateClientController };