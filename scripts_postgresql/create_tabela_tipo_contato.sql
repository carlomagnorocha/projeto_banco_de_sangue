-- Table: public.tipo_contato

-- DROP TABLE public.tipo_contato;

CREATE TABLE public.tipo_contato
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    descricao character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tipo_contato_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.tipo_contato
    OWNER to postgres;