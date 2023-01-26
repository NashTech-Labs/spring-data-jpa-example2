package com.knoldus.springdatajpa3.repository;

import com.knoldus.springdatajpa3.entity.Guardian;
import com.knoldus.springdatajpa3.entity.Student;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student= Student.builder()
                .emailId("adam12@gmail.com")
                .firstName("Adam")
                .lastName("Seekar")
                //.guardianName("Steve")
                //.guardianEmail("stv444@gmail.com")
                //.guardianMobile("8989898989")
                .build();
        studentRepository.save(student);

    }
    @Test
    public  void printAllStudent() {
        List<Student> studentList = studentRepository
                .findAll();
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("stv444@gmail.com")
                .name("Steve")
                .mobile("8989898989")
                .build();
        Student student = Student.builder()
                .firstName("Sonu")
                .lastName("sharma")
                .emailId("sonu123@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public  void printStudentByFirstName() {
        List<Student>students = studentRepository
                .findByFirstName("Sonu");
        System.out.println("students = " + students);
    }

    @Test
    public  void printgetStudentByEmailAddress() {
        Student student = studentRepository
                .getStudentByEmailAddress("sonu123@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public  void printgetStudentFirstNameByEmailAddress() {
        String firstName = studentRepository
                .getStudentFirstNameByEmailAddress("adam12@gmail.com");
        System.out.println("firstName = " + firstName);
    }
}