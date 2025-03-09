import { response } from "express";

interface ISaleRequest { // Cria a interface ISaleRequest
    id?: string // O campo id é opcional
    date: string; // O campo date é obrigatório
    product: string; // O campo product é obrigatório
    client: string; // O campo client é obrigatório
    quantity: number; // O campo quantity é obrigatório
    total: number; // O campo total é obrigatório
}
export { ISaleRequest }; // Exporta a interface ISaleRequest