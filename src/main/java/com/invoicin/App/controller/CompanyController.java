package com.invoicin.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.dao.CompanyDao;
import com.invoicin.App.entity.CompanyInfo;

@RestController
public class CompanyController {

	@Autowired
	private CompanyDao csdao;
	
	@RequestMapping("/queryname")
	public Object queryByName(String companyName,Integer page,Integer limit) {
		Pageable pageable = new PageRequest(page-1, limit);
		Page<CompanyInfo> list = csdao.findAll(pageable);
		return list;
	}
	
	@RequestMapping("/addcompany")
	public Object addCompany(CompanyInfo companyInfo) {
		CompanyInfo c = csdao.save(companyInfo);
		return c;
	}
	
	@RequestMapping("/updcompany")
	public Object updCompany(CompanyInfo companyInfo) {
		CompanyInfo c = csdao.save(companyInfo);
		return c;
	}
}
