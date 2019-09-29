package com.srv.bookacab.driver;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
	
	@Query(value="SELECT (3959 *acos(cos(radians(:latitude)) * cos(radians(d.latitude)) * cos(radians(d.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(d.latitude)))) AS distance, d FROM DriverEntitiy d ORDER BY distance", nativeQuery = true)
	public Map<String, DriverEntity> findNearestDriver(Double latitude, Double longitude);

}