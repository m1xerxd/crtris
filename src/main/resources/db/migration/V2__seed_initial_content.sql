BEGIN;

WITH existing AS (SELECT id
                  FROM main
                  ORDER BY id
                  LIMIT 1),
     ins AS (
         INSERT INTO main (description)
             SELECT 'Мы, научно-инженерный центр Санкт-Петербургского электротехнического университета (АО «НИЦ СПб ЭТУ»), специализируемся на разработке и обслуживании информационных систем и их компонентов.'
             WHERE NOT EXISTS (SELECT 1 FROM existing)
             RETURNING id),
     target AS (SELECT id
                FROM existing
                UNION ALL
                SELECT id
                FROM ins
                LIMIT 1)
UPDATE main
SET description = 'Мы, научно-инженерный центр Санкт-Петербургского электротехнического университета (АО «НИЦ СПб ЭТУ»), специализируемся на разработке и обслуживании информационных систем и их компонентов.'
WHERE id IN (SELECT id FROM target);

WITH target AS (SELECT id FROM main ORDER BY id LIMIT 1)
DELETE
FROM main_info
WHERE main_id IN (SELECT id FROM target);

WITH target AS (SELECT id FROM main ORDER BY id LIMIT 1)
INSERT
INTO main_info (name, value, position, main_id)
VALUES ('выпускников', '500+', 1, (SELECT id FROM target)),
       ('выполненных проектов', '100+', 2, (SELECT id FROM target)),
       ('направлений стажировки', '10+', 3, (SELECT id FROM target));

WITH existing AS (SELECT id
                  FROM about_us
                  ORDER BY id
                  LIMIT 1),
     ins AS (
         INSERT INTO about_us (description)
             SELECT 'В 2022 году на базе предприятия мы создали обучающий центр для начинающих специалистов, студентов последних курсов технических ВУЗов. Наш центр предоставляет возможность получить реальный опыт работы на проектах, проявить себя и построить карьеру на одном из ведущих предприятий в отрасли.'
             WHERE NOT EXISTS (SELECT 1 FROM existing)
             RETURNING id),
     target AS (SELECT id
                FROM existing
                UNION ALL
                SELECT id
                FROM ins
                LIMIT 1)
UPDATE about_us
SET description = 'В 2022 году на базе предприятия мы создали обучающий центр для начинающих специалистов, студентов последних курсов технических ВУЗов. Наш центр предоставляет возможность получить реальный опыт работы на проектах, проявить себя и построить карьеру на одном из ведущих предприятий в отрасли.'
WHERE id IN (SELECT id FROM target);

WITH target AS (SELECT id FROM about_us ORDER BY id LIMIT 1)
DELETE
FROM company_value
WHERE about_us_id IN (SELECT id FROM target);

WITH target AS (SELECT id FROM about_us ORDER BY id LIMIT 1)
INSERT
INTO company_value (title, position, about_us_id)
VALUES ('Ответственность', 1, (SELECT id FROM target)),
       ('Забота о клиентах', 2, (SELECT id FROM target)),
       ('Результативность', 3, (SELECT id FROM target)),
       ('Сотрудники', 4, (SELECT id FROM target)),
       ('Устойчивое развитие', 5, (SELECT id FROM target));

DELETE
FROM education_item;

INSERT INTO education_item (title, description, position)
VALUES ('Разработка', 'Какое-то краткое описание', 1),
       ('Разработка', 'Какое-то краткое описание', 2),
       ('Разработка', 'Какое-то краткое описание', 3),
       ('Разработка', 'Какое-то краткое описание', 4),
       ('Разработка', 'Какое-то краткое описание', 5),
       ('Разработка', 'Какое-то краткое описание', 6);

DELETE
FROM benefit;

INSERT INTO benefit (description, position)
VALUES ('Доступная библиотека обучающих курсов по hard и soft', 1),
       ('Гибкий график работы 10/10 (удаленка/коворкинг)', 2),
       ('Куратор на протяжении всего обучения', 3),
       ('Работа с наставником над реальными проектами', 4),
       ('Возможность пройти произв. практику', 5),
       ('Возможность написать диплом с научным руководителем', 6),
       ('Корпоративные мероприятия', 7),
       ('Доступный ДМС. Спортивные секции, Тренажерный зал', 8),
       ('Дружный коллектив', 9),
       ('Карьерный рост после обучения', 10);

DELETE
FROM review;

INSERT INTO review (name, text, description, position)
VALUES ('Марина С.',
        'Мы использовали пакет «Команда под ключ» для масштабирования нашего проекта. Это было решение, которое сэкономило нам массу времени и усилий... ',
        'HR-менеджер компании "SoftSolutions"', 1),
       ('Марина С.',
        'Мы использовали пакет «Команда под ключ» для масштабирования нашего проекта. Это было решение, которое сэкономило нам массу времени и усилий... ',
        'HR-менеджер компании "SoftSolutions"', 2),
       ('Марина С.',
        'Мы использовали пакет «Команда под ключ» для масштабирования нашего проекта. Это было решение, которое сэкономило нам массу времени и усилий... ',
        'HR-менеджер компании "SoftSolutions"', 3);

DELETE
FROM faq_item;

INSERT INTO faq_item (question, answer, position)
VALUES ('Какой-то вопрос?',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ut orci eu sapien eleifend viverra condimentum et tortor. ',
        1);

DELETE
FROM contacts;

INSERT INTO contacts (email, phone_number, telegram)
VALUES ('fkfkffof@gmail.com', '+4994404', 'kgjgjgg');

COMMIT;