-- public.belt_entity definition

-- Drop table

-- DROP TABLE public.belt_entity;

CREATE TABLE public.belt_entity (
	id int8 NOT NULL,
	color varchar(255) NOT NULL,
	dan int4 NOT NULL,
	CONSTRAINT belt_entity_pkey PRIMARY KEY (id)
);


-- public.classe_entity definition

-- Drop table

-- DROP TABLE public.classe_entity;

CREATE TABLE public.classe_entity (
	id int8 NOT NULL,
	category varchar(255) NULL,
	"day" varchar(255) NULL,
	"hour" varchar(255) NULL,
	CONSTRAINT classe_entity_pkey PRIMARY KEY (id)
);


-- public.club_entity definition

-- Drop table

-- DROP TABLE public.club_entity;

CREATE TABLE public.club_entity (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT club_entity_pkey PRIMARY KEY (id)
);


-- public.member_entity definition

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
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	phone_number varchar(255) NULL,
	zip_code varchar(255) NULL,
	CONSTRAINT member_entity_pkey PRIMARY KEY (id)
);


-- public.transaction_entity definition

-- Drop table

-- DROP TABLE public.transaction_entity;

CREATE TABLE public.transaction_entity (
	id int8 NOT NULL,
	amount float8 NOT NULL,
	date_time timestamp NOT NULL,
	description varchar(255) NULL,
	"method" varchar(255) NULL,
	"type" int4 NULL,
	CONSTRAINT transaction_entity_pkey PRIMARY KEY (id)
);


-- public.club_entity_classes definition

-- Drop table

-- DROP TABLE public.club_entity_classes;

CREATE TABLE public.club_entity_classes (
	club_entity_id int8 NOT NULL,
	classes_id int8 NOT NULL,
	CONSTRAINT uk_42u1h586yvjl9p8sbq8eaa7xx UNIQUE (classes_id),
	CONSTRAINT fk47j3d4q0t5qgutf8847ywhs6d FOREIGN KEY (classes_id) REFERENCES public.classe_entity(id),
	CONSTRAINT fklj8yl9spxf03kcoe2301q6u25 FOREIGN KEY (club_entity_id) REFERENCES public.club_entity(id)
);


-- public.judoka_entity definition

-- Drop table

-- DROP TABLE public.judoka_entity;

CREATE TABLE public.judoka_entity (
	balance float8 NOT NULL,
	license bool NOT NULL,
	medical_cert bool NOT NULL,
	personal_coverage bool NOT NULL,
	register_date date NULL,
	weigth float8 NOT NULL,
	id uuid NOT NULL,
	current_belt_id int8 NULL,
	CONSTRAINT judoka_entity_pkey PRIMARY KEY (id),
	CONSTRAINT fkmivt5vxrxgrx2r2je5ecuqjju FOREIGN KEY (id) REFERENCES public.member_entity(id),
	CONSTRAINT fkrwg4a2161oyn3gev3xh6rrrp5 FOREIGN KEY (current_belt_id) REFERENCES public.belt_entity(id)
);


-- public.judoka_entity_classes definition

-- Drop table

-- DROP TABLE public.judoka_entity_classes;

CREATE TABLE public.judoka_entity_classes (
	judoka_entity_id uuid NOT NULL,
	classes_id int8 NOT NULL,
	CONSTRAINT fk7vslbfmn1w4g6hp3oagwm0a34 FOREIGN KEY (classes_id) REFERENCES public.classe_entity(id),
	CONSTRAINT fkky7lg87ihdlsduotkvaaawdlb FOREIGN KEY (judoka_entity_id) REFERENCES public.judoka_entity(id)
);


-- public.judoka_entity_clubs definition

-- Drop table

-- DROP TABLE public.judoka_entity_clubs;

CREATE TABLE public.judoka_entity_clubs (
	judoka_entity_id uuid NOT NULL,
	clubs_id int8 NOT NULL,
	CONSTRAINT fkfj241qhcyu2cekfwv6nvaolg9 FOREIGN KEY (judoka_entity_id) REFERENCES public.judoka_entity(id),
	CONSTRAINT fkhp71326vq7oy51lr58t48vd6k FOREIGN KEY (clubs_id) REFERENCES public.club_entity(id)
);


-- public.judoka_entity_transaction_entities definition

-- Drop table

-- DROP TABLE public.judoka_entity_transaction_entities;

CREATE TABLE public.judoka_entity_transaction_entities (
	judoka_entity_id uuid NOT NULL,
	transaction_entities_id int8 NOT NULL,
	CONSTRAINT uk_k5p1r3am3xwtlnd10bjf4ymhf UNIQUE (transaction_entities_id),
	CONSTRAINT fk3v6clnijgote0qaw03u5seq1c FOREIGN KEY (transaction_entities_id) REFERENCES public.transaction_entity(id),
	CONSTRAINT fk9tr21ie9n4hh69edlkr5tv3r1 FOREIGN KEY (judoka_entity_id) REFERENCES public.judoka_entity(id)
);