package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
//	public Student searchStudent(long  id);//查
//	
//	public void createStudent(Student student);//增
//	
//	//改，删
	public Student findById(int stuId);
	public Student findByPhonenumber(String PhoneNumber);
}
