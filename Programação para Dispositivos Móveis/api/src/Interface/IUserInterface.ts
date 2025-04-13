interface IUserRequest { // Cria a interface IUserRequest
    id?: string // O campo id é opcional
    name: string; // O campo name é obrigatório
    email: string; // O campo email é obrigatório
    admin?: boolean; // O campo admin é opcional
    password: string; // O campo password é obrigatório
}
export { IUserRequest }; // Exporta a interface IUserRequest