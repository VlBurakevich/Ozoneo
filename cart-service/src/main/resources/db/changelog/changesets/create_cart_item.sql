CREATE TABLE cart_item
(
    id         BIGSERIL PRIMARY KEY,
    cart_id    BIGINT REFERENCES carts (id) ON DELETE CASCADE,
    product_id BIGINT,
    quantity   INT DEFAULT 1 CHECK (quantity >= 1)
);

CREATE INDEX idx_cart_item_cart_id ON cart_item (cart_id);