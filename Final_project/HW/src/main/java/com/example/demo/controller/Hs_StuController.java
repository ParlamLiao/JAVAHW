package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.House;
import com.example.demo.entity.Hs_Stu;
import com.example.demo.entity.Landlord;
import com.example.demo.entity.LandlordBill;
import com.example.demo.entity.RelationInfo;
import com.example.demo.entity.Student;
import com.example.demo.service.HouseService;
import com.example.demo.service.Hs_StuService;
import com.example.demo.service.LandlordBillService;
import com.example.demo.service.LandlordService;
import com.example.demo.service.StudentService;
@Controller
@RequestMapping("/Hs_Stu")
public class Hs_StuController {
	@Autowired
	Hs_StuService hs_StuService;
	@Autowired
	HouseService houseService;
	@Autowired
	LandlordService landlordService;
	@Autowired
	StudentService studentService;
	@Autowired
	LandlordBillService landlordBillService;
	
	List<String>meetingPlaceList=new ArrayList<>(Arrays.asList("郑年锦图书馆一楼","郑年锦图书馆二楼","D4-202","A区咖啡厅","林广场咖啡厅","学生服务中心一楼","学校礼堂"));
	List<String>meetingTimeList=new ArrayList<>(Arrays.asList("周一上午9点","周二上午9点","周三上午9点","周四上午9点","周五上午9点","周六上午9点","周日上午9点"));
	
	@RequestMapping(value="/{studentid}/rent/{houseid}",method=RequestMethod.GET)
	public String rentHouse(Model model,@PathVariable int studentid,@PathVariable int houseid) {
		Date d = new Date();  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String postedtime = sdf.format(d);
		//改租房状态
		houseService.rentStat(houseid);
		
		java.util.Random r=new java.util.Random(); 
		Hs_Stu hs_Stu=new Hs_Stu();
		hs_Stu.setHouseid(houseid);
		hs_Stu.setTenantid(studentid);
		hs_Stu.setOwnerid(houseService.searchRoom(houseid).getOwnerid());
		hs_Stu.setMeetingPlace(meetingPlaceList.get(Math.abs((r.nextInt()))%7));
		hs_Stu.setMeetingTime(meetingTimeList.get(Math.abs((r.nextInt()))%7));
		hs_StuService.createRelation(hs_Stu);
		
		//扣费
		LandlordBill landlordBill=new LandlordBill();
		landlordBill.setCategory("扣除手续费");
		landlordBill.setLandlordid(houseService.searchRoom(houseid).getOwnerid());
		landlordBill.setPostedtime(postedtime);
		landlordBill.setPrice((int)(houseService.searchRoom(houseid).getRent()*0.15));
		landlordBillService.newBill(landlordBill);		
		
		//收入
		landlordBill=new LandlordBill();
		landlordBill.setCategory("租金收入");
		landlordBill.setLandlordid(houseService.searchRoom(houseid).getOwnerid());
		landlordBill.setPostedtime(postedtime);
		landlordBill.setPrice((int)(houseService.searchRoom(houseid).getRent()));
		landlordBillService.newBill(landlordBill);	
		
		return "redirect:/Hs_Stu/"+studentid+"/getStuHouse";
	}
	@RequestMapping(value="/{studentid}/getStuHouse",method=RequestMethod.GET)
	public String checkStuRent(Model model,@PathVariable int studentid) {
		List<Hs_Stu> hs_StuList=hs_StuService.getHsTuByStudentid(studentid);
		List<RelationInfo> relationInfos = new ArrayList<>();
		for (int i = 0; i < hs_StuList.size(); i++) {
			RelationInfo relationInfo = new RelationInfo();
			Hs_Stu student_housetmp = hs_StuList.get(i);
			relationInfo.setId(student_housetmp.getId());
			relationInfo.setHouseid(student_housetmp.getHouseid());
			Landlord landlord = landlordService.getLordDatail(student_housetmp.getOwnerid());
			relationInfo.setMastername(landlord.getName());
			relationInfo.setMasterphone(landlord.getPhonenumber());
			Student student = studentService.getStudentDatail(student_housetmp.getTenantid());
			relationInfo.setStudentname(student.getName());
			relationInfo.setStudentphone(student.getPhonenumber());
			relationInfo.setMeetplace(student_housetmp.getMeetingPlace());
			relationInfo.setMeettime(student_housetmp.getMeetingTime());
			relationInfos.add(relationInfo);
		}
		model.addAttribute("relationInfos", relationInfos);
		model.addAttribute("studentid", studentid);
		return "house_list_student";	
	}
	@RequestMapping(value="/{ownerid}/getLalHouse",method=RequestMethod.GET)
	public String checkLalRent(Model model,@PathVariable int ownerid) {
		List<Hs_Stu> hs_StuList=hs_StuService.getHsTuByOwnerid(ownerid);
		List<RelationInfo> relationInfos = new ArrayList<>();
		for (int i = 0; i < hs_StuList.size(); i++) {
			RelationInfo relationInfo = new RelationInfo();
			Hs_Stu student_housetmp = hs_StuList.get(i);
			relationInfo.setId(student_housetmp.getId());
			relationInfo.setHouseid(student_housetmp.getHouseid());
			Landlord landlord = landlordService.getLordDatail(student_housetmp.getOwnerid());
			relationInfo.setMastername(landlord.getName());
			relationInfo.setMasterphone(landlord.getPhonenumber());
			Student student = studentService.getStudentDatail(student_housetmp.getTenantid());
			relationInfo.setStudentname(student.getName());
			relationInfo.setStudentphone(landlord.getPhonenumber());
			relationInfo.setMeetplace(student_housetmp.getMeetingPlace());
			relationInfo.setMeettime(student_housetmp.getMeetingTime());
			relationInfos.add(relationInfo);
		}
		model.addAttribute("relationInfos", relationInfos);
		model.addAttribute("ownerid", ownerid);
		return "house_list_landlordSit";	
	}
}
