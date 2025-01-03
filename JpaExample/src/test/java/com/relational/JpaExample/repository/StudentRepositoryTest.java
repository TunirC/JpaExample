package com.relational.JpaExample.repository;

import com.relational.JpaExample.entity.Guardian;
import com.relational.JpaExample.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Disabled
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("Tunir").lastName("Chakraborty")
                .emailId("tunir@gmail.com")
                .created(new Date())
                .build();

        studentRepository.save(student);
    }

    @Test
    @Disabled
    public void deleteStudent() {
        Student deleteStudent = studentRepository.findStudentWithEmailId("nikhilK@gmail.com");
        studentRepository.delete(deleteStudent);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .firstName("Anant").lastName("Mishra")
                .phone("8989666666")
                .emailId("anant@gmail.com")
                .build();


        Student student = Student.builder()
                .firstName("Nikhil").lastName("Mishra")
                .emailId("nikhilK@gmail.com")
                .guardian(guardian)
                .created(new Date())
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentList() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("List of Students: "+studentList);
    }

    @Test
    public void printStudentByCharactersPresent() {
        String nameChar = "ni";
        List<Student> studentList = studentRepository.findByFirstNameContaining(nameChar);
        studentList.forEach(System.out::println);
    }

    @Test
    public void printStudentByEmailId() {
        String studentName = studentRepository.findStudentFirstNameAndLastNameWithEmailId("nikhilK@gmail.com");
        System.out.println("Student name: "+studentName);
    }

    @Test
    public void printStudentDetailsFromEmailViaNativeQuery() {
        String studentDetailsViaNative = studentRepository.getStudentNameAndEmailIdViaNativeQuery("nikhilK@gmail.com");
        System.out.println("(Native query) Student Details: "+studentDetailsViaNative);

        String studentDetailsViaNativeNamedParam = studentRepository.getStudentNameAndEmailIdViaNativeNamedParam("nikhilK@gmail.com");
        System.out.println("(Native named param query) Student Details: "+studentDetailsViaNativeNamedParam);
    }

}