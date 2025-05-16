CREATE TABLE credential_role
(
    credential_id BIGINT REFERENCES credentials (id),
    role_id BIGINT REFERENCES roles (id),
    PRIMARY KEY (credential_id, role_id)
);