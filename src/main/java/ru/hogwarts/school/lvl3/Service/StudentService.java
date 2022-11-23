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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;

import antlr.actions.python.CodeLexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
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
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private Integer count = 0;
    private final Object flag = new Object();

    public StudentService(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }

    public Student addStudent(Student student) {
        logger.debug("добавление студента студента");
        student.setId(null);

        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.debug("поиск студента");
        return studentRepository.findById(id).orElseThrow();
    }

    public Student editStudent(Student student) {
        logger.debug("редактирование студента");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.debug("удаление студента");
        studentRepository.deleteById(id);
    }


    public Avatar findAvatar(long studentId) {
        logger.debug("поиск аватара студента");
        return avatarRepository.findByStudentId(studentId).orElseThrow();
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


    public Collection<Student> findBetweenAge(int a, int b) {
        logger.debug("поиск студента по возрасту");
        return studentRepository.findByAgeBetween(a, b);

    }

    public Integer getCountStudents() {
        return studentRepository.findStudens();
    }

    public Integer getAverageAgeStudents() {
        return studentRepository.averageAgeStudent();
    }

    public Collection<Student> getLastFiveStudent() {
        return studentRepository.lastFiveStudent();
    }

    public Collection<String> getSortStudentUpperCase() {
        return studentRepository.findAll().stream()
                .map(e -> e.getName().toUpperCase())
                .filter(n -> n.charAt(0) == 'A')
                .sorted()
                .collect(Collectors.toList());
    }

    public Double getAvgStudentSteram() {
        return studentRepository.findAll().stream()
                .mapToDouble(e -> e.getAge())
                .average().getAsDouble();
    }

    public void getSoutStudent() {
        // studentRepository.findAll().forEach(System.out::println);
        List<Student> thread = new ArrayList<>(studentRepository.findAll());
        System.out.println(thread.get(0));
        System.out.println(thread.get(1));
        Thread thread1 = new Thread(() -> {
            System.out.println(thread.get(2));
            System.out.println(thread.get(3));
            thread.subList(2, 3);
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            System.out.println(thread.get(4));
            System.out.println(thread.get(5));
        });
        thread2.start();

    }

    public synchronized void getSoutStudentSynx() {
        List<Student> thread = new ArrayList<>(studentRepository.findAll());
        doSout(thread);
        new Thread(() -> {
            doSout(thread);
        }).start();
        new Thread(() -> {
            doSout(thread);
        }).start();
    }

    private synchronized void doSout(List<Student> students) {
        if (students.size() - 1 < count) {
            throw new RuntimeException();
        }
        synchronized (flag) {
            System.out.println("students.get(count).getName() = " + students.get(count).getName());
            count++;
            System.out.println("students.get(count).getName() = " + students.get(count).getName());
        }
        count++;

    }
}