package ru.hogwarts.school.lvl3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.lvl3.Model.Avatar;
import ru.hogwarts.school.lvl3.Model.Student;

import java.util.Optional;

@Repository
public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);
}
