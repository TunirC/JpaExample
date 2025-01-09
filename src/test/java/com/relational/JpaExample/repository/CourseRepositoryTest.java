package com.relational.JpaExample.repository;

import com.relational.JpaExample.entity.Course;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Disabled
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

    @Test
    public void printCourseList() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courses present: "+courseList);
    }

}