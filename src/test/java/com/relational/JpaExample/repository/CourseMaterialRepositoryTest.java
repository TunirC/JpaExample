package com.relational.JpaExample.repository;

import com.relational.JpaExample.entity.Course;
import com.relational.JpaExample.entity.CourseMaterial;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void addCourseMaterial() {
        Course course = Course.builder()
                .title("System Design Primer")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("https://www.educative.io/courses/grokking-the-system-design-interview/key-concepts-to-prepare-for-the-system-design-interview")
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    @Disabled
    public void deleteAllCourseMaterials() {
        courseMaterialRepository.deleteAll();
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("course material list: "+courseMaterialList);
    }

}