CREATE TABLE IF NOT EXISTS sorted_item_stack
(
    id                   INT          NOT NULL AUTO_INCREMENT,
    item_category        VARCHAR(255) NOT NULL,
    item_key             VARCHAR(255) NOT NULL,
    item_stack_as_string VARCHAR(65535) NOT NULL,
    PRIMARY KEY(id)
);

CREATE UNIQUE INDEX IF NOT EXISTS unique_id ON sorted_item_stack (item_category, item_key);