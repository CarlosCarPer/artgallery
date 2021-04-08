--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-06 21:20:48

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 33112)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    user_id SERIAL PRIMARY KEY,
    username character varying(100),
    pass character varying(100),
    description character varying(10485760),
    pics character varying(10485760),
    join_date character varying(100) NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 33124)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    account_id SERIAL PRIMARY KEY,
    platform character varying(100),
    username character varying(100),
    pass character varying(100),
    url character varying(10485760),
    user_id integer,
    FOREIGN KEY (user_id) REFERENCES public.usuario(user_id) ON DELETE CASCADE
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 33118)
-- Name: art; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.art (
    art_id SERIAL PRIMARY KEY,
    title character varying(100),
    description character varying(10485760),
    author character varying(100),
    url character varying(10485760),
    tags character varying(100),
    likes integer,
    user_id integer,
    FOREIGN KEY (user_id) REFERENCES public.usuario(user_id) ON DELETE CASCADE
);


ALTER TABLE public.art OWNER TO postgres;

CREATE TABLE public.comment (
	comment_id SERIAL PRIMARY KEY,
	user_id integer NOT NULL,
	commentary character varying(10485760) NOT NULL,
	likes integer,
	comment_date character varying(100) NOT NULL,
	reply_id integer,
	FOREIGN KEY (reply_id) REFERENCES public.comment(comment_id) ON DELETE CASCADE,
	FOREIGN KEY (user_id) REFERENCES public.usuario(user_id) ON DELETE CASCADE
);

--
-- TOC entry 3011 (class 0 OID 33112)
-- Dependencies: 200
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario (username, pass, description, pics, join_date) VALUES ('Kharuso', '1234', 'Soy Carlos', 'https://twitter.com/Carcisco97', '29-03-2021');

--
-- TOC entry 3013 (class 0 OID 33124)
-- Dependencies: 202
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.account (platform, username, pass, url, user_id) VALUES ('Twitter', '@Kharuso1', '1234', 'https://twitter.com/Kharuso1', 1);

--
-- TOC entry 3012 (class 0 OID 33118)
-- Dependencies: 201
-- Data for Name: art; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.art (title, description, author, url, tags, likes, user_id) VALUES ('Mi obra', 'Una obra increible', 'Kharuso', 'https://twitter.com/Carcisco97', '3dprint', 0, 1);

INSERT INTO public.comment(user_id,commentary,likes,comment_date) VALUES (1,'Muy bien la obra la verdad, y no lo digo porque sea mia',1,'08-04-2021');

INSERT INTO public.comment(user_id,commentary,likes,comment_date,reply_id) VALUES (1,'Soy un poco idiota a veces',0,'09-04-2021',1);