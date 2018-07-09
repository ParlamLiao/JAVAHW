package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.House;



public interface HouseService {
	
	public boolean newRoom(House house);
	
	public boolean updateRoom(House house);
	
	public House searchRoom(int hsId);
	
	public boolean deleteRoom(int hsId);

	public boolean rentStat(int hsId);
	
	public boolean unRentStat(int hsId);
	
	public void removeHouse(int hsId);
	
	public List<House> getAllHouses();
	
	public List<House> getHousesByOwnerId(int ownerId);
	
}
