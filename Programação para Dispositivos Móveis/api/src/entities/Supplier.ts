import { Entity, PrimaryColumn, Column, CreateDateColumn, UpdateDateColumn } from "typeorm";
import { v4 as uuid } from "uuid";

@Entity("suppliers")
class Supplier {
    @PrimaryColumn()
    readonly id!: string; //! = campo obrigatorio

    @Column()
    name!: string;

    @Column()
    cnpj!: string;

    @Column()
    email!: string;

    @Column()
    phone!: string;

    @Column()
    address!: string;

    @Column()
    neighborhood!: string;

    @Column()
    city!: string;

    @Column()
    state!: string;

    @Column()
    zipCode!: string;

    @Column()
    bank!: string;

    @Column()
    agency!: string;

    @Column()
    account!: string;

    @Column()
    accountType!: string;

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

export { Supplier };