
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE business (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    owner_id INTEGER,
    CONSTRAINT fk_business_owner FOREIGN KEY (owner_id) REFERENCES users(id)
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    business_id INTEGER,
    CONSTRAINT fk_product_business FOREIGN KEY (business_id) REFERENCES business(id)
);

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    business_id INTEGER,
    CONSTRAINT fk_employee_business FOREIGN KEY (business_id) REFERENCES business(id)
);

CREATE TABLE rating_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    value INTEGER NOT NULL
);

CREATE TABLE business_rating (
    id SERIAL PRIMARY KEY,
    user_id INTEGER,
    business_id INTEGER,
    comment TEXT,
    CONSTRAINT fk_business_rating_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_business_rating_business FOREIGN KEY (business_id) REFERENCES business(id)
);

CREATE TABLE product_rating (
    id SERIAL PRIMARY KEY,
    user_id INTEGER,
    product_id INTEGER,
    comment TEXT,
    CONSTRAINT fk_product_rating_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_product_rating_product FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE employee_rating (
    id SERIAL PRIMARY KEY,
    user_id INTEGER,
    employee_id INTEGER,
    comment TEXT,
    CONSTRAINT fk_employee_rating_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_employee_rating_employee FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE rating_type_mapping (
    id SERIAL PRIMARY KEY,
    rating_type_id INTEGER NOT NULL,
    business_rating_id INTEGER,
    product_rating_id INTEGER,
    employee_rating_id INTEGER,
    CONSTRAINT fk_mapping_rating_type FOREIGN KEY (rating_type_id) REFERENCES rating_type(id),
    CONSTRAINT fk_mapping_business_rating FOREIGN KEY (business_rating_id) REFERENCES business_rating(id),
    CONSTRAINT fk_mapping_product_rating FOREIGN KEY (product_rating_id) REFERENCES product_rating(id),
    CONSTRAINT fk_mapping_employee_rating FOREIGN KEY (employee_rating_id) REFERENCES employee_rating(id)
);
