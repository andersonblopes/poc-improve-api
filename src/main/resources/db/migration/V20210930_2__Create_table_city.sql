CREATE TABLE "city"
(
    "id"          SERIAL,
    "description" TEXT    NOT NULL UNIQUE,
    "fk_state"    INTEGER NOT NULL,
    CONSTRAINT "city_pk" PRIMARY KEY ("id")
);

ALTER TABLE "city"
    ADD CONSTRAINT "fk_state" FOREIGN KEY ("fk_state") REFERENCES "public"."state" ("id");
