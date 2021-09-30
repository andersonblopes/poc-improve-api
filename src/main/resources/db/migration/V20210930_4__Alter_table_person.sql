ALTER TABLE "person"
    ADD COLUMN fk_address INTEGER;

ALTER TABLE "person"
    ADD CONSTRAINT "fk_address" FOREIGN KEY ("fk_address") REFERENCES "address" ("id");
