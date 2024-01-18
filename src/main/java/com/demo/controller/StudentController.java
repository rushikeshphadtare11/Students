package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;
	
	//get all the students
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		List<Student> students = repo.findAll();
		return students;
	}
	
	// for getting particular ID
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}
	
	//for INSERT
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void  createStudent(@RequestBody Student student) {
		repo.save(student);
		
	}
	
	//to UPDATE
	@PutMapping("/student/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student = repo.findById(id).get();
        student.setName("rushi");
        student.setPercentage(92);
        repo.save(student);
        return student;
		}
	
	// To DELETE 
	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
		
	}
	
}
