import { Request, Response } from "express";
import { CreateSupplierService } from "../../service/Supplier/CreateSupplierService";

class CreateSupplierController {
    async handle(request: Request, response: Response) {
        const { name, cnpj, email, phone, address, neighborhood, city, state, zipCode, bank, agency, account, accountType } = request.body; // Recebe os dados do corpo da requisição

        const createSupplierService = new CreateSupplierService(); // Cria um objeto de serviço

        const supplier = await createSupplierService.execute({ name, cnpj, email, phone, address, neighborhood, city, state, zipCode, bank, agency, account, accountType }); // Cria um objeto user com os dados recebidos

        response.json(supplier);
    }
}
export { CreateSupplierController };