CREATE TABLE notifications
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    message TEXT,
    type    VARCHAR(50),
    status  ENUM,
    sent_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);