ALTER TABLE review
    ADD COLUMN IF NOT EXISTS avatar VARCHAR(500);

-- чтобы у старых записей не было NULL и фронт не падал
UPDATE review
SET avatar = '/reviews/default.png'
WHERE avatar IS NULL;

-- если хочешь прям гарантировать на будущее:
ALTER TABLE review
    ALTER COLUMN avatar SET DEFAULT '/reviews/default.png';

-- (опционально) сделать NOT NULL после того как всем проставили
ALTER TABLE review
    ALTER COLUMN avatar SET NOT NULL;
