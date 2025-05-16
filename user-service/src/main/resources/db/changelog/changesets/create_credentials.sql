CREATE TABLE credentials
(
    id            BIGSERIAL PRIMARY KEY,
    user_id       BIGINT REFERENCES users (id),
    email         VARCHAR(255) UNIQUE,
    password_hash VARCHAR(128)
);

CREATE INDEX idx_credentials_user_id ON credentials USING btree (user_id);
