package com.relational.JpaExample.repository;

import com.relational.JpaExample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Repo Query methods
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();

    // JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student findStudentWithEmailId(String emailId);
    @Query("select CONCAT(s.firstName, ' ', s.lastName) from Student s where s.emailId = ?1")
    String findStudentFirstNameAndLastNameWithEmailId(String emailId);

    // Native Query
    @Query(
            nativeQuery = true,
            value = "SELECT " +
                    "   ID, " +
                    "   CONCAT(FIRST_NAME,' ',LAST_NAME), " +
                    "   EMAIL_ID " +
                    "FROM " +
                    "   TBL_STUDENT " +
                    "WHERE " +
                    "   EMAIL_ID = ?1"
    )
    String getStudentNameAndEmailIdViaNativeQuery(String emailId);

    // Native Named Param Query
    @Query(
            nativeQuery = true,
            value = "SELECT " +
                    "   ID, " +
                    "   CONCAT(FIRST_NAME,' ',LAST_NAME), " +
                    "   EMAIL_ID " +
                    "FROM " +
                    "   TBL_STUDENT " +
                    "WHERE " +
                    "   EMAIL_ID = :email"
    )
    String getStudentNameAndEmailIdViaNativeNamedParam(@Param("email") String emailId);

}
