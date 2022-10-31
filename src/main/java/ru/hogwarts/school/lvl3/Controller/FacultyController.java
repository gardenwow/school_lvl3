package ru.hogwarts.school.lvl3.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.lvl3.Model.Faculty;
import ru.hogwarts.school.lvl3.Model.Student;
import ru.hogwarts.school.lvl3.Service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getStudent(@PathVariable Long id){
        Faculty faculty = facultyService.readStudent(id);
        if (faculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @PostMapping
    public ResponseEntity<Faculty> createStudent(@RequestBody Faculty faculty){
        Faculty createFaculty = facultyService.createStudent(faculty);
        return ResponseEntity.ok(createFaculty);
    }
    @PutMapping()
    public ResponseEntity<Faculty> updateStudent(@RequestBody Faculty faculty){
        Faculty updateFaculty = facultyService.updateStudent(faculty.getId(), faculty);
        return ResponseEntity.ok(updateFaculty);
    }
    @DeleteMapping("{id}")
    public Faculty deleteStudent(@PathVariable Long id){
        return facultyService.deleteStudent(id);
    }
    @GetMapping
    public ResponseEntity<Collection<Faculty>> findColor(@RequestParam(required = false) String color){
        if(color != null && color.isBlank()){
            return ResponseEntity.ok(facultyService.findColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
}
