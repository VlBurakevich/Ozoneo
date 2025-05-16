CREATE TABLE products
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(50) NOT NULL,
    description    TEXT,
    price          DECIMAL     NOT NULL CHECK (price >= 0),
    category_id    BIGINT      REFERENCES categories (id) ON DELETE SET NULL,
    stock_quantity INT                      DEFAULT 0 CHECK (stock_quantity >= 0),
    brand          VARCHAR(100),
    is_active      BOOLEAN                  DEFAULT TRUE,
    created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_product_category_id ON products (category_id);
CREATE INDEX idx_product_is_active ON products (is_active);