CREATE SEQUENCE person_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE person (
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL('person_seq'),
    given_name TEXT,
    family_name TEXT,
    birth_date DATE
);
