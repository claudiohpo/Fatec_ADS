interface ISupplierRequest { 
    id?: string; 
    name: string;
    cnpj: string;
    email: string;
    phone: string;
    address: string; 
    neighborhood: string; 
    city: string; 
    state: string;
    zipCode: string;
    bank: string;
    agency: string;
    account: string;
    accountType: string;
}
export { ISupplierRequest };