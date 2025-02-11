package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeMgmtService empService;
	//private EmployeeServiceImpl empService;
	
	@GetMapping("/")
	private String welcomePage() {
		//returning LVN
		return "welcome";
	}
	@GetMapping("/report")
	private String showEmployeeReport(Map<String,Object> map) {
		//use service
		Iterable<Employee> page=empService.getAllEmployee();
		//put result in model attribute
		map.put("empReport", page);
		return "show_employee_report";
	}
	
	@PostMapping("/report")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,
			                                                             Map<String,Object> map) {
		String msg=empService.registerEmployee(emp);
		Iterable<Employee> itEmps=empService.getAllEmployee();
		//keep the result in ModelAttribute
		map.put("resultMsg", msg);
		map.put("empReport", itEmps);
		//return LVN		
		return "show_employee_report";
	}
	
	@GetMapping("/register")
	private String addEmployee(@ModelAttribute("emp") Employee emp){
				return "register_employee";
	}
	
	@PostMapping("/register")
	public String save1Employee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
		
		String  msg=empService.registerEmployee(emp);
		//keep the result in ModelAttribute
	//	map.put("resultMsg", msg);
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN		
		return "redirect:report";
	}
	
	


	@GetMapping("/edit")
	private String showEditEmployeeFormPage(@RequestParam("no") int no,
			                                                                         @ModelAttribute("emp") Employee emp) {
		//use service
        Employee emp1=empService.editEmployeeBySno(no);
		//put result in model attribute
		BeanUtils.copyProperties(emp1, emp);
		
		return "./update_employee";
	}
	@PostMapping("/edit")
	public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
		
		String  msg=empService.updateEmployee(emp);
		//keep the result in ModelAttribute
	//	map.put("resultMsg", msg);
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN		
		return "redirect:report";
	}
	
	
	
	@GetMapping("/delete")
	private String deleteEmployeeFormPage(@RequestParam("no") int no,
			                                                                         RedirectAttributes attrs) {
		//use service
       String msg= empService.deleteEmployeeById(no);
		//put result in model attribut
       attrs.addFlashAttribute("resultMsg",msg);
   		
		return "redirect:report";
	}

}
