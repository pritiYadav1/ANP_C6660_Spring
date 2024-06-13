package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sms.entities.Teacher;
import com.sms.model.TeacherDTO;
import com.sms.service.TeacherService;
import com.sms.util.Converter;

@RestController
@RequestMapping("/api")
public class TeacherController 
{
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/createteache")
	ResponseEntity<TeacherDTO> registerTeacher( @RequestBody TeacherDTO teacherDTO)
	{
		final Teacher teacher=converter.convertToTeacherEntity(teacherDTO); 
		return new ResponseEntity<TeacherDTO>(teacherService.registerTeache(teacher), HttpStatus.CREATED) ;	
	}
	@PostMapping("/assignment/{tid}/{sid}")
	public String assignStudentToTeacher(@PathVariable int tid,@PathVariable Long sid)
	{
		return teacherService.assignStudentsToTeacher(tid, sid);
		
	}
	

}
