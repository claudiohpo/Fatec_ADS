interface IProductRequest { // Cria a interface IProductRequest
    id?: string // O campo id é opcional
    name: string; // O campo name é obrigatório
    description: string; // O campo description é obrigatório
    price: number; // O campo price é obrigatório
    category: string; // O campo quantity é obrigatório
}
export { IProductRequest }; // Exporta a interface IProductRequest