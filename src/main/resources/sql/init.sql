create sequence company_id_seq;
create sequence users_id_seq;
create sequence payment_id_seq;
create sequence users_chat_id_seq;
create sequence chat_id_seq;

CREATE TABLE IF NOT EXISTS company
(
    id int PRIMARY KEY default nextval('company_id_seq'),
    name VARCHAR(64) NOT NULL UNIQUE
);


CREATE TABLE IF NOT EXISTS company_locales
(
    company_id INT REFERENCES company (id),
    lang VARCHAR(2),
    description VARCHAR(255) NOT NULL ,
    PRIMARY KEY (company_id, lang)
);

CREATE TABLE IF NOT EXISTS users
(
    id bigint PRIMARY KEY default nextval('users_id_seq'),
    user_name VARCHAR(64) NOT NULL UNIQUE ,
    birth_date DATE,
    first_name VARCHAR(64),
    last_name VARCHAR(64),
    role VARCHAR(32),
    company_id INT REFERENCES company (id)
);


CREATE TABLE IF NOT EXISTS payment
(
    id bigint PRIMARY KEY default nextval('payment_id_seq'),
    amount INT NOT NULL ,
    receiver_id BIGINT NOT NULL REFERENCES users (id)
);


CREATE TABLE IF NOT EXISTS chat
(
    id bigint PRIMARY KEY default nextval('chat_id_seq'),
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users_chat
(
    id bigint PRIMARY KEY default nextval('users_chat_id_seq'),
    user_id BIGINT NOT NULL REFERENCES users (id),
    chat_id BIGINT NOT NULL REFERENCES chat (id),
    UNIQUE (user_id, chat_id)
);

