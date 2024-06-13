package com.sms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sms.entities.Student;
import com.sms.entities.Teacher;
import com.sms.model.TeacherDTO;
import com.sms.repository.StudentRepository;
import com.sms.repository.TeacherRepository;
import com.sms.service.TeacherService;
import com.sms.util.Converter;

@Service
public class TeacherServiceImpl implements TeacherService
{
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private Converter converter;
	
	@Override
	public TeacherDTO registerTeache(Teacher teacher) {
		// TODO Auto-generated method stub
		return converter.convertToTeacherDTO(teacherRepository.save(teacher));
	}

	@Override
	public String assignStudentsToTeacher(int tid, Long sid) {
		// TODO Auto-generated method stub
		Student s=studentRepository.findById(sid).get();
		Teacher t=teacherRepository.findById(tid).get();
		
		List<Student> students=new ArrayList();
		students.add(s);
		
		t.setStudents(students);
		s.setTeacher(t);
		teacherRepository.save(t);
		return "student assign to a teacher sucessfully";
	}
	

}
