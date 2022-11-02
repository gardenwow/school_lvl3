package ru.hogwarts.school.lvl3.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.lvl3.Model.Faculty;
import ru.hogwarts.school.lvl3.Model.Student;
import ru.hogwarts.school.lvl3.Service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
        Student student = studentService.readStudent(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createStudent = studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }
    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updateStudent = studentService.updateStudent(student.getId(), student);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();

    }
   /*
    @GetMapping
    public ResponseEntity<Collection<Student>> findColor(@RequestParam(required = false) int age){
        if(age > 0){
            return ResponseEntity.ok(studentService.findAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    */
}
