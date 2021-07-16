-- Table: public.endereco

-- DROP TABLE public.endereco;

CREATE TABLE public.endereco
(
    cep character varying COLLATE pg_catalog."default" NOT NULL,
    endereco character varying COLLATE pg_catalog."default" NOT NULL,
    numero character varying COLLATE pg_catalog."default" NOT NULL,
    bairro character varying COLLATE pg_catalog."default" NOT NULL,
    cidade character varying COLLATE pg_catalog."default" NOT NULL,
    estado character varying COLLATE pg_catalog."default" NOT NULL,
    pessoa_id bigint NOT NULL,
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    CONSTRAINT fk_pessoa_id_endereco FOREIGN KEY (pessoa_id)
        REFERENCES public.pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.endereco
    OWNER to postgres;