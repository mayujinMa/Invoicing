package com.invoicin.App.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javassist.compiler.Javac.CtFieldWithInit;
import lombok.Data;

@Entity
@Table(name="provinces")
public class ProvinceInfo implements Serializable{

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length=6)
	private Integer provinceId;
	private String province;
	
	@ManyToMany
	@JoinTable(name="province_city_tb",joinColumns={@JoinColumn(name="provinceId")}
	,inverseJoinColumns= {@JoinColumn(name="cityId")})
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<City> city;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Set<City> getCity() {
		return city;
	}
	public void setCity(Set<City> city) {
		this.city = city;
	}
	public ProvinceInfo(Integer id, Integer provinceId, String province, Set<City> city) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.province = province;
		this.city = city;
	}
	public ProvinceInfo() {
		super();
	}
	
	
}
