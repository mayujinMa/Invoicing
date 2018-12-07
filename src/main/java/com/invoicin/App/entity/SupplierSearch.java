package com.invoicin.App.entity;


public class SupplierSearch {
	private Integer supplierId;//供应商id
	private String supplierLinkMan;//供应商联系人;
	private String supplierPhone;//供应商联系电话;
	private String supplierText;//备注
	private Integer Isdelete;
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
	public SupplierSearch(Integer supplierId, String supplierLinkMan, String supplierPhone, String supplierText,
			Integer isdelete) {
		super();
		this.supplierId = supplierId;
		this.supplierLinkMan = supplierLinkMan;
		this.supplierPhone = supplierPhone;
		this.supplierText = supplierText;
		Isdelete = isdelete;
	}
	public SupplierSearch() {
		super();
	}
	@Override
	public String toString() {
		return "SupplierSearch [supplierId=" + supplierId + ", supplierLinkMan=" + supplierLinkMan + ", supplierPhone="
				+ supplierPhone + ", supplierText=" + supplierText + ", Isdelete=" + Isdelete + "]";
	}
	
	
	
	
}
