class ListCategoryService{
    async execute(){
        const categories = [
            {
                name: "Eletrônicos",
                description: "Categoria de produtos eletrônicos"
            },
            {
                name: "Livros",
                description: "Categoria de livros"
            }
        ];
        return categories;
    }
}
export { ListCategoryService };