-- Drop table

-- DROP TABLE public.member_entity;

CREATE TABLE public.member_entity (
	id uuid NOT NULL,
	address varchar(255) NULL,
	birth_day date NULL,
	city varchar(255) NULL,
	"comment" varchar(255) NULL,
	country varchar(255) NULL,
	email varchar(255) NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	phone_number varchar(255) NULL,
	zip_code varchar(255) NULL,
	CONSTRAINT member_entity_pkey PRIMARY KEY (id)
);
