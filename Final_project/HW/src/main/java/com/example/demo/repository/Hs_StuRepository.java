package com.example.demo.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Hs_Stu;



@Repository
public interface Hs_StuRepository  extends JpaRepository<Hs_Stu,Integer>{
	public Hs_Stu findByHouseidAndTenantid(int hsid,int taid);
	
	public List<Hs_Stu> findByTenantid(int taid);
	
	public List<Hs_Stu> findByOwnerid(int ownerid);
//	public void createHs_Stu(long houseId,long stuId);
//	
//	public Hs_Stu searchHs_Stu(long houseId,long stuId);
//	
//	public void updateHs_Stu(long Id);
//	
//	public void addMeetingPlace(long Id, String meetingPlace) ;
}
