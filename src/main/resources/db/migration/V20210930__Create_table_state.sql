CREATE TABLE "state"
(
    "id"          SERIAL,
    "description" TEXT    NOT NULL UNIQUE,
    "initials"    INTEGER NOT NULL UNIQUE,
    CONSTRAINT "state_pk" PRIMARY KEY ("id")
);
