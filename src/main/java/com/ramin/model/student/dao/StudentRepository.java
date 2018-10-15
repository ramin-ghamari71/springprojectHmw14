package com.ramin.model.student.dao;

import com.ramin.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query( "select count(id) from Student s where s.studentId =:Code")
    Long ifExistWithCode(@Param("Code") String studentId);
}
///dfsdfesd