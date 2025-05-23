CREATE TABLE notification_history
(
    id              BIGSERIAL PRIMARY KEY,
    notification_id BIGINT REFERENCES notification (id),
    status          ENUM,
    changed_at      TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);