
CREATE TABLE if not exists users
(
    user_id  SERIAL PRIMARY KEY,
    email    VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT email_constraint UNIQUE (email)
    );

CREATE TABLE if not exists todos
(
    to_do_id   SERIAL PRIMARY KEY,
    title     VARCHAR(255) NOT NULL,
    category  VARCHAR(255) NOT NULL,
    priority  BOOLEAN      NOT NULL,
    user_id INT          NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
    );

CREATE TABLE if not exists events
(
    event_id   SERIAL PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    start_date TIMESTAMP    NOT NULL,
    end_date   TIMESTAMP    NOT NULL,
    category   VARCHAR(50)  NOT NULL,
    priority   BOOLEAN      NOT NULL,
    user_id INT          NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
    );