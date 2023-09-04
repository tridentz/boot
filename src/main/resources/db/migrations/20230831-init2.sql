--liquibase formatted sql
--changeset tridentz:1
CREATE TABLE company (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    type VARCHAR(255)
);

--rollback SQL STATEMENT
--DROP TABLE company;
