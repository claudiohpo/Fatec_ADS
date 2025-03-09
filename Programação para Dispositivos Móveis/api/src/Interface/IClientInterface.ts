interface IClientRequest { // Cria a interface IClientRequest
    id?: string;
    name: string; // O campo name é obrigatório
    email: string; // O campo email é obrigatório
    phone: string; // O campo phone é obrigatório
    address: string; // O campo address é obrigatório
    neighborhood: string; // O campo neighborhood é obrigatório
    city: string; // O campo city é obrigatório
    state: string; // O campo state é obrigatório
}
export { IClientRequest }; // Exporta a interface IClientRequest