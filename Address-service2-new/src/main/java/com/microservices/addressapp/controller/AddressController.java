package com.microservices.addressapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.addressapp.entity.Address;
import com.microservices.addressapp.repository.AddressRepo;
import com.microservices.addressapp.response.AddressResponse;
import com.microservices.addressapp.service.AddressService;


@RestController
public class AddressController {
	@Autowired
	private AddressService addService;
	@Autowired 
	private AddressRepo addRepo;
	
	@GetMapping("/address/{empId}")
	public  ResponseEntity<AddressResponse > getAddressByEmployeeId(@PathVariable("empId") int empId) {
		AddressResponse addResponse=null;
		addResponse= addService.findAddressByEmployeeId(empId);
		return ResponseEntity.status(HttpStatus.OK).body(addResponse);
		
		
	}
	@PostMapping("/address")
	Address addAddress(@RequestBody Address addEmployees) {
		return addRepo.save(addEmployees);
	}

}
