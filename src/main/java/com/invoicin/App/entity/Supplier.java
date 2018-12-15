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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="supplier")
/*@JsonInclude(Include.NON_NULL)*/
public class Supplier {
	@Id
	@GeneratedValue
	private Integer supplierId;//供应商id
	@Column(length=255)
	private String supplierLinkMan;//供应商联系人;
	@Column(length=11)
	private String supplierPhone;//供应商联系电话;
	@Column(length=255)
	private String supplierAddressId;//供应商地址
	private String supplierText;//备注
	private Integer Isdelete;
	
	//@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="suppliercompany", joinColumns={@JoinColumn(name="supplierId")},            
    inverseJoinColumns={@JoinColumn(name="companyId")})
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<CompanyInfo> companys=new HashSet<CompanyInfo>();
	
	
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierLinkMan() {
		return supplierLinkMan;
	}
	public void setSupplierLinkMan(String supplierLinkMan) {
		this.supplierLinkMan = supplierLinkMan;
	}
	public String getSupplierPhone() {
		return supplierPhone;
	}
	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}
	public String getSupplierAddressId() {
		return supplierAddressId;
	}
	public void setSupplierAddressId(String supplierAddressId) {
		this.supplierAddressId = supplierAddressId;
	}
	public String getSupplierText() {
		return supplierText;
	}
	public void setSupplierText(String supplierText) {
		this.supplierText = supplierText;
	}
	public Integer getIsdelete() {
		return Isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		Isdelete = isdelete;
	}
	public Set<CompanyInfo> getCompanys() {
		return companys;
	}
	public void setCompanys(Set<CompanyInfo> companys) {
		this.companys = companys;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierLinkMan=" + supplierLinkMan + ", supplierPhone="
				+ supplierPhone + ", supplierAddressId=" + supplierAddressId + ", supplierText=" + supplierText
				+ ", Isdelete=" + Isdelete + ", companys=" + companys + "]";
	}
	public Supplier(Integer supplierId, String supplierLinkMan, String supplierPhone, String supplierAddressId,
			String supplierText, Integer isdelete, Set<CompanyInfo> companys) {
		super();
		this.supplierId = supplierId;
		this.supplierLinkMan = supplierLinkMan;
		this.supplierPhone = supplierPhone;
		this.supplierAddressId = supplierAddressId;
		this.supplierText = supplierText;
		Isdelete = isdelete;
		this.companys = companys;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
