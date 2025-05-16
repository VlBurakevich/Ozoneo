CREATE TABLE categories
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(50) NOT NULL,
    parent_id BIGINT      REFERENCES categories (id) ON DELETE SET NULL
);

CREATE INDEX idx_categories_parent_id ON categories (parent_id);