package com.nagarro.EmployeeWebService.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.EmployeeWebService.entities.Employee;
import com.nagarro.EmployeeWebService.services.EmpManagementService;

@RestController
public class EmpManagementController {
   @Autowired
   EmpManagementService empManagementService;
   
   @GetMapping("/employees")
   public ResponseEntity<List<Employee>> listAllEmployees(){
	   List<Employee> list=(List<Employee>) this.empManagementService.getAllEmpoyees();
   	     if(list.size()<=0)
   		     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   	   return ResponseEntity.of(Optional.of(list));
   }
   
   @PutMapping("/employees/{id}")
   public void upadateEmployee(@RequestBody Employee e,@PathVariable String id) {
	   empManagementService.updateEmployee(e,id);
   }
   
   @PostMapping("/employees")
   public void addEmployee(@RequestBody Employee employee) {
	   empManagementService.addEmployee(employee);
	  
   }
   
   @GetMapping("/employees/{id}")
   public Employee getOneEmployee(@PathVariable String id) {
	   return empManagementService.getEmployee(id);
   }
   
}
