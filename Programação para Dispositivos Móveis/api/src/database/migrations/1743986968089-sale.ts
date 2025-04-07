import {MigrationInterface, QueryRunner} from "typeorm";

export class sale1743986968089 implements MigrationInterface {
    name = 'sale1743986968089'

    public async up(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`CREATE TABLE "sales" ("id" character varying NOT NULL, "date" character varying NOT NULL, "product" character varying NOT NULL, "client" character varying NOT NULL, "quantity" integer NOT NULL, "total" integer NOT NULL, "created_at" TIMESTAMP NOT NULL DEFAULT now(), "updated_at" TIMESTAMP NOT NULL DEFAULT now(), CONSTRAINT "PK_4f0bc990ae81dba46da680895ea" PRIMARY KEY ("id"))`);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`DROP TABLE "sales"`);
    }

}
