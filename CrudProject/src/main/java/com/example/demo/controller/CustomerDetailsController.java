package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.CustomerDetails;
import com.example.demo.requestDto.CustomerDetailsModifyReqDto;
import com.example.demo.requestDto.CustomerDetailsReqDto;
import com.example.demo.service.CustomerDetailsService;

@RestController
@RequestMapping("/CustomerDetails")
public class CustomerDetailsController {

	  @Autowired
	  private  CustomerDetailsService customerDetailsService;
	  
	 @PostMapping("/addCustomerDetails") 
	 public ResponseEntity<?> addCustomerDetails(@RequestBody CustomerDetailsReqDto customerDetailsReqDto)
	 {
		 try
	        {
	            String response = customerDetailsService.addCustomerDetails(customerDetailsReqDto);
	            return new ResponseEntity(response,HttpStatus.OK);

	        }
	        catch(Exception e)
	        {
	            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	 }
	 
	 @GetMapping("/fetchAllCustomerDetails")
	 public ResponseEntity<?> fetchAllCustomerDetails()
	 {
		 try
	        {
			    List<CustomerDetails> response = customerDetailsService.fetchAllCustomerDetails();
	            return new ResponseEntity(response,HttpStatus.OK);

	        }
	        catch(Exception e)
	        {
	            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	 }
	 
	 @PutMapping("/modifyCustomerDetails")
	 public ResponseEntity<?> modifyCustomerDetails(@RequestBody CustomerDetailsModifyReqDto customerDetailsModifyReqDto)
	 {
		 try
	        {
			    String response = customerDetailsService.modifyCustomerDetails(customerDetailsModifyReqDto);
	            return new ResponseEntity(response,HttpStatus.OK);

	        }
	        catch(Exception e)
	        {
	            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	 }
	 
	 @DeleteMapping("/deleteCustomerDetailsByUUID")
	 public ResponseEntity<?> deleteCustomerByUUID(@RequestParam UUID id)
	 {
		 try
	        {
			    String response = customerDetailsService.deleteCustomerByUUID(id);
	            return new ResponseEntity(response,HttpStatus.OK);

	        }
	        catch(Exception e)
	        {
	            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	 }
}
