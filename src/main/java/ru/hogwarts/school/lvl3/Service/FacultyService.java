package ru.hogwarts.school.lvl3.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.lvl3.Model.Faculty;
import ru.hogwarts.school.lvl3.Model.Student;
import ru.hogwarts.school.lvl3.repositories.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Service
public class FacultyService {
    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createStudent(Faculty faculty) {
        logger.debug("создание студента");
        return facultyRepository.save(faculty);
    }

    public Faculty readStudent(long id) {
        logger.debug("чтение студента");
        return facultyRepository.findById(id).get();
    }

    public Faculty updateStudent(   long id, Faculty faculty) {
        logger.debug("редактирование студента");
        return facultyRepository.save(faculty);
    }

    public void deleteStudent(long id) {
        logger.debug("чудаление студента");
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> findColorAndName(String name, String color){
        logger.debug("поиск в факультете по имени и цвету");
        return facultyRepository.findByNameAndColorIgnoreCase(name, color);


    }

    /*
    public Collection<Faculty> findColor(String color) {
        ArrayList<Faculty> colors = new ArrayList<>();
        for (Faculty faculty:facultyHashMap.values()){
            if (faculty.getColor().equals(color))
                colors.add(faculty);
        }
       return colors;
    }

     */
}
