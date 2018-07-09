package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;


@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;
	@Override
	public Student login(String phonenumber, String password) {
		Student student=null;
		if((student=studentRepository.findByPhonenumber(phonenumber))!=null
				&& student.getPassword().equals(password)) {
			return student;
		}
		return null;
	}

	@Override
	public boolean register(Student student) {
		System.out.println("studentRepository register"+" studentId:"+student.id);
		if((studentRepository.findById(student.id))!=null) {
			return false;
		}else {
			studentRepository.save(student);
			return true;
		}
		
	}


	@Override
	public Student getStudentDatail(int Id) {
		Student student=null;
		if((student=studentRepository.findById(Id))!=null) {
			return student;
		}
		return null;
	}

}
