package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controller.formEntity.HouseRegisterForm;
import com.example.demo.entity.House;
import com.example.demo.entity.Hs_Stu;
import com.example.demo.service.HouseService;
import com.example.demo.service.LandlordService;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	HouseService houseService;
	@Autowired
	LandlordService landlordService;
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String houseProfile(@PathVariable int id,Model model) {
		if(!model.containsAttribute("house")) {
			House house =houseService.searchRoom(id);
			model.addAttribute("house",house);
		}
		return "house_profile";
	}
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String showHouseUpdateForm(Model model,@PathVariable int id) {//model 啥来的
		HouseRegisterForm houseRegisterForm=new HouseRegisterForm();
		House house=houseService.searchRoom(id);
		houseRegisterForm.setLocation(house.getLocation());
		houseRegisterForm.setRent(house.getRent());
		houseRegisterForm.setRoomtype(house.getRoomtype());
		houseRegisterForm.setSize(house.getSize());
		model.addAttribute(houseRegisterForm);
		model.addAttribute("houseid",house.getId());
		return "update_room";
	}
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String processHouseUpdateForm(@Valid HouseRegisterForm houseRegisterForm,Model model,@PathVariable int id) {//model 啥来的
		House house=houseService.searchRoom(id);
		System.out.println(houseRegisterForm.getLocation());
		house.setLocation(houseRegisterForm.getLocation());
		house.setRent(houseRegisterForm.getRent());
		house.setRoomtype(houseRegisterForm.getRoomtype());
		house.setSize(houseRegisterForm.getSize());
		houseService.updateRoom(house);
		model.addAttribute(house);
		return "redirect:/house/"+house.getId();//这些return都指向静态模板的吧？
	}
	

	@RequestMapping(value="/{id}/removeHouse",method=RequestMethod.GET)
	public boolean removeHouse(@PathVariable int hsId) {
		return houseService.unRentStat(hsId);
		
	}
	@RequestMapping(value="/{studentid}/getStuHouse",method=RequestMethod.GET)
	public String getAllHouse(@PathVariable int studentid,Model model){
		List<House>housesList=houseService.getAllHouses();	
		model.addAttribute("housesList", housesList);
		model.addAttribute("studentid",studentid);
		return "house_list_search";
	}
	
	@RequestMapping(value="/{ownerId}/getOwnerHouse",method=RequestMethod.GET)
	public String getHousesList(@PathVariable int ownerId,Model model) {
		List<House>housesList=houseService.getHousesByOwnerId(ownerId);
		model.addAttribute("housesList", housesList);
		model.addAttribute("ownerId",ownerId);
		return "house_list_landlord";
	}
	
}