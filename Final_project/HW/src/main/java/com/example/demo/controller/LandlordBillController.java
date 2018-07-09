package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.LandlordBill;
import com.example.demo.service.LandlordBillService;

@Controller
@RequestMapping("/landlordbill")
public class LandlordBillController {
	@Autowired
	LandlordBillService landlordBillService;
	
	@RequestMapping(value="/{landlordid}/getBill",method=RequestMethod.GET)
	public String getBill(Model model,@PathVariable int landlordid) {
		List<LandlordBill> billList=landlordBillService.getBillDetailByLandlordid(landlordid);
		model.addAttribute("billList", billList);
		model.addAttribute("landlordid", landlordid);
		return "landlord_billlist";
	}
}
