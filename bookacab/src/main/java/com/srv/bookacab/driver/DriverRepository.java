package com.srv.bookacab.driver;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
	
	@Query("SELECT d ,(3959 *acos(cos(radians(latitude)) * cos(radians(d.latitude)) * cos(radians(d.longitude) - radians(longitude)) + sin(radians(latitude)) * sin(radians(d.latitude)))) AS distance FROM DriverEntitiy d ORDER BY distance")
	public List<DriverEntity> findNearestDriver(Double latitude, Double longitude);

}