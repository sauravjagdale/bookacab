package com.srv.bookacab.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

	@Autowired
	private DriverRepository driverRepository;

	@GetMapping("")
	public List<DriverEntity> getAllDriver() {
		return driverRepository.findAll();
	}
}
