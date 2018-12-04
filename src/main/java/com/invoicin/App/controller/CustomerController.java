package com.invoicin.App.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.dao.CompanyDao;
import com.invoicin.App.dao.CustomerDao;
import com.invoicin.App.entity.CompanyInfo;
import com.invoicin.App.entity.Customers;
import com.invoicin.App.entity.CustomersSearch;
import com.invoicin.App.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDao csdao;
	@Autowired
	private CustomerService service;
	
	private Map<String,Object> map=new HashMap<String,Object>();
	//localhost:8089/customer/querypage?customerName=李海&page=1&limit=10
	@RequestMapping("/querypage")
	public Object queryByName(CustomersSearch customersSearch,Integer page,Integer limit) {
		
		System.out.println(customersSearch+"==========================");
		Page<Customers> cus = service.queryCustomersByDynamicSQLPage(customersSearch, page, limit);
//		List<Customers> list = cus.getContent();
//		Long count=cus.getTotalElements();
//		map.put("rows", list);
//		map.put("total", count);
		return cus;
	}
	
	@RequestMapping("/addcus")
	public Object addCustomer(Customers customers) {
		Customers cus = csdao.save(customers);
		return cus;
	}
	
	
}
