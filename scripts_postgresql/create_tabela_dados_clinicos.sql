-- Table: public.dados_clinicos

-- DROP TABLE public.dados_clinicos;

CREATE TABLE public.dados_clinicos
(
    altura double precision NOT NULL,
    peso double precision NOT NULL,
    tipo_sanguineo character varying COLLATE pg_catalog."default" NOT NULL,
    pessoa_id bigint NOT NULL,
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    CONSTRAINT fk_pessoa_id_dados_clinicos FOREIGN KEY (pessoa_id)
        REFERENCES public.pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.dados_clinicos
    OWNER to postgres;