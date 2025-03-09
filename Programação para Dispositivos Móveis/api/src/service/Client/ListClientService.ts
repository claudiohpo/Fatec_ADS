class ListClientService {
    async execute() {
        const clients = [
            {
                name: "Cláudio Henrique",
                email: "claudiohpo@hotmail.com",
                phone: "83999999999",
                address: "Rua das Flores",
                neighborhood: "Bairro das Árvores",
                city: "Cidade das Cidades",
                state: "Estado dos Estados"
            },
            {
                name: "André Vitor",
                email: "andrevpo@hotmail.com",
                phone: "83999434349",
                address: "Rua das Flores",
                neighborhood: "Bairro das Árvores",
                city: "Cidade das Cidades",
                state: "Estado dos Estados"
            }
        ];
        return clients;
    }
}
export { ListClientService };