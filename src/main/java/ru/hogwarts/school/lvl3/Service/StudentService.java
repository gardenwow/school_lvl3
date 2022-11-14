package ru.hogwarts.school.lvl3.Service;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import javax.imageio.ImageIO;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;

import antlr.actions.python.CodeLexer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.lvl3.Model.Avatar;
import ru.hogwarts.school.lvl3.Model.Student;
import ru.hogwarts.school.lvl3.repositories.AvatarRepository;
import ru.hogwarts.school.lvl3.repositories.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;

    public StudentService(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }

    public Student addStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }


    public Avatar findAvatar(long studentId) {
        return avatarRepository.findByStudentId(studentId).orElseThrow();
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


    public Collection<Student> findBetweenAge(int a, int b) {
        return studentRepository.findByAgeBetween(a, b);

    }

    public Integer getCountStudents(){
        return studentRepository.findStudens();
    }

    public Integer getAverageAgeStudents(){
        return studentRepository.averageAgeStudent();
    }
    public Collection<Student> getLastFiveStudent(){
        return studentRepository.lastFiveStudent();
    }
}