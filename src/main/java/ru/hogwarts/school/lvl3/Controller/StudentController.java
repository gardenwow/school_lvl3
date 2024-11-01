package ru.hogwarts.school.lvl3.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.lvl3.Model.Avatar;
import ru.hogwarts.school.lvl3.Model.Student;
import ru.hogwarts.school.lvl3.Service.StudentService;
import ru.hogwarts.school.lvl3.repositories.StudentRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;



    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
        Student student = studentService.findStudent(id);
        if (student == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(student);
    }
    @GetMapping
    public ResponseEntity findBetweenAge(@RequestParam(required = false) int a,
                                         @RequestParam(required = false) int b){
        return ResponseEntity.ok(studentService.findBetweenAge(a, b));
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createStudent = studentService.addStudent(student);
        return ResponseEntity.ok(createStudent);
    }
    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updateStudent = studentService.editStudent(student);
        return ResponseEntity.ok(updateStudent);
    }
    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable long id){
         studentService.deleteStudent(id);
    }
    @GetMapping(value = "/{id}/avatar")
    public void downloadAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Avatar avatar = studentService.findAvatar(id);

        Path path = Path.of(avatar.getFilePath());

        try (InputStream is = Files.newInputStream(path);
             OutputStream os = response.getOutputStream();) {
            response.setStatus(200);
            response.setContentType(avatar.getMediaType());
            response.setContentLength((int) avatar.getFileSize());
            is.transferTo(os);
        }
    }

    @GetMapping("/Count-students")
    public Integer getCountStudents(){
       return studentService.getCountStudents();
    }

    @GetMapping("/averageAge")
    public Integer avgAgeStudents(){
        return studentService.getAverageAgeStudents();
    }
    @GetMapping("/lastFive")
    public Collection<Student> lastFiveStudents(){
        return studentService.getLastFiveStudent();
    }

    @GetMapping("/searchA")
    public Collection<String> getSearchStudentA(){
        return studentService.getSortStudentUpperCase();
    }
    @GetMapping("/searchAVG")
    public Double getAvgStStream(){
        return studentService.getAvgStudentSteram();
    }


    @GetMapping("/Threads")
    public HttpStatus getSoutStudent(){
        studentService.getSoutStudent();
        return HttpStatus.OK;
    }
    @GetMapping("/ThreadsSynx")
    public HttpStatus getSoutStudentSynx(){
        studentService.getSoutStudentSynx();
        return HttpStatus.OK;
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
