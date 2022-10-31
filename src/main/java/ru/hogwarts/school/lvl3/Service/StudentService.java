package ru.hogwarts.school.lvl3.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.lvl3.Model.Faculty;
import ru.hogwarts.school.lvl3.Model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {
    private HashMap<Long, Student> studentHashMap = new HashMap<>();
    private Long countIdStudent = 1L;

    public Student createStudent(Student student) {
        studentHashMap.put(countIdStudent, student);
        countIdStudent++;
        return student;
    }

    public Student readStudent(Long id) {
        return studentHashMap.get(id);
    }

    public Student updateStudent(Long id, Student student) {
        if (!studentHashMap.containsKey(id)) {
            return null;
        }
        studentHashMap.put(id, student);
        return student;
    }

    public Student deleteStudent(Long id) {
        return studentHashMap.remove(id);
    }

    public Collection<Student> findAge(int age) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentHashMap.values()) {
            if (student.getAge() == age) {
                students.add(student);
            }

        }
        return students;
    }
}
