package com.example.demo.service;

import com.example.demo.entity.Landlord;

public interface LandlordService {
	public Landlord login(String phonenumber ,String password);//search
	
	public boolean register(Landlord landlord);//create
	
	public Landlord getLordDatail(int lordId);//search
	
	
}
