package ru.hogwarts.school.lvl3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.lvl3.Model.Faculty;

import java.util.Collection;
import java.util.Collections;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByNameAndColorIgnoreCase(String name, String color);

    Collection<Faculty> findAllByColorIgnoreCase(String color);
}
