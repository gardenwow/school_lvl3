package ru.hogwarts.school.lvl3.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.lvl3.Model.Faculty;
import ru.hogwarts.school.lvl3.Model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Service
public class FacultyService {
    HashMap<Long, Faculty> facultyHashMap = new HashMap<>();
    private Long countIdFaculty = 1L;

    public Faculty createStudent(Faculty faculty) {
        facultyHashMap.put(countIdFaculty, faculty);
        countIdFaculty++;
        return faculty;
    }

    public Faculty readStudent(Long id) {
        return facultyHashMap.get(id);
    }

    public Faculty updateStudent(Long id, Faculty faculty) {
        if(!facultyHashMap.containsKey(id)){
            return null;
        }
        facultyHashMap.put(id, faculty);
        return faculty;
    }

    public Faculty deleteStudent(Long id) {
        return facultyHashMap.remove(id);
    }

    public Collection<Faculty> findColor(String color) {
        ArrayList<Faculty> colors = new ArrayList<>();
        for (Faculty faculty:facultyHashMap.values()){
            if (faculty.getColor().equals(color))
                colors.add(faculty);
        }
       return colors;
    }
}
