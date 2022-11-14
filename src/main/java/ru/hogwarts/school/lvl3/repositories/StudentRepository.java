package ru.hogwarts.school.lvl3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.lvl3.Model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int a, int b);

    Collection<Student> findAllByAge(int eq);
    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer findStudens();

    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Integer averageAgeStudent();


    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    Collection<Student> lastFiveStudent();


}
