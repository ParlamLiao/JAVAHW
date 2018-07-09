package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.controller.formEntity.HouseRegisterForm;
import com.example.demo.controller.formEntity.LandlordRegisterForm;
import com.example.demo.controller.formEntity.User;
import com.example.demo.entity.House;
import com.example.demo.entity.Landlord;
import com.example.demo.service.HouseService;
import com.example.demo.service.LandlordService;

@Controller
@RequestMapping("/landlord")
public class LandlordController {
	@Autowired
	LandlordService landlordService;
	@Autowired
	HouseService houseService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {//model 啥来的
		model.addAttribute(new LandlordRegisterForm());//???
		return "landlord_register";//这些return都指向静态模板的吧？
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegister(@Valid LandlordRegisterForm landlordRegisterForm,Errors errors,RedirectAttributes model) throws IOException {
		if (errors.hasErrors()) {
			System.out.println(errors);
			System.out.println("有错");
			return "landlord_register";
		}
		else {
			Landlord landlord = new Landlord();
			landlord.setPassword(landlordRegisterForm.getPassword());
			landlord.setLocation(landlordRegisterForm.getLocation());
			landlord.setName(landlordRegisterForm.getName());
			landlord.setPhonenumber(landlordRegisterForm.getPhonenumber());

			if (!landlordService.register(landlord)) {
				System.out.println("用户已存在");
				errors.rejectValue("id", "用户已存在");
				return "landlord_register";
			} else {
				System.out.println("输入没问题");
				model.addAttribute(landlord);
				return "redirect:/landlord/" + landlord.getId();
			}
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String landlordProfile(@PathVariable int id,Model model) {
		if(!model.containsAttribute("landlord")) {
			Landlord landlord=landlordService.getLordDatail(id);
			model.addAttribute(landlord);
		}
		return "landlord_profile";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new User());
		return "landlord_login";
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String processLogin(@Valid User user,Errors errors,RedirectAttributes model) {
		Landlord landlord;
		if((landlord=landlordService.login(user.getPhonenumber(), user.getPassword()))==null) {
			System.out.println("账号密码不对");
			return "landlord_login";
		}
		
		
		model.addFlashAttribute(landlord);
		return "redirect:/landlord/"+landlord.getId();
	}
	@RequestMapping(value="/{ownerId}/recordRoom",method=RequestMethod.GET)
	public String showHouseRegisterForm(Model model,@PathVariable int ownerId) {//model 啥来的
		model.addAttribute(new HouseRegisterForm());
		model.addAttribute(landlordService.getLordDatail(ownerId));
		return "new_room";//这些return都指向静态模板的吧？
	}
	@RequestMapping(value="/{ownerId}/recordRoom",method=RequestMethod.POST)
	public String processRegister(@Valid HouseRegisterForm houseRegisterForm,Errors errors,RedirectAttributes model,@PathVariable int ownerId) throws IOException {
		if (errors.hasErrors()) {
			System.out.println(errors);
			System.out.println("有错");
			return "house_register";
		}
		else {
			House house = new House();
			house.setOwnerid(ownerId);
			house.setLocation(houseRegisterForm.getLocation());
			house.setRoomtype(houseRegisterForm.getRoomtype());
			house.setSize(houseRegisterForm.getSize());
			house.setRent(houseRegisterForm.getRent());
			house.setSold(0);

			if (!houseService.newRoom(house)) {
				System.out.println("房间已存在");
				errors.rejectValue("id", "房间已存在");
				return "house_register";
			} else {
				System.out.println("输入没问题");
				model.addFlashAttribute(house);
				return "redirect:/house/" + house.getId();
			}
		}
	}
		
}
