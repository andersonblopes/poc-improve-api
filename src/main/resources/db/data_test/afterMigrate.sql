-- Clean tables

DELETE
FROM "public"."person"
WHERE 1 = 1;

-- Reset sequences
ALTER SEQUENCE "person_id_seq" RESTART WITH 1;

-- Insert People
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Ernest Miller Hemingway', '1999-07-21', TRUE, 'Hemingway', 'Maria da Silva!', 'Frederico da Silva', 'MALE',
        now());
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Maria de Fátima Pereira', '2002-05-19', TRUE, 'Maria', 'Patrícia Pereira', NULL, 'FEMALE', now());
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Pedro Paulo Neto', '2015-03-19', TRUE, 'Pedro', 'Manoela Oliveira', NULL, 'MALE', now());
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Francisco de Quinca', '1910-09-12', TRUE, 'Chico', 'Jurema Ferreira', NULL, 'MALE', now());
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Janaína de Alencar', '1910-09-12', TRUE, 'Janaína', 'Marta de Alencar', 'José de Alencar', 'FEMALE', now());
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Jacob Frederich', '1990-01-10', TRUE, NULL, 'Katherine Petrov', 'John Henry', 'MALE', now());
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Maria das Dores', '1986-03-19', TRUE, 'Maria', 'Marta de Azevedo', 'Carlos Azevedo', 'FEMALE', now());
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Márcio Pereira', '1967-11-05', TRUE, NULL, 'Marcia Rocha', 'Paulo Junior', 'MALE', now());
INSERT INTO "public"."person" ("name", "birth_date", "active", "social_name", "mother_name", "father_name", "gender",
                               "create_date")
VALUES ('Albert Einstein', '1850-05-13', TRUE, 'Einstein', 'Claudia Pereira!', 'Antonio de Souza', 'MALE', now());
