import { Request, Response } from "express";
import { ListSupplierService } from "../../service/Supplier/ListSupplierService"; // Importa o serviço de listagem de fornecedores

class ListSupplierController {
    async handle(request: Request, response: Response) {
        const listSupplierService = new ListSupplierService(); // Cria um objeto de serviço
        const suppliers = await listSupplierService.execute(); // Chama o método execute do serviço para listar fornecedores

        response.json(suppliers); // Retorna a lista de fornecedores em formato JSON
    }
}
export { ListSupplierController }; // Exporta a classe para ser utilizada em outras partes do código