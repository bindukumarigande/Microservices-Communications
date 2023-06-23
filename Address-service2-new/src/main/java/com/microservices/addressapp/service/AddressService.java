package com.microservices.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.addressapp.entity.Address;
import com.microservices.addressapp.repository.AddressRepo;
import com.microservices.addressapp.response.AddressResponse;

@Service
public class AddressService {
	@Autowired
	AddressRepo addRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AddressResponse findAddressByEmployeeId(int empId) {
		Address address=addRepo.findAddressByEmployeeId(empId);
		
		AddressResponse addResponse=modelMapper.map(address, AddressResponse.class);
		return addResponse;
		
	}

}
