CREATE TABLE IF NOT EXISTS about_us (
                                        id          BIGSERIAL PRIMARY KEY,
                                        description TEXT,
                                        created_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS company_value (
                                             id           BIGSERIAL PRIMARY KEY,
                                             title        VARCHAR(255),
    position     INTEGER,
    about_us_id  BIGINT REFERENCES about_us(id) ON DELETE CASCADE,
    created_at   TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE INDEX IF NOT EXISTS idx_company_value_about_us_id ON company_value(about_us_id);
CREATE INDEX IF NOT EXISTS idx_company_value_position    ON company_value(position);

CREATE TABLE IF NOT EXISTS review (
                                      id          BIGSERIAL PRIMARY KEY,
                                      name        VARCHAR(255) NOT NULL,
    text        TEXT NOT NULL,
    description TEXT NOT NULL,
    position    INTEGER,
    created_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS benefit (
                                       id          BIGSERIAL PRIMARY KEY,
                                       description TEXT NOT NULL,
                                       position    INTEGER,
                                       created_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE INDEX IF NOT EXISTS idx_benefit_position ON benefit(position);

CREATE TABLE IF NOT EXISTS main (
                                    id          BIGSERIAL PRIMARY KEY,
                                    description TEXT,
                                    created_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS main_info (
                                         id         BIGSERIAL PRIMARY KEY,
                                         name       VARCHAR(255),
    value      VARCHAR(255),
    position   INTEGER,
    main_id    BIGINT REFERENCES main(id) ON DELETE CASCADE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE INDEX IF NOT EXISTS idx_main_info_main_id  ON main_info(main_id);
CREATE INDEX IF NOT EXISTS idx_main_info_position ON main_info(position);

CREATE TABLE IF NOT EXISTS education_item (
                                              id          BIGSERIAL PRIMARY KEY,
                                              title       VARCHAR(255),
    description TEXT,
    position    INTEGER,
    created_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at  TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE INDEX IF NOT EXISTS idx_education_item_position ON education_item(position);

CREATE TABLE IF NOT EXISTS faq_item (
                                        id         BIGSERIAL PRIMARY KEY,
                                        question   VARCHAR(500),
    answer     TEXT,
    position   INTEGER,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE INDEX IF NOT EXISTS idx_faq_item_position ON faq_item(position);

CREATE TABLE IF NOT EXISTS contacts (
                                        id           BIGSERIAL PRIMARY KEY,
                                        email        VARCHAR(255),
    phone_number VARCHAR(255),
    telegram     VARCHAR(255),
    created_at   TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS users (
                                     id            BIGSERIAL PRIMARY KEY,
                                     email         VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role          VARCHAR(50)  NOT NULL,
    enabled       BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMPTZ  NOT NULL DEFAULT now(),
    updated_at    TIMESTAMPTZ  NOT NULL DEFAULT now()
    );

INSERT INTO main (description)
SELECT '' WHERE NOT EXISTS (SELECT 1 FROM main);

INSERT INTO about_us (description)
SELECT '' WHERE NOT EXISTS (SELECT 1 FROM about_us);
