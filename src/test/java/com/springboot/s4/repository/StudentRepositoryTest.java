package com.springboot.s4.repository;

import com.springboot.s4.entity.StudentEntity;
import com.springboot.s4.entity.Subject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void studentWithSubjectTest() {
        Subject subject = new Subject(null, "C언어", null); // 교수는 null 처리
        subjectRepository.save(subject);

        StudentEntity student = new StudentEntity(null, "김학생", "kim@example.com", subject);
        studentRepository.save(student);

        List<StudentEntity> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }
}