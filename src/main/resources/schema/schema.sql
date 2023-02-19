CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1;
CREATE SEQUENCE IF NOT EXISTS group_seq START WITH 1;

CREATE TABLE IF NOT EXISTS users (id TEXT NOT NULL DEFAULT 'user_'||nextval('user_seq'::regclass) PRIMARY KEY
    , name VARCHAR(255)
    , age INT
    ,created_date date  DEFAULT CURRENT_TIMESTAMP
    ,updated_date date  DEFAULT CURRENT_TIMESTAMP
    ,created_by TEXT
    ,updated_by TEXT
    );
CREATE TABLE IF NOT EXISTS groups (
    id TEXT NOT NULL DEFAULT 'groups_'||nextval('group_seq'::regclass) PRIMARY KEY
    ,name VARCHAR(255)
    ,created_date date  DEFAULT CURRENT_TIMESTAMP
    ,updated_date date  DEFAULT CURRENT_TIMESTAMP
    ,created_by TEXT
    ,updated_by TEXT
    );
CREATE TABLE IF NOT EXISTS sequence_value (id TEXT NOT NULL PRIMARY KEY, seqId TEXT
    ,created_date date  DEFAULT CURRENT_TIMESTAMP
    ,updated_date date  DEFAULT CURRENT_TIMESTAMP
    ,created_by TEXT
    ,updated_by TEXT
    );
