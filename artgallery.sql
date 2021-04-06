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
-- TOC entry 202 (class 1259 OID 33124)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    platform character varying(100),
    username character varying(100),
    pass character varying(100),
    accountid integer NOT NULL,
    url character varying(10485760)
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 33118)
-- Name: art; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.art (
    artid integer NOT NULL,
    title character varying(100),
    description character varying(10485760),
    author character varying(100),
    url character varying(10485760),
    tags character varying(100)
);


ALTER TABLE public.art OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 33133)
-- Name: user_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_account (
    code_user integer NOT NULL,
    code_account integer NOT NULL
);


ALTER TABLE public.user_account OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 33130)
-- Name: user_art; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_art (
    code_user integer NOT NULL,
    code_art integer NOT NULL
);


ALTER TABLE public.user_art OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 33112)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    userid integer NOT NULL,
    username character varying(100),
    pass character varying(100),
    description character varying(10485760),
    pics character varying(10485760),
    join_date character varying(100)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 3013 (class 0 OID 33124)
-- Dependencies: 202
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.account (platform, username, pass, accountid, url) VALUES ('Twitter', '@Kharuso1', '1234', 1, 'https://twitter.com/Kharuso1');


--
-- TOC entry 3012 (class 0 OID 33118)
-- Dependencies: 201
-- Data for Name: art; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.art (artid, title, description, author, url, tags) VALUES (1, 'Mi obra', 'Una obra increible', 'Kharuso', 'https://twitter.com/Carcisco97', '3dprint');


--
-- TOC entry 3015 (class 0 OID 33133)
-- Dependencies: 204
-- Data for Name: user_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_account (code_user, code_account) VALUES (1, 1);


--
-- TOC entry 3014 (class 0 OID 33130)
-- Dependencies: 203
-- Data for Name: user_art; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_art (code_user, code_art) VALUES (1, 1);


--
-- TOC entry 3011 (class 0 OID 33112)
-- Dependencies: 200
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario (userid, username, pass, description, pics, join_date) VALUES (1, 'Kharuso', '1234', 'Soy Carlos', 'https://twitter.com/Carcisco97', '29-03-2021');


--
-- TOC entry 2872 (class 2606 OID 33141)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (accountid);


--
-- TOC entry 2870 (class 2606 OID 33139)
-- Name: art art_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.art
    ADD CONSTRAINT art_pkey PRIMARY KEY (artid);


--
-- TOC entry 2876 (class 2606 OID 33145)
-- Name: user_account user_account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pkey PRIMARY KEY (code_user, code_account);


--
-- TOC entry 2874 (class 2606 OID 33143)
-- Name: user_art user_art_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_art
    ADD CONSTRAINT user_art_pkey PRIMARY KEY (code_user, code_art);


--
-- TOC entry 2868 (class 2606 OID 33137)
-- Name: usuario user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT user_pkey PRIMARY KEY (userid);


--
-- TOC entry 2880 (class 2606 OID 33161)
-- Name: user_account user_account_fk_art; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_fk_art FOREIGN KEY (code_account) REFERENCES public.account(accountid);


--
-- TOC entry 2879 (class 2606 OID 33156)
-- Name: user_account user_account_fk_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_fk_user FOREIGN KEY (code_user) REFERENCES public.usuario(userid);


--
-- TOC entry 2878 (class 2606 OID 33151)
-- Name: user_art user_art_fk_art; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_art
    ADD CONSTRAINT user_art_fk_art FOREIGN KEY (code_art) REFERENCES public.art(artid);


--
-- TOC entry 2877 (class 2606 OID 33146)
-- Name: user_art user_art_fk_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_art
    ADD CONSTRAINT user_art_fk_user FOREIGN KEY (code_user) REFERENCES public.usuario(userid);


-- Completed on 2021-04-06 21:20:48

--
-- PostgreSQL database dump complete
--

