
CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1;
CREATE SEQUENCE IF NOT EXISTS group_seq START WITH 1;

CREATE TABLE IF NOT EXISTS users (id TEXT NOT NULL DEFAULT 'user_'||nextval('user_seq'::regclass) PRIMARY KEY, name VARCHAR(255), age INT);
CREATE TABLE IF NOT EXISTS groups (
    id TEXT NOT NULL DEFAULT 'groups_'||nextval('group_seq'::regclass) PRIMARY KEY
    ,name VARCHAR(255)
    ,created_date TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
    ,updated_date TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
    ,created_by TEXT
    ,updated_by TEXT
    );
