import {MigrationInterface, QueryRunner} from "typeorm";

export class sale1744318574571 implements MigrationInterface {
    name = 'sale1744318574571'

    public async up(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`CREATE TABLE "sales" ("id" character varying NOT NULL, "date" TIMESTAMP NOT NULL, "product" character varying NOT NULL, "client" character varying NOT NULL, "quantity" integer NOT NULL, "total" numeric(10,2) NOT NULL, "created_at" TIMESTAMP NOT NULL DEFAULT now(), "updated_at" TIMESTAMP NOT NULL DEFAULT now(), CONSTRAINT "PK_4f0bc990ae81dba46da680895ea" PRIMARY KEY ("id"))`);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`DROP TABLE "sales"`);
    }

}
