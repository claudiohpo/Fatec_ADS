import { Request, Response } from "express";
import { UpdateSupplierService } from "../../service/Supplier/UpdateSupplierService";

class UpdateSupplierController {
    async handle(request: Request, response: Response) {
        const { name, cnpj, email, phone, address, neighborhood, city, state, zipCode, bank, agency, account, accountType } = request.body; // Recebe os dados do corpo da requisição

        const id = request.params.id;

        const updateSupplierService = new UpdateSupplierService(); // Cria um objeto de serviço

        // Cria um objeto supplier com os dados recebidos
        const supplier = await updateSupplierService.execute({ id, name, cnpj, email, phone, address, neighborhood, city, state, zipCode, bank, agency, account, accountType });

        response.json({
            message: `Registro ${id} atualizado com sucesso`,
            supplier
        });
    }
}
export { UpdateSupplierController };