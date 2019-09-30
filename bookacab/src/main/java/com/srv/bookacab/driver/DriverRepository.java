package com.srv.bookacab.driver;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.srv.bookacab.customer.CustomerEntity;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {

	@Query(value = "SELECT * FROM driver as d WHERE customer_id IS NULL ORDER BY (3959 *acos(cos(radians(:latitude)) * cos(radians(d.latitude)) * cos(radians(d.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(d.latitude))))", nativeQuery = true)
	public List<DriverEntity> findNearestDriver(Double latitude, Double longitude);

	public DriverEntity findByCustomer(CustomerEntity customer);

}