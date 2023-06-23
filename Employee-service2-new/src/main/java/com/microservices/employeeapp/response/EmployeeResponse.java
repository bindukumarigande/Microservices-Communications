package com.microservices.employeeapp.response;

public class EmployeeResponse {
	
private int empId;
private String employeeName;
private String email;
private String bloodGroup;
private AddressResponse addressResponse; 


public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBloodGroup() {
	return bloodGroup;
}
public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}
public AddressResponse getAddressResponse() {
	return addressResponse;
}
public void setAddressResponse(AddressResponse addressResponse) {
	this.addressResponse = addressResponse;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}

}
