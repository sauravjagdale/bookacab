package com.srv.bookacab.customer;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srv.bookacab.driver.DriverEntity;
import com.srv.bookacab.driver.DriverRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@PostMapping("")
	public CustomerEntity createCustomer(@Valid @RequestBody CustomerEntity note) {
	    return customerRepository.save(note);
	}
	
	@GetMapping("/assignDriver/{customerId}")
	public ResponseEntity<String> assignDriver(@PathVariable Long customerId){
		Optional<CustomerEntity> customer = customerRepository.findById(customerId);
		if(customer.isPresent()) {
			DriverEntity drive = driverRepository.findNearestDriver(customer.get().getLatitude(), customer.get().getLongitude()).get(0);
			return new ResponseEntity<String>("driver Assigned to "+customerId, HttpStatus.OK);
		
		}else 
		return new ResponseEntity<String>("driver Assigned to "+customerId, HttpStatus.OK);
	}
}
