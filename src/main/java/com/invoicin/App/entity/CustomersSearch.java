package com.invoicin.App.entity;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

public class CustomersSearch {
	private Integer customerId;
	private String customerName;
	private String customerPhone;
	private String credentials;//身份证号
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date customerBirthday;
	private String customerBirthday;
	private String remark;
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
	public CustomersSearch(Integer customerId, String customerName, String customerPhone, String credentials,
			String customerBirthday, String remark) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.credentials = credentials;
		this.customerBirthday = customerBirthday;
		this.remark = remark;
	}
	public CustomersSearch() {
		super();
	}
	
	
}
