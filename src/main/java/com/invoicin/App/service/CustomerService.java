package com.invoicin.App.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.invoicin.App.entity.Customers;
import com.invoicin.App.entity.CustomersSearch;
import com.invoicin.App.entity.Supplier;
import com.invoicin.App.entity.SupplierSearch;

public interface CustomerService {
	
	List<Customers> findByCredentials(String credentials);
	
	Integer updCus(Integer customerId,String credentials,String customerBirthday,String customerName,String customerPhone,String remark);

	Page<Customers> queryCustomersByDynamicSQLPage(CustomersSearch customersSearch, Integer page, Integer limit);

	Customers addCustomer(Customers cus);
	
	Customers selByCustomerId(Integer customerId);
	
	Integer selCountCustomerId(Integer customerId);
	
	Integer delByCusId(Integer customerId);
	
	Integer delCustCompByCustId(Integer customerId);

}
