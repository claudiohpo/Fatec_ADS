import { Entity, PrimaryColumn, Column, CreateDateColumn, UpdateDateColumn } from "typeorm";
import { v4 as uuid } from "uuid";

@Entity("users")
class User {
    @PrimaryColumn()
    readonly id!: string; //! = campo obrigatorio

    @Column()
    name!: string;

    @Column()
    email!: string;

    @Column()
    admin!: boolean;

    @Column()
    password!: string;

    @CreateDateColumn()
    created_at!: Date;

    @UpdateDateColumn()
    updated_at!: Date;

    constructor() {
        if (!this.id) {
            this.id = uuid();
        } // O id é gerado automaticamente se não for fornecido
    }
}

export { User };