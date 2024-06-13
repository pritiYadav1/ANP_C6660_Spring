package com.sms.service;

import com.sms.entities.Teacher;
import com.sms.model.TeacherDTO;

public interface TeacherService 
{
	TeacherDTO registerTeache(Teacher teacher );
	
	String assignStudentsToTeacher(int tid,Long sid);
}
