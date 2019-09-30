package com.srv.bookacab.driver;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srv.bookacab.customer.CustomerEntity;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;

	@Transactional
	public String assignDriver(CustomerEntity customer) {
		if (driverRepository.findByCustomer(customer) != null) {
			return "Customer has already booked car" + customer.getCustomerName();
		}
		List<DriverEntity> driverList = driverRepository.findNearestDriver(customer.getLatitude(),
				customer.getLongitude());
		if (driverList.isEmpty()) {
			return "No driver Available";
		}
		DriverEntity driver = driverList.get(0);
		driver.setCustomer(customer);
		driverRepository.save(driver);
		return driver.getDriverName() + " Assigned to Customer " + customer.getCustomerName();
	}

}
