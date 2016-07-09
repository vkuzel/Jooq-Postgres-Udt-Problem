CREATE USER jooqproblem WITH PASSWORD 'ormframeworksdemo';
CREATE DATABASE jooqproblem ENCODING = 'UTF8' LC_COLLATE = 'cs_CZ.UTF-8' TEMPLATE template0;
GRANT ALL PRIVILEGES ON DATABASE jooqproblem TO jooqproblem;

\c jooqproblem

ALTER SCHEMA public
OWNER TO jooqproblem;

\c jooqproblem jooqproblem

CREATE TYPE some_udt AS (
  value INT
);

CREATE TABLE some_table (
  id              BIGSERIAL PRIMARY KEY,
  some_udt_column some_udt NOT NULL
);