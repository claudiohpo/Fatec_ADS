import { Request, Response } from "express";
import { DeleteSupplierService } from "../../service/Supplier/DeleteSupplierService";

class DeleteSupplierController {
    async handle( request: Request, response: Response){
    const id = request.params.id;
    const deleteSupplierService = new DeleteSupplierService();
    const msg = await deleteSupplierService.execute(id);

    response.json(msg);
    }
}
export {DeleteSupplierController};