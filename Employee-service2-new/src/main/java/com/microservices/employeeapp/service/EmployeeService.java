package com.microservices.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.employeeapp.entity.Employees;
import com.microservices.employeeapp.feignclient.AddressClient;
import com.microservices.employeeapp.repository.EmployeeRepo;
import com.microservices.employeeapp.response.AddressResponse;
import com.microservices.employeeapp.response.EmployeeResponse;

@Service
//In EmployeeService we will write the methods to call the db
public class EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AddressClient addressClient;
	
	
	
	public EmployeeResponse getEmployeeById(int empId) {
		// addresponse => set data by making a rest api call

		Employees emp = empRepo.findById(empId).get();//database call ->10 seconds
		EmployeeResponse empResponse = modelMapper.map(emp, EmployeeResponse.class);
		// EmployeeResponse empResponse=new EmployeeResponse();
		// empResponse.setId(emp.getId());
		// empResponse.setEmployeeName(emp.getEmployeeName());
		// empResponse.setEmail(emp.getEmail());
		// empResponse.setBloodGroup(emp.getBloodGroup());
		// restTemplate.getForObject(url, response, urivariables)

		AddressResponse addressResponse =  addressClient.getAddressByEmployeeId( empId);

		empResponse.setAddressResponse(addressResponse);

		return empResponse;

	}

}
