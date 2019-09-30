package com.srv.bookacab.customer;

import java.util.HashMap;
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

import com.srv.bookacab.driver.DriverService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DriverService driverService;

	@PostMapping("")
	public CustomerEntity createCustomer(@Valid @RequestBody CustomerEntity note) {
		return customerRepository.save(note);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/assignDriver/{customerId}")
	public ResponseEntity<HashMap> assignDriver(@PathVariable Long customerId) {
		HashMap<String, String> response = new HashMap<>();
		Optional<CustomerEntity> customer = customerRepository.findById(customerId);
		String message = "";
		if (customer.isPresent()) {
			message = driverService.assignDriver(customer.get());
		} else {
			message = "CustomerId Does Not Exist in db";
		}
		response.put("message", message);
		return new ResponseEntity<HashMap>(response, HttpStatus.OK);
	}
}
