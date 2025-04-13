import { Request, Response } from "express";
import { CreateSupplierService } from "../../service/Supplier/CreateSupplierService";

class CreateSupplierController {
    async handle(request: Request, response: Response) {
        const { name, cnpj, email, phone, address, neighborhood, city, state, zipCode, bank, agency, account, accountType } = request.body; // Recebe os dados do corpo da requisição

        const createSupplierService = new CreateSupplierService(); // Cria um objeto de serviço

        try {
            const supplier = await createSupplierService.execute({ // Chama o serviço para criar o fornecedor
                name,
                cnpj,
                email,
                phone,
                address,
                neighborhood,
                city,
                state,
                zipCode,
                bank,
                agency,
                account,
                accountType
            });
            return response.status(201).json(supplier); 
        } catch (error) {
            if (error instanceof Error) {
                return response.status(400).json({ message: error.message }); 
            }
            return response.status(500).json({ message: "Erro interno do servidor" }); 
        }
    }
}
export { CreateSupplierController };