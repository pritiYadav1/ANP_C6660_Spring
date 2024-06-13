package com.sms.model;

import java.util.List;

import com.sms.entities.Student;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TeacherDTO 
{
	private int id;
	private String name;
	private String city;
	private String phNo;
	
	List<Student> students;
}
