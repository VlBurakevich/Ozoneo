CREATE TABLE product_category
(
    product_id BIGINT REFERENCES product(id) NOT NULL,
    category_id BIGINT REFERENCES category(id) NOT NULL,
    PRIMARY KEY (product_id, category_id)
)