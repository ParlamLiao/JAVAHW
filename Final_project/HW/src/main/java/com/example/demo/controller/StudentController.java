package com.example.demo.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.controller.formEntity.StudentRegisterForm;
import com.example.demo.controller.formEntity.User;
import com.example.demo.entity.Hs_Stu;
import com.example.demo.entity.Student;
import com.example.demo.service.HouseService;
import com.example.demo.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {//model 啥来的
		model.addAttribute(new StudentRegisterForm());//???
		return "student_register";//这些return都指向静态模板的吧？
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegister(@Valid StudentRegisterForm studentRegisterForm,Errors errors,RedirectAttributes model) throws IOException {
		if (errors.hasErrors()) {
			System.out.println(errors);
			System.out.println("有错");
			return "student_register";
		}
		else {
			Student student = new Student();
			student.setPassword(studentRegisterForm.getPassword());
			student.setBirthday(studentRegisterForm.getBirthday());
			student.setLocation(studentRegisterForm.getLocation());
			student.setName(studentRegisterForm.getName());
			student.setPhonenumber(studentRegisterForm.getPhonenumber());
			student.setSex(studentRegisterForm.getSex());
			if (!studentService.register(student)) {
				System.out.println("用户已存在");
				errors.rejectValue("id", "用户已存在");
				return "student_register";
			} else {
				System.out.println("输入没问题");
				model.addAttribute(student);
				return "redirect:/student/" + student.getId();
			}
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String hquerProfile(@PathVariable int id,Model model) {
		if(!model.containsAttribute("student")) {
			Student student=studentService.getStudentDatail(id);
			model.addAttribute(student);
		}
		return "student_profile";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new User());
		return "student_login";
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String processLogin(@Valid User user,Errors errors,RedirectAttributes model) {
		Student student;
		if((student=studentService.login(user.getPhonenumber(), user.getPassword()))==null) {
			System.out.println("账号密码不对");
			return "student_login";
		}
			
		
		model.addFlashAttribute(student);
		return "redirect:/student/"+student.getId();
	}
	
}
