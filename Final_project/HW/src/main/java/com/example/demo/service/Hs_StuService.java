package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hs_Stu;

public interface Hs_StuService {
	
	public boolean createRelation(Hs_Stu hs_Stu);
	
	public Hs_Stu searchRelation(int stuId,int houseId);
	
	public boolean addMeetingPlace(Hs_Stu hs_Stu);
	
	public List<Hs_Stu> getHsTuByStudentid(int studentid) ;
	public List<Hs_Stu> getHsTuByOwnerid(int ownerid) ;
}
