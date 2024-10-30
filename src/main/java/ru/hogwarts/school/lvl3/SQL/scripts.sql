select  * from student
WHERE student.age > 10 and student.age < 20;

select s.id, s.age, s.name from student as s;

select * from student
WHERE  name like 'L%';

select * from student
WHERE  age < student.id;

select * from student
ORDER BY age;