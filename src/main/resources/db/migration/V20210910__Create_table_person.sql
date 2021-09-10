-- Create person table
CREATE TABLE "person"
(
    "id"          SERIAL,
    "name"        TEXT                        NOT NULL UNIQUE,
    "birth_date"  DATE                        NOT NULL,
    "active"      BOOLEAN DEFAULT TRUE,
    "social_name" TEXT,
    "mother_name" TEXT,
    "father_name" TEXT,
    "gender"      TEXT                        NOT NULL,
    create_date   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    update_date   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT "person_pk" PRIMARY KEY ("id")
);
