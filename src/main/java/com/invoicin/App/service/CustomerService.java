package com.invoicin.App.service;

import org.springframework.data.domain.Page;

import com.invoicin.App.entity.Customers;
import com.invoicin.App.entity.CustomersSearch;

public interface CustomerService {

	Page<Customers> queryCustomersByDynamicSQLPage(CustomersSearch customersSearch,Integer page,Integer limit);
	
	//Integer selCount(Integer customerId);
}
