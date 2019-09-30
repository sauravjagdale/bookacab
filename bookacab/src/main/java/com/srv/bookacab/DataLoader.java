package com.srv.bookacab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.srv.bookacab.driver.DriverEntity;
import com.srv.bookacab.driver.DriverRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private DriverRepository driverRepository;

	@Autowired
	public DataLoader(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	// ON INIT create 5 drivers
	public void run(ApplicationArguments args) {
		driverRepository.save(new DriverEntity("Driver 1", 19.13, 72.83));
		driverRepository.save(new DriverEntity("Driver 2", 27.43, 35.64));
		driverRepository.save(new DriverEntity("Driver 3", 36.13, 67.84));
		driverRepository.save(new DriverEntity("Driver 4", 79.13, 52.61));
		driverRepository.save(new DriverEntity("Driver 5", 15.13, 75.83));
	}
}
