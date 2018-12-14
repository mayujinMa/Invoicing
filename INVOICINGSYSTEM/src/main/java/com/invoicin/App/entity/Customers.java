package com.invoicin.App.entity;

import java.util.HashSet;
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

@Entity
@Table(name="customertb")
public class Customers {
	
	@Id
	@GeneratedValue
	private Integer customerId;
	@Column(length=50)
	private String customerName;
	private String customerPhone;
	private String credentials;//身份证号
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date customerBirthday;
	private String customerBirthday;
	private String remark;
	
	//@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="customer_company", joinColumns={@JoinColumn(name="customer_id")},            
		    inverseJoinColumns={@JoinColumn(name="company_id")}) 
	@NotFound(action = NotFoundAction.IGNORE)
	Set<CompanyInfo> company=new HashSet<CompanyInfo>();
	
	
	
	public Set<CompanyInfo> getCompany() {
		return company;
	}
	public void setCompany(Set<CompanyInfo> company) {
		this.company = company;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getCustomerBirthday() {
		return customerBirthday;
	}
	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Customers(Integer customerId, String customerName, String customerPhone, String credentials,
			String customerBirthday, String remark) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.credentials = credentials;
		this.customerBirthday = customerBirthday;
		this.remark = remark;
	}
	
	public Customers(Integer customerId, String customerName, String customerPhone, String credentials,
			String customerBirthday, String remark, Set<CompanyInfo> companyInfo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.credentials = credentials;
		this.customerBirthday = customerBirthday;
		this.remark = remark;
		this.company = companyInfo;
	}
	public Customers() {
		super();
	}
	
	
}
