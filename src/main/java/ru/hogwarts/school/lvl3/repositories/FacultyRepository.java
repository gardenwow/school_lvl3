package ru.hogwarts.school.lvl3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.lvl3.Model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
