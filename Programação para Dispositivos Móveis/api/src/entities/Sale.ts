import { ParseOptions } from "querystring";
import { Entity, PrimaryColumn, Column, CreateDateColumn, UpdateDateColumn } from "typeorm";
import { v4 as uuid } from "uuid";

@Entity("sales")
class Sale {
    @PrimaryColumn()
    readonly id!: string; //! = campo obrigatorio

    @Column()
    date!: Date;

    @Column()
    product!: string;

    @Column()
    client!: string;

    @Column()
    quantity!: number;

    @Column("decimal", { precision: 10, scale: 2 })
    total!: number ;

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

export { Sale };