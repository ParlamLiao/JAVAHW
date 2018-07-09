package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Landlord;
import com.example.demo.repository.LandlordRepository;
import com.example.demo.service.LandlordService;


@Service
@Transactional
public class LandlordServiceImpl implements LandlordService{
	@Autowired
	LandlordRepository landlordRepository;
	@Override
	public Landlord login(String phonenumber, String password) {
		Landlord landlord=null;
		if((landlord=landlordRepository.findByPhonenumber(phonenumber))!=null
				&& landlord.getPassword().equals(password)) {
			return landlord;
		}
		return null;
	}

	@Override
	public boolean register(Landlord landlord) {
		if((landlordRepository.findById(landlord.id))!=null) {
			return false;
		}else {
			landlordRepository.save(landlord);
			return true;
		}
		
	}

	@Override
	public Landlord getLordDatail(int lordId) {
		Landlord landlord=null;
		if((landlord=landlordRepository.findById(lordId))!=null) {
			return landlord;
		}
		return null;
	}

}
