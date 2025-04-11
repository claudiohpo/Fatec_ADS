import {MigrationInterface, QueryRunner} from "typeorm";

export class suppliers1744404566029 implements MigrationInterface {
    name = 'suppliers1744404566029'

    public async up(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`CREATE TABLE "suppliers" ("id" character varying NOT NULL, "name" character varying NOT NULL, "cnpj" character varying NOT NULL, "email" character varying NOT NULL, "phone" character varying NOT NULL, "address" character varying NOT NULL, "neighborhood" character varying NOT NULL, "city" character varying NOT NULL, "state" character varying NOT NULL, "zipCode" character varying NOT NULL, "bank" character varying NOT NULL, "agency" character varying NOT NULL, "account" character varying NOT NULL, "accountType" character varying NOT NULL, "created_at" TIMESTAMP NOT NULL DEFAULT now(), "updated_at" TIMESTAMP NOT NULL DEFAULT now(), CONSTRAINT "PK_b70ac51766a9e3144f778cfe81e" PRIMARY KEY ("id"))`);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`DROP TABLE "suppliers"`);
    }

}
