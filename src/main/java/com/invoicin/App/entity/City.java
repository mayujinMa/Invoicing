package com.invoicin.App.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

@Entity
@Table(name="cities")
public class City {
	@Id
	@GeneratedValue
	private Integer cId;
	private String cityId;
	private String city;
	
	@ManyToMany
	@JoinTable(name="city_province_tb",joinColumns={@JoinColumn(name="cId")}
	,inverseJoinColumns= {@JoinColumn(name="pId")})
	@NotFound(action = NotFoundAction.IGNORE)
	private List<ProvinceInfo> citys = new ArrayList<ProvinceInfo>();
	
	public City(Integer cId, String cityId, String city, List<ProvinceInfo> citys) {
		super();
		this.cId = cId;
		this.cityId = cityId;
		this.city = city;
		this.citys = citys;
	}
	public List<ProvinceInfo> getCitys() {
		return citys;
	}
	public void setCitys(List<ProvinceInfo> citys) {
		this.citys = citys;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
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
	public City(Integer cId, String cityId, String city) {
		super();
		this.cId = cId;
		this.cityId = cityId;
		this.city = city;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
