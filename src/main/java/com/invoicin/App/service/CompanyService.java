package com.invoicin.App.service;

import java.util.List;

import com.invoicin.App.entity.CompanyInfo;
import com.invoicin.App.entity.Customers;

public interface CompanyService {
	
	List<CompanyInfo> selByLike(String companyName);

	CompanyInfo selByCompanyId(Integer companyId);

}
