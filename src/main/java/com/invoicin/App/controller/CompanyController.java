package com.invoicin.App.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.dao.CompanyDao;
import com.invoicin.App.entity.CompanyInfo;
import com.invoicin.App.entity.Customers;
import com.invoicin.App.service.CompanyService;
import com.invoicin.App.service.CustomerService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyDao csdao;
	@Autowired
	private CompanyService service;
	@Autowired
	private CustomerService cservice;
	
	private Map<String,Object> map=new HashMap<String,Object>();
	
	/**
	 * 通过公司名字查询
	 * @param companyName
	 * @return
	 */
	@RequestMapping("/query")
	public Object queryByName(String companyName) {
		List<CompanyInfo> list = service.selByLike(companyName);
		return list;
	}
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/all")
	public Object selall() {
		List<CompanyInfo> list = csdao.findAll();
		return list;
	}
	/**
	 * 添加公司信息
	 * @param companyInfo
	 * @return
	 */
	@RequestMapping("/addcompany")
	public Object addCompany(CompanyInfo companyInfo) {
		CompanyInfo c = csdao.save(companyInfo);
		return c;
	}
	/**
	 * 通过顾客id和公司id添加中间表信息
	 * @param customerId
	 * @param companyId
	 * @return
	 */
	@RequestMapping("/addcomp")
	public Object addCustAndComp(Integer customerId,Integer companyId) {
		Customers cust = cservice.selByCustomerId(customerId);//通过id得到顾客信息
		Set<CompanyInfo> set =cust.getCompany();
		CompanyInfo comp = service.selByCompanyId(companyId);//通过公司id拿到公司信息
		if(comp!=null) {
			set.add(comp);//添加公司信息
			cust.setCompany(set);//顾客里添加公司信息
		}
		//通过顾客id修改顾客信息即添加
		Integer n = cservice.updCus(customerId, cust.getCredentials(), cust.getCustomerBirthday(), 
				cust.getCustomerName(), cust.getCustomerPhone(), cust.getRemark());
		if (n>0) {
			map.put("success", true);
			map.put("message", "添加成功");
		}else {
			map.put("success", false);
			map.put("message", "添加失败");
		}
		return 0;
	}
	/**
	 * 修改公司信息
	 * @param companyInfo
	 * @return
	 */
	@RequestMapping("/updcompany")
	public Object updCompany(CompanyInfo companyInfo) {
		CompanyInfo c = csdao.save(companyInfo);
		return c;
	}
}
