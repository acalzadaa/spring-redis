package com.alex.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.core.model.Student;
import com.alex.core.model.StudentRepository;
import com.alex.core.model.Student.Gender;

@RestController
public class StudentController {

	StudentRepository studentRepository;

	@Autowired
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@PostMapping("/new")
	public String createNewCustomer() {
		studentRepository.save(new Student("Eng2015001", "John Doe", "123", Student.Gender.MALE, 1));
		studentRepository.save(new Student("Med2015001", "Gareth Houston", "124", Student.Gender.MALE, 2));
		return "ok";
	}

	@GetMapping("/all")
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}

}
