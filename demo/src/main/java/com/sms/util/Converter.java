package com.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.entities.Student;
import com.sms.entities.Teacher;
import com.sms.model.StudentDTO;
import com.sms.model.TeacherDTO;

@Component
public class Converter 
{
	//Convert from DTO to ENtity
	public Student convertToStudentEntity(StudentDTO studentDTO)
	{
		Student student=new Student();
		if(studentDTO!=null)
		{
			BeanUtils.copyProperties(studentDTO, student);
		}
		return student ;
	}
	//Convert from Entity to DTO
	public StudentDTO convertToStudentDTO(Student student)
	{
		StudentDTO studentDTO=new StudentDTO();
		if(student!=null)
		{
			BeanUtils.copyProperties(student, studentDTO);
		}
		return studentDTO;
		
	}
	
	//Convert from DTO to ENtity
		public Teacher convertToTeacherEntity(TeacherDTO teacherDTO)
		{
			Teacher teacher=new Teacher();
			if(teacherDTO!=null)
			{
				BeanUtils.copyProperties(teacherDTO, teacher);
			}
			return teacher ;
		}
		//Convert from Entity to DTO
		public TeacherDTO convertToTeacherDTO(Teacher teacher)
		{
			TeacherDTO teacherDTO=new TeacherDTO();
			if(teacher!=null)
			{
				BeanUtils.copyProperties(teacher, teacherDTO);
			}
			return teacherDTO;
		}
		
	
	
}
