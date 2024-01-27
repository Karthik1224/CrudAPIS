package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDetailsDao;
import com.example.demo.modal.CustomerDetails;
import com.example.demo.requestDto.CustomerDetailsModifyReqDto;
import com.example.demo.requestDto.CustomerDetailsReqDto;


@Service
public class CustomerDetailsService {

	@Autowired
	private CustomerDetailsDao customerDetailsDao;

	public String addCustomerDetails(CustomerDetailsReqDto customerDetailsReqDto) {
		if (customerDetailsReqDto == null) {
			return "Required CustmerDetails";
		}
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setFirstName(customerDetailsReqDto.getFirstName());
		customerDetails.setLastName(customerDetailsReqDto.getLastName());
		customerDetails.setDob(customerDetailsReqDto.getDob());
		customerDetails.setAadharNumber(customerDetailsReqDto.getAadharNumber());
		customerDetails.setMobileNumber(customerDetailsReqDto.getMobileNumber());
		customerDetails.setGender(customerDetailsReqDto.getGender());
		customerDetailsDao.save(customerDetails);
		return "CustomerDetails addded successfully";
	}
    
	public List<CustomerDetails> fetchAllCustomerDetails()
	{
		List<CustomerDetails>listOfCustomerDetails=customerDetailsDao.findAll();
		if(listOfCustomerDetails.isEmpty())
		{
			return null;
		}
		else
		{
			return listOfCustomerDetails;
		}
	}
	
	public String modifyCustomerDetails(CustomerDetailsModifyReqDto customerDetailsModifyReqDto)
	{
		Optional<CustomerDetails> optionalCustomer = customerDetailsDao.findById(customerDetailsModifyReqDto.getId());

		 if(optionalCustomer.isEmpty())
		 {
			 return "CustomerDetails does not exist";
		 }
		 else
		 {
			   CustomerDetails customerDetails = optionalCustomer.get();
			   customerDetails.setFirstName(customerDetailsModifyReqDto.getFirstName());
				customerDetails.setLastName(customerDetailsModifyReqDto.getLastName());
				customerDetails.setDob(customerDetailsModifyReqDto.getDob());
				customerDetails.setAadharNumber(customerDetailsModifyReqDto.getAadharNumber());
				customerDetails.setMobileNumber(customerDetailsModifyReqDto.getMobileNumber());
				customerDetails.setGender(customerDetailsModifyReqDto.getGender());
				customerDetailsDao.save(customerDetails);
				return "CustomerDetails modified successfully";
		 }
		
	}
	

	
	
	public String deleteCustomerByUUID(UUID id)
	{
		if(customerDetailsDao.existsById(id))
		{
			customerDetailsDao.deleteById(id);
			return "CustomerDetails deleted Successfully";
		}
		else {
			return "CustomerDetails does not exist";
		}
		 
		
	}
	
	
}
