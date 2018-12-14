package com.invoicin.App.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.dao.SupplierDao;
import com.invoicin.App.entity.CompanyInfo;
import com.invoicin.App.entity.Supplier;
import com.invoicin.App.entity.SupplierSearch;
import com.invoicin.App.service.SupplierService;

@CrossOrigin
@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierDao dao;

	@Autowired
	private SupplierService service;

	Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 通过条件分页查询供应商信息
	 * 
	 * @return localhost:8089/supplier/queryAll?page=1&limit=1
	 */
	@RequestMapping("/queryAll")
	public Object queryAll(SupplierSearch search, Integer page, Integer limit) {
		Page<Supplier> asd = service.querySupplierByDynamicSQLPage(search, page, limit); //
		// map.put("total", asd.getTotalElements()); //
		// map.put("rows", asd.getContent());
		return asd;
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@RequestMapping("/all")
	public Object selall(Integer page, Integer limit) {
		int startRecord = (page - 1) * limit;
		List<Supplier> list = new ArrayList<Supplier>();
		int total = 0;
		total = dao.querycount();
		list = dao.queryall(startRecord, limit);
		map.put("count", total);
		map.put("data", list);
		map.put("code", 0);
		return map;
	}

	/**
	 * 查询所有供应商信息
	 * 
	 * @return
	 */
	@RequestMapping("/query")
	public Object query() {
		List<Supplier> su = dao.findAll();

		return su;
	}

	/**
	 * 添加单个对象
	 * 
	 * @author
	 * @return http://localhost:8089/Supplier/addSupplier?supplierLinkMan=里斯&supplierAddressId=河南省&supplierPhone=12312312312&SupplierText=xshhsb
	 */
	@RequestMapping(value = "addSupplier")
	public Object addSupplier(Supplier supplier) {
		Supplier cus = dao.save(supplier);
		int r = 0;
		if (cus != null) {
			r = 1;
		} else {
			r = 0;
		}
		return r;
	}


	
	
	/**localhost:8090/Supplier/deleteSupplier?supplierId=1
	 * @author MAIBENBEN 刪除批量刪除方法
	 */
	@RequestMapping("/deletesupplier")
	public Object deleteCompany(Integer supplierId, String[] eventids) {
		if (supplierId != null) {
			Supplier house = dao.findOne(supplierId);
			house.setIsdelete(1);
			dao.save(house);
		} else {
			for (String string : eventids) {
				Supplier house = dao.findOne(Integer.parseInt(string));
				house.setIsdelete(1);
				dao.save(house);
			}
		}
		int r = 0;
		if (supplierId != null || eventids != null) {
			r = 1;
		}
		return r;
	}

}