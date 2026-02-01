CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    dob DATE NOT NULL,
    created_on TIMESTAMP NOT NULL,
    updated_on TIMESTAMP,
    PRIMARY KEY (id)
);