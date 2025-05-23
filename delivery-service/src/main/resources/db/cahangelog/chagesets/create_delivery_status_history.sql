CREATE TABLE delivery_status_history
(
    id     BIGSERIAL PRIMARY KEY,
    delivery_id REFERENCES deliveries (id) ON DELETE CASCADE,
    status ENUM
)