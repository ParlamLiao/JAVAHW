package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Hs_Stu;
import com.example.demo.repository.Hs_StuRepository;
import com.example.demo.service.Hs_StuService;


@Service
@Transactional
public class Hs_StuServiceImpl implements Hs_StuService{
	@Autowired
	Hs_StuRepository hs_StuRepository;
	
	@Override
	public boolean createRelation(Hs_Stu hs_Stu) {
		Hs_Stu hs_Stu1=null;
		if((hs_Stu1=hs_StuRepository.findByHouseidAndTenantid(hs_Stu.houseid, hs_Stu.tenantid))!=null) {
			return false;
		}else {
			hs_StuRepository.save(hs_Stu);
			return true;
		}
	}

	@Override
	public Hs_Stu searchRelation(int stuId, int houseId) {
		Hs_Stu hs_Stu=null;
		if((hs_Stu=hs_StuRepository.findByHouseidAndTenantid(houseId, stuId))!=null) {
			return hs_Stu;
		}else {
			return null;
		}
	}
	@Override
	public boolean addMeetingPlace(Hs_Stu hs_Stu) {

		if((hs_Stu=hs_StuRepository.findByHouseidAndTenantid(hs_Stu.houseid, hs_Stu.tenantid))!=null) {
			hs_StuRepository.save(hs_Stu);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Hs_Stu> getHsTuByStudentid(int studentid) {
		
		return hs_StuRepository.findByTenantid(studentid);
	}

	@Override
	public List<Hs_Stu> getHsTuByOwnerid(int ownerid) {
	
		return hs_StuRepository.findByOwnerid(ownerid);
	}

}
