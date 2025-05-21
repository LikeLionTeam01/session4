package com.springboot.s4.repository;

import com.springboot.s4.entity.Professor;
import com.springboot.s4.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class ProfessorTest {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void testSubjectAndProfessor() {
        Professor professor = professorRepository.save(new Professor(null, "이교수", "lee@example.com", null));
        subjectRepository.save(new Subject(null, "C언어", professor));

        subjectRepository.findAll().forEach(System.out::println);
    }
}

