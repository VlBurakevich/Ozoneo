CREATE TABLE deliveries
(
    id             BIGSERIAL PRIMARY KEY,
    order_id       BIGINT,
    destination_id BIGINT,
    status         ENUMERATE,
    updated_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
)