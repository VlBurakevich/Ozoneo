CREATE TABLE product_image
(
    id         BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL REFERENCES products (id) ON DELETE CASCADE,
    url        TEXT   NOT NULL,
    sort_order INT DEFAULT 0,
    CONSTRAINT unique_sort_order_per_product UNIQUE (product_id, sort_order)
);

CREATE INDEX idx_product_image_product_id ON product_image(product_id);