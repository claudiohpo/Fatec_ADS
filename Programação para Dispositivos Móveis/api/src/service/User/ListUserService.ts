class ListUserService {
    async execute() {
        const users = [
            {
                name: "Cláudio Henrique",
                email: "claudiohpo@gmail.com",
                admin: false,
                password: "123456"
            },
            {
                name: "André Vitor",
                email: "andre@gmail.com",
                admin: false,
                password: "123456"
            }
        ];
        return users;
    }
}
export { ListUserService };