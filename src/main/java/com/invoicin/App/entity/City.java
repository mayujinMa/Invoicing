package com.invoicin.App.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="cities")
public class City {
	@Id
	@GeneratedValue
	private Integer id;
	private String cityId;
	private String city;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public City(Integer id, String cityId, String city) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.city = city;
	}

	public City() {
		super();
	}

	
}
