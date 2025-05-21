package com.springboot.s4.repository;

import com.springboot.s4.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<StudentEntity, Long> {}
