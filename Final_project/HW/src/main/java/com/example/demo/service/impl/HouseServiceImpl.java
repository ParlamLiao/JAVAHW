package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.House;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.LandlordRepository;
import com.example.demo.service.HouseService;
import com.example.demo.service.LandlordService;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseRepository houseRepository;
	@Autowired
	LandlordRepository landlordRepository;
	
	@Override
	public boolean newRoom(House house) {
	
			houseRepository.save(house);
			return true;


	}

	@Override
	public boolean updateRoom(House house) {
		if (houseRepository.findById(house.id) != null) {
			houseRepository.save(house);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public House searchRoom(int hsId) {
		House house = null;
		if ((house = houseRepository.findById(hsId)) != null) {
			return house;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteRoom(int hsId) {
		if (houseRepository.findById(hsId) != null) {
			houseRepository.deleteById(hsId);
			return true;
		}
		return false;
	}

	@Override
	public boolean rentStat(int hsId) {
		if (houseRepository.findById(hsId) != null) {
			houseRepository.updateSoldById(1, hsId);
			return true;
		}
		return false;
	}

	@Override
	public boolean unRentStat(int hsId) {
		if (houseRepository.findById(hsId) != null) {
			houseRepository.updateSoldById(0, hsId);
			return true;
		}
		return false;
	}

	@Override
	public List<House> getAllHouses() {
		return houseRepository.findAll();
	}

	@Override
	public List<House> getHousesByOwnerId(int ownerId) {
		return houseRepository.findByOwnerid(ownerId);
	}

	@Override
	public void removeHouse(int hsId) {
		houseRepository.deleteById(hsId);
		
	}

}
