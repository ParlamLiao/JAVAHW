package com.example.demo.service;

import com.example.demo.entity.Student;

public interface StudentService {

	public Student login(String phonenumber, String password);//search

	public boolean register(Student student);//create

	public Student getStudentDatail(int stuId);//search
}
