class DeleteClientService {
    async execute(id: string) {
        console.log(id);
        var msg = {
            message: "Registro " + id + " deletado com Sucesso!!" // Retorna uma mensagem de sucesso
        };
        return msg;
    }
}
export { DeleteClientService };