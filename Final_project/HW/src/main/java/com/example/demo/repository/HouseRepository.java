package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.House;


@Repository
public interface HouseRepository extends JpaRepository<House,Integer>{
	public House findById(int hsId);
	@Modifying
	@Query("update House house set house.sold = ?1 where house.id=?2")
	public void updateSoldById(int sold,int id);
	
	public List<House> findByOwnerid(int ownerid);
//	public void createHouse(House house);//增
//	
//	public House searchHouse(long id);//查
//	
//	public void updateHouse(House house);//改
	
}
