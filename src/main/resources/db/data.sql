INSERT INTO users (first_name, last_name, email, password, uuid) VALUES
    ('Max', 'Rand', 'max.rand@mail.com', 'qwerty123', uuid()),
    ('Rick', 'Rui', 'rick.rui@mail.com', 'qwerty123', uuid()),
    ('Puola', 'Muulo', 'puola.muulo@mail.com', 'qwerty123', uuid()),
    ('Kaileen', 'Wini', 'kaileen.wini@mail.com', 'qwerty123', uuid()),
    ('Misa', 'Puso', 'misa.puso@mail.com', 'qwerty123', uuid()),
    ('Wendy', 'Wils', 'wendy.wils@mail.com', 'qwerty123', uuid()),
    ('Niiko', 'Keti', 'niiko.keti@mail.com', 'qwerty123', uuid()),
    ('Watt', 'Soud', 'watt.soud@mail.com', 'qwerty123', uuid()),
    ('Sina', 'Ceil', 'sina.ceil@mail.com', 'qwerty123', uuid()),
    ('May', 'Waux', 'may.waux@mail.com', 'qwerty123', uuid());

INSERT INTO students (user_id, uuid) VALUES
    (1, uuid()),
    (2, uuid()),
    (3, uuid()),
    (5, uuid()),
    (6, uuid()),
    (8, uuid()),
    (9, uuid());

INSERT INTO teachers (user_id, uuid) VALUES
    (4, uuid()),
    (7, uuid()),
    (10, uuid());

INSERT INTO courses (name, start_date, end_date, teacher_id, uuid) VALUES
    ('Git', '2020-07-01', '2021-02-15', 1, uuid()),
    ('HTML', '2020-07-01', '2021-02-15', 1, uuid()),
    ('CSS', '2020-07-01', '2021-02-15', 2, uuid()),
    ('Java', '2020-07-01', '2021-02-15', 2, uuid()),
    ('JavaScript', '2020-07-01', '2021-02-15', 2, uuid()),
    ('Python', '2020-07-01', '2021-02-15', 3, uuid()),
    ('Ruby', '2020-07-01', '2021-02-15', 3, uuid());

INSERT INTO courses_students (course_id, student_id, enroll_date, uuid) VALUES
    (1, 1, '2020-06-01', uuid()),
    (1, 3, '2020-06-01', uuid()),
    (1, 4, '2020-06-01', uuid()),
    (2, 7, '2020-06-01', uuid()),
    (2, 4, '2020-06-01', uuid()),
    (3, 2, '2020-06-01', uuid()),
    (4, 7, '2020-06-01', uuid()),
    (4, 5, '2020-06-01', uuid()),
    (4, 2, '2020-06-01', uuid()),
    (5, 3, '2020-06-01', uuid()),
    (5, 5, '2020-06-01', uuid()),
    (6, 1, '2020-06-01', uuid()),
    (6, 4, '2020-06-01', uuid()),
    (6, 7, '2020-06-01', uuid()),
    (7, 6, '2020-06-01', uuid()),
    (7, 2, '2020-06-01', uuid()),
    (7, 3, '2020-06-01', uuid()),
    (7, 4, '2020-06-01', uuid()),
    (7, 5, '2020-06-01', uuid());
