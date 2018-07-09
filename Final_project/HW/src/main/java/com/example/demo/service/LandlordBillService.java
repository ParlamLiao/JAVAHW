package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LandlordBill;

public interface LandlordBillService {
	public boolean newBill(LandlordBill landlordBill);
	
	public List<LandlordBill> getBillDetailByLandlordid(int landlordid);
	
	public LandlordBill getBillDetailById(int id);
}
