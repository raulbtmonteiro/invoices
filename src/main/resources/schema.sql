DROP TABLE IF EXISTS "items";

DROP SEQUENCE IF EXISTS items_sequence_id;
CREATE SEQUENCE items_sequence_id INCREMENT 1 MINVALUE 1 MAXVALUE 3275495498 CACHE 1;

CREATE TABLE "items"(
    "id" bigint DEFAULT nextval('items_sequence_id') NOT NULL,
    "invoice_id" bigint,
    "name" text,
    "price" bigint,
    "quantity" bigint,
    CONSTRAINT "items_pkey" PRIMARY KEY ("id")
)
