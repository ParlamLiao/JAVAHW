package com.example.demo.service.impl;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.LandlordBill;
import com.example.demo.repository.LandlordBillRepository;
import com.example.demo.service.LandlordBillService;

@Service
@Transactional
public class LandlordBillServiceImpl implements LandlordBillService {
	@Autowired
	LandlordBillRepository landlordBillRepository;

	@Override
	public boolean newBill(LandlordBill landlordBill) {
		if(landlordBillRepository.findById(landlordBill.getId())!=null)
			return false;
		else {
			landlordBillRepository.save(landlordBill);
			return true;
		}
	
	}

	@Override
	public List<LandlordBill> getBillDetailByLandlordid(int landlordid) {
	
			return landlordBillRepository.findByLandlordid(landlordid);
		
	}

	@Override
	public LandlordBill getBillDetailById(int id) {
		
			return landlordBillRepository.findById(id);
		
	}

}
