-- удаляем триггеры trg_set_updated_at_<table> со всех таблиц в public
DO $$
DECLARE t text;
BEGIN
FOR t IN
SELECT table_name::text
FROM information_schema.tables
WHERE table_schema = 'public' AND table_type = 'BASE TABLE'
    LOOP
    EXECUTE format('DROP TRIGGER IF EXISTS trg_set_updated_at_%I ON %I;', t, t);
END LOOP;
END $$;

DROP FUNCTION IF EXISTS set_updated_at();