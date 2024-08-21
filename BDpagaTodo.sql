-- Database: pagaTodo

CREATE DATABASE "pagaTodo2";

\c "pagaTodo2";

-- Table: public.empleado

-- DROP TABLE IF EXISTS public.empleado;

CREATE TABLE empleado
(
    emp_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    dep_id bigint NOT NULL DEFAULT 1,
    emp_nombre character NOT NULL,
    emp_puesto character NOT NULL,
    CONSTRAINT empleado_pkey PRIMARY KEY (emp_id)
);

