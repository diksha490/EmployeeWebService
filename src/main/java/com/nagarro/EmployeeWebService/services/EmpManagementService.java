package com.nagarro.EmployeeWebService.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.EmployeeWebService.entities.Employee;
import com.nagarro.EmployeeWebService.repository.EmployeeRepository;

@Service
public class EmpManagementService {
	@Autowired
	EmployeeRepository employeeRepository;
	
    public List<Employee> getAllEmpoyees(){
    	List<Employee> list=null;
    	try {
           list=(List<Employee>) this.employeeRepository.findAll();
    	}catch(NoSuchElementException exception) {
    		System.out.println(exception);
    	}
    	return list;
    }
    
    public void updateEmployee(Employee emp,String id) {
    	Optional<Employee> optional=employeeRepository.findById(id);
    	Employee employee=optional.get();
    	employee.setDob(emp.getDob());
    	employee.setEmail(emp.getEmail());
    	employee.setLocation(emp.getLocation());
    	employee.setName(emp.getName());
    	employeeRepository.save(employee);
    
    }
    
    public void addEmployee(Employee employee) {
    	try {
    	  employeeRepository.save(employee);
    	}catch(Exception exception) {
    		System.out.println(exception.getMessage());
    	}
    	
    }
  
    public Employee getEmployee(String id) {
    	Employee employee=null;
    	if(employeeRepository.existsById(id)) {
    		Optional<Employee> optional=employeeRepository.findById(id);
    		employee=optional.get();
    	}
      return employee;
    }
}
