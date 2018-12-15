package com.invoicin.App.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.invoicin.App.dao.CustomerDao;
import com.invoicin.App.entity.Customers;
import com.invoicin.App.entity.CustomersSearch;
import com.invoicin.App.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	private Map<String,Object> map=new HashMap<String,Object>();
	/**
	 * 通过查询条件进行分页显示顾客信息
	 * localhost:8089/customer/querypage?&page=1&limit=10
	 * @param customersSearch
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/querypage")
	public Object queryByName(CustomersSearch customersSearch,Integer page,Integer limit) {
		Page<Customers> cus = service.queryCustomersByDynamicSQLPage(customersSearch, page, limit);
//		List<Customers> list = cus.getContent();
//		Long count=cus.getTotalElements();
//		map.put("rows", list);
//		map.put("total", count);
		return cus;
	}
	/**
	 * 添加顾客信息
	 * localhost:8089/customer/addcus?credentials=411282199401057533&customerName=狄中海&customerPhone=15639854756
	 * @param c
	 * @return
	 */
	@RequestMapping("/addcus")
	public Object addCustomer(Customers c) {
		//通过身份证号查询用户
		List<Customers> ulist = service.findByCredentials(c.getCredentials());
		//如果没有该用户就添加数据
		if(ulist==null||ulist.isEmpty()) {
			Customers cus = service.addCustomer(c);
			return cus;
		}else {
			map.put("success", false);
			map.put("msg", "添加失败");
			System.out.println("+++++++++++++");
			return map;
		}
	}
	//http://localhost:8089/customer/updcus?customerId=1&customerBirthday=1994-01-05
	//&credentials=422282199401057533&customerName=中海&customerPhone=15639854756&remark=测试用户
	/**
	 * 通过顾客Id,修改顾客信息
	 * @param customerId
	 * @param credentials
	 * @param customerBirthday
	 * @param customerName
	 * @param customerPhone
	 * @param remark
	 * @return
	 */
	@RequestMapping("/updcus")
	public Object updcus(Integer customerId,String credentials,String customerBirthday,String customerName,String customerPhone,String remark) {
		Integer bo = service.updCus(customerId, credentials, customerBirthday, customerName, customerPhone, remark);
		if(bo>0) {
			map.put("success", true);
			map.put("msg", "修改成功");
			System.out.println("1111111111111111");
		}else {
			map.put("success", false);
			map.put("msg", "修改失败");
			System.out.println("222222222222222222");
		}
		return map;
	}
	
	/**
	 * 通过顾客id删除
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/delcus")
	public Object delCustomers(Integer customerId) {
		Integer count = service.selCountCustomerId(customerId);//查询中间总条数
		if (count>0) {
			Integer cus = service.delCustCompByCustId(customerId);//通过id删除中间表
			if (cus>0) {
				Integer n = service.delByCusId(customerId);//删除顾客
				if (n>0) {
					map.put("success", true);
					map.put("msg", "删除成功");
				}else {
					map.put("success", false);
					map.put("msg", "删除失败");
				}
			}
		}else {
			Integer n = service.delByCusId(customerId);
			if (n>0) {
				map.put("success", true);
				map.put("msg", "删除成功");
			}else {
				map.put("success", false);
				map.put("msg", "删除失败");
			}
		}
		return customerId;
	}
	
}
