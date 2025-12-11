UPDATE education_item
SET
    title = 'Frontend разработка',
    description = 'JavaScript, Vue.js',
    updated_at = CURRENT_TIMESTAMP
WHERE id = 1;

UPDATE education_item
SET
    title = 'Backend разработка',
    description = 'Java, Python, C++',
    updated_at = CURRENT_TIMESTAMP
WHERE id = 2;

UPDATE education_item
SET
    title = 'Аналитика',
    description = 'Системный и бизнес анализ',
    updated_at = CURRENT_TIMESTAMP
WHERE id = 3;

UPDATE education_item
SET
    title = 'Инженерия',
    description = 'Системный инженер, Электроник, Конструктор, Проектировщик, Инженер по ТД',
    updated_at = CURRENT_TIMESTAMP
WHERE id = 4;

UPDATE education_item
SET
    title = 'Графический дизайн',
    description = 'UX/UI, Figma, Blender 3D',
    updated_at = CURRENT_TIMESTAMP
WHERE id = 5;

UPDATE education_item
SET
    title = 'Научные направления',
    description = 'Навигация, Радиолокация, Цифровая обработка сигналов',
    updated_at = CURRENT_TIMESTAMP
WHERE id = 6;
