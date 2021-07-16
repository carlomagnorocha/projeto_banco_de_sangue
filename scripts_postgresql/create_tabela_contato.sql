-- Table: public.contato

-- DROP TABLE public.contato;

CREATE TABLE public.contato
(
    tipo_contato_id bigint NOT NULL,
    valor character varying COLLATE pg_catalog."default" NOT NULL,
    pessoa_id bigint NOT NULL,
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    CONSTRAINT fk_pessoa_id_contato FOREIGN KEY (pessoa_id)
        REFERENCES public.pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_tipo_contato_id_contato FOREIGN KEY (tipo_contato_id)
        REFERENCES public.tipo_contato (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.contato
    OWNER to postgres;