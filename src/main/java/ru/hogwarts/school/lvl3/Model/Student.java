package ru.hogwarts.school.lvl3.Model;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private int age;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Student() {

    }


    @Override
    public String toString() {
        return "Student:" + name +
                ", id: " + id +
                ", age: " + age +
                " years old.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age && id.equals(student.id) && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}