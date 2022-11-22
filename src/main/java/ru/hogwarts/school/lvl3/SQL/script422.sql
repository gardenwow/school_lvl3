CREATE TABLE human (
                       id REAL primary key,
                       name text ,
                       age integer,
                       driver_lic text,
                       car_id integer

);

CREATE table car(
                    id REAL primary key,
                    marka text,
                    model text,
                    price numeric
);

select name, age, driver_lic, car_id
from human
         INNER JOIN car ON human.car_id = car.id;

// я их связал, или я не понял что мне нужно сделать.
Составить первый JOIN-запрос, чтобы получить информацию обо всех студентах
(достаточно получить только имя и возраст студента) школы Хогвартс вместе с названиями факультетов.
Составить второй JOIN-запрос, чтобы получить только тех студентов, у которых есть аватарки.
В корне проекта создать файл scripts422.sql и поместить в него запрос.
со студентами сделаю)
//1
select name, age
from student
         INNER JOIN faculty ON student.faculty_id = faculty.name;

//2
select name, age from student
                          JOIN avatar ON student.id = avatar.student_id
WHERE student_id NOTNULL;
