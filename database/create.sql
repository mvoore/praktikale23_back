-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-05-22 17:27:34.156

-- tables
-- Table: address
CREATE TABLE address (
                         id serial  NOT NULL,
                         region_id int  NOT NULL,
                         city_id int  NOT NULL,
                         street varchar(255)  NOT NULL,
                         street_number int  NOT NULL,
                         postal_code int  NOT NULL,
                         longitude decimal(2,6)  NULL,
                         latitude decimal(2,6)  NULL,
                         CONSTRAINT address_pk PRIMARY KEY (id)
);

-- Table: application
CREATE TABLE application (
                             id serial  NOT NULL,
                             internship_id int  NOT NULL,
                             user_id int  NOT NULL,
                             status char(1)  NOT NULL,
                             CONSTRAINT application_pk PRIMARY KEY (id)
);

-- Table: category
CREATE TABLE category (
                          id serial  NOT NULL,
                          name varchar(255)  NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: company
CREATE TABLE company (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         name varchar(255)  NOT NULL,
                         phone_number varchar(15)  NOT NULL,
                         email varchar(255)  NOT NULL,
                         address_id int  NOT NULL,
                         CONSTRAINT company_pk PRIMARY KEY (id)
);

-- Table: cover_letter
CREATE TABLE cover_letter (
                              id serial  NOT NULL,
                              title varchar(255)  NOT NULL,
                              file bytea  NOT NULL,
                              user_id int  NOT NULL,
                              CONSTRAINT cover_letter_pk PRIMARY KEY (id)
);

-- Table: cv
CREATE TABLE cv (
                    id serial  NOT NULL,
                    title varchar(255)  NOT NULL,
                    file bytea  NOT NULL,
                    user_id int  NOT NULL,
                    CONSTRAINT cv_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
                       id serial  NOT NULL,
                       data bytea  NOT NULL,
                       CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: internship
CREATE TABLE internship (
                            id serial  NOT NULL,
                            company_id int  NOT NULL,
                            category_id int  NOT NULL,
                            title varchar(255)  NOT NULL,
                            description varchar(2000)  NOT NULL,
                            status char(1)  NOT NULL,
                            date_added date  NOT NULL,
                            image_id int  NULL,
                            CONSTRAINT internship_pk PRIMARY KEY (id)
);

-- Table: internship_address
CREATE TABLE internship_address (
                                    id serial  NOT NULL,
                                    address_id int  NOT NULL,
                                    internship_id int  NOT NULL,
                                    CONSTRAINT internship_address_pk PRIMARY KEY (id)
);

-- Table: region
CREATE TABLE region (
                        id serial  NOT NULL,
                        name varchar(255)  NOT NULL,
                        CONSTRAINT region_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        status char(1)  NOT NULL,
                        username varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        role_id int  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: address_city (table: address)
ALTER TABLE address ADD CONSTRAINT address_city
    FOREIGN KEY (city_id)
        REFERENCES city (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: address_region (table: address)
ALTER TABLE address ADD CONSTRAINT address_region
    FOREIGN KEY (region_id)
        REFERENCES region (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: application_internship (table: application)
ALTER TABLE application ADD CONSTRAINT application_internship
    FOREIGN KEY (internship_id)
        REFERENCES internship (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: application_user (table: application)
ALTER TABLE application ADD CONSTRAINT application_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_address (table: company)
ALTER TABLE company ADD CONSTRAINT company_address
    FOREIGN KEY (address_id)
        REFERENCES address (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_user (table: company)
ALTER TABLE company ADD CONSTRAINT company_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: cover_letter_user (table: cover_letter)
ALTER TABLE cover_letter ADD CONSTRAINT cover_letter_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: cv_user (table: cv)
ALTER TABLE cv ADD CONSTRAINT cv_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: internship_address_address (table: internship_address)
ALTER TABLE internship_address ADD CONSTRAINT internship_address_address
    FOREIGN KEY (address_id)
        REFERENCES address (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: internship_address_internship (table: internship_address)
ALTER TABLE internship_address ADD CONSTRAINT internship_address_internship
    FOREIGN KEY (internship_id)
        REFERENCES internship (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: internship_category (table: internship)
ALTER TABLE internship ADD CONSTRAINT internship_category
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: internship_company (table: internship)
ALTER TABLE internship ADD CONSTRAINT internship_company
    FOREIGN KEY (company_id)
        REFERENCES company (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: internship_image (table: internship)
ALTER TABLE internship ADD CONSTRAINT internship_image
    FOREIGN KEY (image_id)
        REFERENCES image (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

