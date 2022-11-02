package ru.hogwarts.school.lvl3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.lvl3.Model.Faculty;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
