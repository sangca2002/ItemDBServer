CREATE TABLE IF NOT EXISTS serialized_item_stack
(
    id                   INT          NOT NULL AUTO_INCREMENT,
    item_category        VARCHAR(255) NOT NULL,
    item_key             VARCHAR(255) NOT NULL,
    item_stack_as_string VARCHAR(65535) NOT NULL,
    PRIMARY KEY(id)
);

CREATE SEQUENCE IF NOT EXISTS serialized_item_stack_seq START WITH 1 INCREMENT BY 50;
CREATE UNIQUE INDEX IF NOT EXISTS unique_id ON serialized_item_stack (item_category, item_key);