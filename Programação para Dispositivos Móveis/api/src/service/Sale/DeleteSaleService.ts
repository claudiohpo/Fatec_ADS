import { getCustomRepository } from "typeorm";
import { SalesRepositories } from "../../repositories/SalesRepositories";

class DeleteSaleService {
    async execute(id: string) {
        const salesRepositories = getCustomRepository(SalesRepositories);	// Cria uma instância do repositório de vendas
        const saleAlreadyExists = await salesRepositories.findOne({ id });	// Verifica se a venda existe

        if (!saleAlreadyExists) {	// Se não existir, lança um erro
            throw new Error("Venda não existe!");
        }
        await salesRepositories.delete(id);	// Deleta a venda do banco de dados

        var msg = {
            message: "Registro de Venda " + id + " Deletado com Sucesso!!"	// Retorna uma mensagem de sucesso
        }
        return msg;
    }
}
export { DeleteSaleService };