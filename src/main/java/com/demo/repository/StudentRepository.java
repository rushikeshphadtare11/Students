package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
