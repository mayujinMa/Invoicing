package com.invoicin.App.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class CompanyInfo {
	
	@Id
	@GeneratedValue
	private Integer companyId;
	@Column(unique=true)
	private String companyName;
	private String dutyparagraph;//公司税号
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
	public CompanyInfo(Integer companyId, String companyName, String dutyparagraph) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.dutyparagraph = dutyparagraph;
	}
	public CompanyInfo() {
		super();
	}
	
	

}
