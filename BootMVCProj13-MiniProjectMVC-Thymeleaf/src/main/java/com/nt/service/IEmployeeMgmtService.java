package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployee();
    public String registerEmployee(Employee emp);
    
    public Employee editEmployeeBySno(int sno);
    
    public String updateEmployee(Employee emp);

    public String deleteEmployeeById(int  sno);
    
    //public 
    
	//public Iterable<Employee> registerEmployee();
    
    public Page<Employee> showEmployeePagination(Pageable pageable);
}
