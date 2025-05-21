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
        professor.setName("신교수");
        professor.setEmail("sss@example.com");
        professorRepository.save(professor);

        Subject subject = new Subject();
        subject.setName("자바");
        subject.setProfessor(professor);
        subjectRepository.save(subject);

        Subject savedSubject = subjectRepository.findById(subject.getId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        Professor savedProfessor = savedSubject.getProfessor();

        System.out.println("Subject: " + savedSubject);
        System.out.println("Professor: " + savedProfessor);
    }
}