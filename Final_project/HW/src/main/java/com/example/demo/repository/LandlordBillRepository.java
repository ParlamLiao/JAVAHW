package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.LandlordBill;

@Repository
public interface LandlordBillRepository extends JpaRepository<LandlordBill,Integer>{
	public LandlordBill findById(int Id);
	
	public List<LandlordBill> findByLandlordid(int landlordid);
}
