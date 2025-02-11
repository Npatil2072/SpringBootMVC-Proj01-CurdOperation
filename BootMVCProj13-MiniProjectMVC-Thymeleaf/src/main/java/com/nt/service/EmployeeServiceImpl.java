package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository empRepo;
	@Override
	public Iterable<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		
		return "Employee is saved with id value :"+empRepo.save(emp).getEmpno();
	}
	@Override
	public Employee editEmployeeBySno(int sno) {
		// TODO Auto-generated method stub
		Employee emp=empRepo.findById(sno).orElseThrow(()-> new IllegalArgumentException());
	   return emp;
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return  "Employee is Updated Wwith Having id Value Edit"+empRepo.save(emp).getEmpno();
		
	}
	
	@Override
	public String deleteEmployeeById(int sno) {
		// TODO Auto-generated method stub
		empRepo.deleteById(sno);
		return sno+ " Employee id Employee Deleted  :";
	}
	
	@Override
	public Page<Employee> showEmployeePagination(Pageable pageable) {
		  Page page=empRepo.findAll(pageable);
		return page;
	}
	

}
