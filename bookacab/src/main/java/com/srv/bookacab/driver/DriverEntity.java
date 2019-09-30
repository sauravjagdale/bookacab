package com.srv.bookacab.driver;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.srv.bookacab.customer.CustomerEntity;

@Entity
@Table(name = "driver")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class DriverEntity implements Serializable {
	private static final long serialVersionUID = -242930786924611717L;
	public static final String TABLE_NAME = "driver";
	public static final String DRVIER_ID = "driver_id";
	public static final String DRIVER_NAME = "driver_name";
	public static final String CUSTOMER = "customer_id";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String CREATED_AT = "created_at";
	public static final String UPDATED_AT = "updated_at";

	@Id
	@Column(name = DRVIER_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = DRIVER_NAME)
	@NotBlank
	private String driverName;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = CustomerEntity.CUSTOMER_ID, nullable = true)
	private CustomerEntity customer;

	@Column(name = LATITUDE, nullable = false)
	@NotNull
	private Double latitude;

	@Column(name = LONGITUDE, nullable = false)
	@NotNull
	private Double longitude;

	@Column(name = CREATED_AT, nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(name = UPDATED_AT, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public DriverEntity() {

	}

	public DriverEntity(String driverName, Double latitude, Double longitude) {
		this.driverName = driverName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
