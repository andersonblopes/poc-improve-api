CREATE TABLE "address"
(
    "id"          SERIAL,
    "line_1"      TEXT    NOT NULL,
    "line_2"      TEXT,
    "postal_code" TEXT,
    "fk_city"     INTEGER NOT NULL,
    CONSTRAINT "address_pk" PRIMARY KEY ("id")
);

ALTER TABLE "address"
    ADD CONSTRAINT "fk_city" FOREIGN KEY ("fk_city") REFERENCES "public"."city" ("id");
