package com.example.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Landlord;
import com.example.demo.entity.Student;


@Repository
public interface LandlordRepository  extends JpaRepository<Landlord,Integer>{
	public Landlord findById(int Id);
	public Landlord findByPhonenumber(String PhoneNumber);
//	public void createLord(Landlord landlord);//增
//	
//	public Landlord searchLord(long id);//查
//		
//	//改，删
}
