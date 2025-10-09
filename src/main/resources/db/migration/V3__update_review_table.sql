ALTER TABLE review
    ADD COLUMN IF NOT EXISTS avatar VARCHAR(255),
    ADD COLUMN IF NOT EXISTS job_title VARCHAR(255);

DELETE FROM review;

INSERT INTO review (name, avatar, description, text, job_title, position, created_at, updated_at)
VALUES
    ('Марина С.', 'ProfilePicture1', 'HR-менеджер компании "SoftSolutions"',
     'Мы использовали пакет «Команда под ключ» для масштабирования нашего проекта. Это решение сэкономило нам массу времени и усилий.',
     'HR-менеджер компании "SoftSolutions"', 1, now(), now()),

    ('Алексей К.', 'ProfilePicture2', 'Team Lead компании "DevEdge"',
     'Команда помогла реализовать идею от начала до конца. Отличная коммуникация и качественный результат!',
     'Team Lead компании "DevEdge"', 2, now(), now()),

    ('Ольга П.', 'ProfilePicture3', 'Product Manager компании "CloudBridge"',
     'Работа с командой превзошла ожидания — всё по срокам, профессионально и с пониманием задач.',
     'Product Manager компании "CloudBridge"', 3, now(), now()),

    ('Дмитрий Л.', 'ProfilePicture4', 'CTO компании "NextIT"',
     'Сотрудничество дало отличный результат. Высокий уровень экспертизы и вовлечённости.',
     'CTO компании "NextIT"', 4, now(), now()),

    ('Анна В.', 'ProfilePicture5', 'Руководитель HR компании "BrightFuture"',
     'Очень ценим прозрачность процессов и открытость команды. Всё супер!',
     'Руководитель HR компании "BrightFuture"', 5, now(), now()),

    ('Игорь Н.', 'ProfilePicture6', 'CEO компании "TechNova"',
     'Партнёрство оказалось стратегически важным. Команда справилась с задачей идеально.',
     'CEO компании "TechNova"', 6, now(), now());
