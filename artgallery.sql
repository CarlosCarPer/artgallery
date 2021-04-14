--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-14 19:23:30

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
-- TOC entry 200 (class 1259 OID 41867)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    account_id integer NOT NULL,
    platform character varying(100) NOT NULL,
    username character varying(100) NOT NULL,
    pass character varying(100) NOT NULL,
    url character varying(10485760) NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 41873)
-- Name: account_account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_account_id_seq OWNER TO postgres;

--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 201
-- Name: account_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_account_id_seq OWNED BY public.account.account_id;


--
-- TOC entry 202 (class 1259 OID 41875)
-- Name: art; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.art (
    art_id integer NOT NULL,
    title character varying(100) NOT NULL,
    description character varying(10485760),
    author character varying(100) NOT NULL,
    url character varying(10485760),
    tags character varying(100),
    likes integer DEFAULT 0,
    user_id integer NOT NULL,
    art_date character varying(100) NOT NULL
);


ALTER TABLE public.art OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 41882)
-- Name: art_art_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.art_art_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.art_art_id_seq OWNER TO postgres;

--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 203
-- Name: art_art_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.art_art_id_seq OWNED BY public.art.art_id;


--
-- TOC entry 204 (class 1259 OID 41884)
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comment (
    comment_id integer NOT NULL,
    user_id integer NOT NULL,
    art_id integer NOT NULL,
    commentary character varying(10485760) NOT NULL,
    likes integer DEFAULT 0,
    comment_date character varying(100) NOT NULL,
    reply_id integer
);


ALTER TABLE public.comment OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 41891)
-- Name: comment_comment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comment_comment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_comment_id_seq OWNER TO postgres;

--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 205
-- Name: comment_comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comment_comment_id_seq OWNED BY public.comment.comment_id;


--
-- TOC entry 206 (class 1259 OID 41893)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    user_id integer NOT NULL,
    username character varying(100) NOT NULL,
    pass character varying(100) NOT NULL,
    description character varying(10485760),
    pics character varying(10485760),
    join_date character varying(100) NOT NULL,
    avatar character varying(10485760)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 41899)
-- Name: usuario_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_user_id_seq OWNER TO postgres;

--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 207
-- Name: usuario_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_user_id_seq OWNED BY public.usuario.user_id;


--
-- TOC entry 2872 (class 2604 OID 41901)
-- Name: account account_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account ALTER COLUMN account_id SET DEFAULT nextval('public.account_account_id_seq'::regclass);


--
-- TOC entry 2874 (class 2604 OID 41902)
-- Name: art art_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.art ALTER COLUMN art_id SET DEFAULT nextval('public.art_art_id_seq'::regclass);


--
-- TOC entry 2876 (class 2604 OID 41903)
-- Name: comment comment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment ALTER COLUMN comment_id SET DEFAULT nextval('public.comment_comment_id_seq'::regclass);


--
-- TOC entry 2877 (class 2604 OID 41904)
-- Name: usuario user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN user_id SET DEFAULT nextval('public.usuario_user_id_seq'::regclass);


--
-- TOC entry 3021 (class 0 OID 41867)
-- Dependencies: 200
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.account VALUES (1, 'Twitter', '@Kharuso1', '1234', 'https://twitter.com/Kharuso1', 1);


--
-- TOC entry 3023 (class 0 OID 41875)
-- Dependencies: 202
-- Data for Name: art; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.art VALUES (1, 'Mi obra', 'Una obra increible', 'Kharuso', 'https://twitter.com/Carcisco97', '3dprint', 0, 1, '31-03-2021');


--
-- TOC entry 3025 (class 0 OID 41884)
-- Dependencies: 204
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.comment VALUES (1, 1, 1, 'Muy bien la obra la verdad, y no lo digo porque sea mia', 1, '08-04-2021', NULL);
INSERT INTO public.comment VALUES (2, 1, 1, 'Soy un poco idiota a veces', 0, '09-04-2021', 1);


--
-- TOC entry 3027 (class 0 OID 41893)
-- Dependencies: 206
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario VALUES (1, 'Kharuso', '1234', 'Soy Carlos', 'https://twitter.com/Carcisco97', '29-03-2021', NULL);


--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 201
-- Name: account_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_account_id_seq', 1, true);


--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 203
-- Name: art_art_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.art_art_id_seq', 1, true);


--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 205
-- Name: comment_comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comment_comment_id_seq', 2, true);


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 207
-- Name: usuario_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_user_id_seq', 1, true);


--
-- TOC entry 2879 (class 2606 OID 41906)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_id);


--
-- TOC entry 2881 (class 2606 OID 41908)
-- Name: art art_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.art
    ADD CONSTRAINT art_pkey PRIMARY KEY (art_id);


--
-- TOC entry 2883 (class 2606 OID 41910)
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (comment_id);


--
-- TOC entry 2885 (class 2606 OID 41912)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2886 (class 2606 OID 41913)
-- Name: account account_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.usuario(user_id) ON DELETE CASCADE;


--
-- TOC entry 2887 (class 2606 OID 41918)
-- Name: art art_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.art
    ADD CONSTRAINT art_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.usuario(user_id) ON DELETE CASCADE;


--
-- TOC entry 2890 (class 2606 OID 41933)
-- Name: comment comment_art_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_art_id_fkey FOREIGN KEY (art_id) REFERENCES public.art(art_id) ON DELETE CASCADE;


--
-- TOC entry 2888 (class 2606 OID 41923)
-- Name: comment comment_reply_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_reply_id_fkey FOREIGN KEY (reply_id) REFERENCES public.comment(comment_id) ON DELETE CASCADE;


--
-- TOC entry 2889 (class 2606 OID 41928)
-- Name: comment comment_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.usuario(user_id) ON DELETE CASCADE;


-- Completed on 2021-04-14 19:23:31

--
-- PostgreSQL database dump complete
--

