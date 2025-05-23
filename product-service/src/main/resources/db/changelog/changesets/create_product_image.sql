CREATE TABLE product_image
(
    id              BIGSERIAL PRIMARY KEY,
    product_id      BIGINT NOT NULL REFERENCES products (id) ON DELETE CASCADE,
    url             TEXT   NOT NULL,
    parent_image_id BIGINT REFERENCES product_image (id)
);

CREATE INDEX idx_product_image_product_id ON product_image (product_id);