package com.sms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entities.Student;
import com.sms.model.StudentDTO;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentSerive;
import com.sms.util.Converter;
@Service
public class StudentServiceImpl implements StudentSerive
{

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public StudentDTO createStudent(Student student) {
		Student stud=studentRepository.save(student);
		return converter.convertToStudentDTO(stud);
	}
	@Override
	public List<StudentDTO> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students=studentRepository.findAll();
		List<StudentDTO> dtoList=new ArrayList();
		for(Student s:students)
		{
			dtoList.add(converter.convertToStudentDTO(s));
		}
		
		return dtoList;
	}
	@Override
	public StudentDTO getStudentById(Long id) {
		// TODO Auto-generated method stub
		Student stud=studentRepository.findById(id).get();
		return converter.convertToStudentDTO(stud);
	}
	@Override
	public String deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return "Student deleted ." ;
	}

}
