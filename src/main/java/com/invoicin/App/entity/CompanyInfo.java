package com.invoicin.App.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javassist.expr.NewArray;

@Entity
@Table(name = "company")
public class CompanyInfo {

	@Id
	@GeneratedValue
	private Integer companyId;
	@Column(length = 50)
	private String companyName;
	private String dutyparagraph;// 公司税号
	
	//@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="company_city", joinColumns={@JoinColumn(name="companyId")},            
    inverseJoinColumns={@JoinColumn(name="cId")}) 
	@NotFound(action = NotFoundAction.IGNORE)
	List<City> city = new ArrayList<City>();

	
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDutyparagraph() {
		return dutyparagraph;
	}

	public void setDutyparagraph(String dutyparagraph) {
		this.dutyparagraph = dutyparagraph;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public CompanyInfo(Integer companyId, String companyName, String dutyparagraph, List<City> city) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.dutyparagraph = dutyparagraph;
		this.city = city;
	}

	public CompanyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
