CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY ,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(20),
    created_at TIMESTAMP
);