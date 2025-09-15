CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS users (
                                     id           BIGSERIAL PRIMARY KEY,
                                     created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    email        VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role         VARCHAR(50)  NOT NULL,  -- EnumType.STRING
    enabled      BOOLEAN      NOT NULL DEFAULT TRUE
    );

CREATE TABLE IF NOT EXISTS about_us (
                                        id           BIGSERIAL PRIMARY KEY,
                                        created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    description  TEXT        NOT NULL
    );

CREATE TABLE IF NOT EXISTS company_value (
                                             id            BIGSERIAL PRIMARY KEY,
                                             created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    title         VARCHAR(255) NOT NULL,
    description   TEXT,
    position      INTEGER,
    about_us_id   BIGINT      NOT NULL,
    CONSTRAINT fk_company_value_about_us
    FOREIGN KEY (about_us_id) REFERENCES about_us(id) ON DELETE CASCADE
    );
CREATE INDEX IF NOT EXISTS idx_company_value_about_us ON company_value(about_us_id);

CREATE TABLE IF NOT EXISTS main (
                                    id           BIGSERIAL PRIMARY KEY,
                                    created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    description  TEXT
    );

CREATE TABLE IF NOT EXISTS main_info (
                                         id           BIGSERIAL PRIMARY KEY,
                                         created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    name         VARCHAR(255) NOT NULL,
    value        VARCHAR(255),
    position     INTEGER,
    main_id      BIGINT      NOT NULL,
    CONSTRAINT fk_main_info_main
    FOREIGN KEY (main_id) REFERENCES main(id) ON DELETE CASCADE
    );
CREATE INDEX IF NOT EXISTS idx_main_info_main ON main_info(main_id);

CREATE TABLE IF NOT EXISTS education_item (
                                              id           BIGSERIAL PRIMARY KEY,
                                              created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    title        VARCHAR(255) NOT NULL,
    description  TEXT,
    position     INTEGER
    );

CREATE TABLE IF NOT EXISTS benefit (
                                       id           BIGSERIAL PRIMARY KEY,
                                       created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    title        VARCHAR(255) NOT NULL,
    description  TEXT,
    icon         VARCHAR(255),
    position     INTEGER
    );

CREATE TABLE IF NOT EXISTS faq_item (
                                        id           BIGSERIAL PRIMARY KEY,
                                        created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    question     VARCHAR(500) NOT NULL,
    answer       TEXT,
    position     INTEGER
    );

CREATE TABLE IF NOT EXISTS review (
                                      id           BIGSERIAL PRIMARY KEY,
                                      created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    author       VARCHAR(255) NOT NULL,
    content      TEXT         NOT NULL,
    position     INTEGER
    );

CREATE TABLE IF NOT EXISTS contacts (
                                        id           BIGSERIAL PRIMARY KEY,
                                        created_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    phone        VARCHAR(100),
    email        VARCHAR(255),
    address      VARCHAR(500),
    map_url      TEXT
    );

CREATE OR REPLACE FUNCTION set_updated_at()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DO $$
DECLARE
t TEXT;
BEGIN
FOR t IN SELECT tablename FROM pg_tables WHERE schemaname = 'public'
                                           AND tablename IN ('users','about_us','company_value','main','main_info',
                                                             'education_item','benefit','faq_item','review','contacts')
    LOOP
    EXECUTE format('DROP TRIGGER IF EXISTS trg_set_updated_at_%I ON %I;', t, t);
EXECUTE format('CREATE TRIGGER trg_set_updated_at_%I BEFORE UPDATE ON %I
                    FOR EACH ROW EXECUTE FUNCTION set_updated_at();', t, t);
END LOOP;
END $$;