package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entities.Student;
import com.sms.model.StudentDTO;
import com.sms.service.StudentSerive;
import com.sms.util.Converter;

import jakarta.validation.Valid;
@RequestMapping("/api")
@RestController
public class StudentController 
{
	@Autowired
	private StudentSerive studentSerive;
	
	@Autowired
	private Converter converter; 

	@PostMapping("/createstudent")
	ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDto)
	{
		final Student student=converter.convertToStudentEntity(studentDto); 
		return new ResponseEntity<StudentDTO>(studentSerive.createStudent(student), HttpStatus.CREATED) ;	
	}
	@GetMapping("/getallstudents")
	List<StudentDTO> getAllStudents()
	{
		return studentSerive.getAllStudents();	
	}
	@GetMapping("/getstudentbyid/{id}")
	StudentDTO getStudentById(@PathVariable Long id)
	{
		return studentSerive.getStudentById(id);
		
	}
	@DeleteMapping("/deletestudent/{sid}")
	String deleteStudent(@PathVariable("sid") Long id)
	{
		return studentSerive.deleteStudent(id);
		
	}
}
