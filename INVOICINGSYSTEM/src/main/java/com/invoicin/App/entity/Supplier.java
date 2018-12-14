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

import lombok.Data;

@Entity
@Table(name = "supplier")
@Data
/* @JsonInclude(Include.NON_NULL) */
public class Supplier {
	@Id
	@GeneratedValue
	private Integer supplierId;// 供应商id
	@Column(length = 255)
	private String supplierLinkMan;// 供应商联系人;
	@Column(length = 11)
	private String supplierPhone;// 供应商联系电话;
	@Column(length = 255)
	private String supplierAddressId;// 供应商地址
	private String supplierText;// 备注
	private Integer isdelete;

	// @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "suppliercompany", joinColumns = { @JoinColumn(name = "supplierId") }, inverseJoinColumns = {
			@JoinColumn(name = "companyId") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<CompanyInfo> companys = new HashSet<CompanyInfo>();
}
