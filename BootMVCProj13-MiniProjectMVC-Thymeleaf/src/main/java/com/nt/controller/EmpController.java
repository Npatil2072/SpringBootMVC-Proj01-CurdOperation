package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {


	@GetMapping("/")
	public String showHome() {
		return "redirect:/employee/";
	}

}
