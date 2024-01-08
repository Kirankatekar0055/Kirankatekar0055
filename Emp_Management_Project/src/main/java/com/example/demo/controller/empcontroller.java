package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.EmpEntity;
import com.example.demo.service.EmpService;

@Controller
public class empcontroller {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<EmpEntity>emp=service.getallemp();
		m.addAttribute("emp1",emp);
		
		return "index";
		
	}
	
	@GetMapping("/addemp")
	public String addEmpform()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String EmpRegister(@ModelAttribute EmpEntity e)
	{
		
		System.out.println(e);
		service.addEmp(e);
		return "redirect:/" ;
		
	}
	
	@GetMapping("/edit/{id}")
	public String Edit(@PathVariable int id,Model m)
	{
		EmpEntity e=service.getempbyid(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateemp(@ModelAttribute EmpEntity e)
	{
		service.addEmp(e);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteemp(@PathVariable int id)
	{
		service.deleteemp(id);
		return "redirect:/";
	}
	

}
