package com.microservices.addressapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservices.addressapp.entity.Address;

public interface AddressRepo extends JpaRepository <Address, Integer> {
	
	@Query(value="select * from Address where emp_id=:i",nativeQuery=true)
    Address findAddressByEmployeeId(@Param("i")int empId);

}
