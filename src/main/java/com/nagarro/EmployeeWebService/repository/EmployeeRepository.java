package com.nagarro.EmployeeWebService.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.EmployeeWebService.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee,String> {

}
