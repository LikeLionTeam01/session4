package com.springboot.s4.repository;

import com.springboot.s4.entity.Professor;
import com.springboot.s4.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfessorTest {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void testSubjectAndProfessor() {
        Professor professor = new Professor();
        professor.setName("윤교수");
        professor.setEmail("yoon@example.com");
        professorRepository.save(professor);

        Subject subject = new Subject();
        subject.setName("파이썬");
        subject.setProfessor(professor);
        subjectRepository.save(subject);

        subjectRepository.findAll().forEach(System.out::println);
    }
}