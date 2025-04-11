import { ParseOptions } from "querystring";
import { Entity, PrimaryColumn, Column, CreateDateColumn, UpdateDateColumn } from "typeorm";
import { v4 as uuid } from "uuid";

@Entity("products")
class Product {
    @PrimaryColumn()
    readonly id!: string; //! = campo obrigatorio

    @Column()
    name!: string;

    @Column()
    description!: string;

    @Column("decimal", { precision: 10, scale: 2 })
    price!: number;

    @Column()
    category!: string;

    @CreateDateColumn()
    created_at!: Date;

    @UpdateDateColumn()
    updated_at!: Date;

    constructor() {
        if (!this.id) {
            this.id = uuid();
        }
    }
}
export { Product };