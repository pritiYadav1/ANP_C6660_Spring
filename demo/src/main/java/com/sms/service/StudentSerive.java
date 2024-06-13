package com.sms.service;

import java.util.List;

import com.sms.entities.Student;
import com.sms.model.StudentDTO;

public interface StudentSerive 
{
	StudentDTO createStudent(Student student);
	List<StudentDTO> getAllStudents();
	StudentDTO getStudentById(Long id);
	String deleteStudent(Long id);
}
