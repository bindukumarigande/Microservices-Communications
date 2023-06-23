package com.microservices.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employeeapp.entity.Employees;
import com.microservices.employeeapp.repository.EmployeeRepo;
import com.microservices.employeeapp.response.EmployeeResponse;
import com.microservices.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepo empRepo;
	
	@GetMapping("/employees/{empId}")
	ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("empId") int empId){
		EmployeeResponse empResponse=employeeService.getEmployeeById(empId);
		//Employees emp=empRepo.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(empResponse);
		
	}
	
	@PostMapping("/employees")
	Employees addEmployees(@RequestBody Employees addEmployees) {
		return empRepo.save(addEmployees);
	}

}
