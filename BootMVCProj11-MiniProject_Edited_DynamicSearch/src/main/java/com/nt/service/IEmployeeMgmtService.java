package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployee();
    public String registerEmployee(Employee emp);
    
    public Employee editEmployeeBySno(int sno);
    
    public String updateEmployee(Employee emp);

    public String deleteEmployeeById(int  sno);
    
    public List<Employee> searchEmployeeWithDynamicSearch(Employee emp);
    
    public List<Employee> CustomSearch01(Employee emp);
    
    //public 
    
	//public Iterable<Employee> registerEmployee();
}
