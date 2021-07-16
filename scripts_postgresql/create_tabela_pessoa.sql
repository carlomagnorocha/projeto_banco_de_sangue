-- Table: public.pessoa

-- DROP TABLE public.pessoa;

CREATE TABLE public.pessoa
(
    data_nasc date NOT NULL,
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    pai character varying COLLATE pg_catalog."default" NOT NULL,
    rg character varying COLLATE pg_catalog."default" NOT NULL,
    sexo character varying COLLATE pg_catalog."default" NOT NULL,
    cpf character varying COLLATE pg_catalog."default" NOT NULL,
    mae character varying COLLATE pg_catalog."default" NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pessoa_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.pessoa
    OWNER to postgres;