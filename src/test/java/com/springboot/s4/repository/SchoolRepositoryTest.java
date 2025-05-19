package com.springboot.s4.repository;

import com.springboot.s4.entity.Professor;
import com.springboot.s4.entity.Subject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@Rollback(value = false)
@Transactional
@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class SchoolRepositoryTest {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    public void schoolTest() {
        Professor professor = new Professor(null, "이교수", "lee@example.com", new ArrayList<>());
        professorRepository.save(professor);

        Subject subject = new Subject(null, "C언어", professor);
        subjectRepository.save(subject);

        List<Subject> subjects = subjectRepository.findAll();
        subjects.forEach(System.out::println);
    }
}