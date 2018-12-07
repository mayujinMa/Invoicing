package com.invoicin.App.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class ProvinceInfo{

	@Id
	@GeneratedValue
	@Column(length=6)
	private Integer pId;
	private Integer provinceId;
	private String province;
	
//	@ManyToMany
//	@JoinTable(name="province_city_tb",joinColumns={@JoinColumn(name="pId")}
//	,inverseJoinColumns= {@JoinColumn(name="cId")})
//	@NotFound(action = NotFoundAction.IGNORE)
//	private List<City> city = new ArrayList<City>();

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
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

//	public List<City> getCity() {
//		return city;
//	}
//
//	public void setCity(List<City> city) {
//		this.city = city;
//	}
//
//	public ProvinceInfo(Integer pId, Integer provinceId, String province, List<City> city) {
//		super();
//		this.pId = pId;
//		this.provinceId = provinceId;
//		this.province = province;
//		this.city = city;
//	}

	public ProvinceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
