package com.microservices.employeeapp.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.employeeapp.response.AddressResponse;
@Service
@FeignClient(name="address-service",url="http://localhost:9999",path="/address/api/")
public interface AddressClient {
	
   @GetMapping("address/{empId}")
	AddressResponse getAddressByEmployeeId( @PathVariable("empId")int empId);
     
		
	

}
