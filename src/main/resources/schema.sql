CREATE TYPE business_type AS ENUM ('RESTAURANT', 'CAFE', 'MARKET', 'STORE');
CREATE TYPE role AS ENUM ('ROLE_USER', 'ROLE_ADMIN');

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role     role         NOT NULL
);

CREATE TABLE business
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255)  NOT NULL,
    type     business_type NOT NULL,
    owner_id BIGINT        NOT NULL,
    CONSTRAINT fk_business_owner FOREIGN KEY (owner_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    business_id BIGINT       NOT NULL,
    CONSTRAINT fk_product_business FOREIGN KEY (business_id) REFERENCES business (id) ON DELETE CASCADE
);

CREATE TABLE employee
(
    id          SERIAL PRIMARY KEY,
    full_name   VARCHAR(255) NOT NULL,
    business_id BIGINT       NOT NULL,
    CONSTRAINT fk_employee_business FOREIGN KEY (business_id) REFERENCES business (id) ON DELETE CASCADE
);

CREATE TABLE rating_type
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255)     NOT NULL,
    rating_value DOUBLE PRECISION NOT NULL
);

CREATE TABLE business_rating
(
    id          SERIAL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    business_id BIGINT NOT NULL,
    comment     TEXT,
    CONSTRAINT fk_business_rating_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_business_rating_business FOREIGN KEY (business_id) REFERENCES business (id) ON DELETE CASCADE
);

CREATE TABLE product_rating
(
    id         SERIAL PRIMARY KEY,
    user_id    BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    comment    TEXT,
    CONSTRAINT fk_product_rating_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_product_rating_product FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE
);

CREATE TABLE employee_rating
(
    id          SERIAL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    comment     TEXT,
    CONSTRAINT fk_employee_rating_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_employee_rating_employee FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE
);

CREATE TABLE rating_type_mapping
(
    id                 SERIAL PRIMARY KEY,
    rating_type_id     BIGINT NOT NULL,
    business_rating_id BIGINT,
    product_rating_id  BIGINT,
    employee_rating_id BIGINT,
    CONSTRAINT fk_rating_type_mapping_rating_type FOREIGN KEY (rating_type_id) REFERENCES rating_type (id) ON DELETE CASCADE,
    CONSTRAINT fk_rating_type_mapping_business_rating FOREIGN KEY (business_rating_id) REFERENCES business_rating (id) ON DELETE CASCADE,
    CONSTRAINT fk_rating_type_mapping_product_rating FOREIGN KEY (product_rating_id) REFERENCES product_rating (id) ON DELETE CASCADE,
    CONSTRAINT fk_rating_type_mapping_employee_rating FOREIGN KEY (employee_rating_id) REFERENCES employee_rating (id) ON DELETE CASCADE,
    -- En az bir ilişki alanı dolu olmalı
    CONSTRAINT chk_rating_type_mapping_one_fk CHECK (
        (business_rating_id IS NOT NULL)::int +
        (product_rating_id IS NOT NULL)::int +
        (employee_rating_id IS NOT NULL)::int = 1
        )
);
