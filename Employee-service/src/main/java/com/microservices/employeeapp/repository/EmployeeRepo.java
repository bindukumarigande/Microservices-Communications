package com.microservices.employeeapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.employeeapp.entity.Employees;

public interface EmployeeRepo extends JpaRepository <Employees,Integer> {

	//Optional<Employees> findById(int empId);

	

	

	
}
