package com.invoicin.App.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.dao.SupplierDao;
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
	 * @return localhost:8089/supplier/queryAll?page=1&limit=1
	 */
	  @RequestMapping("/queryAll") public Object queryAll(SupplierSearch search,
	  Integer page, Integer limit) {
		  Page<Supplier> asd = service.querySupplierByDynamicSQLPage(search, page, limit); //
//	  map.put("total", asd.getTotalElements()); //
//	  map.put("rows", asd.getContent());
	  return asd; }
	 
	  /**
	   * 查询所有供应商信息
	   * @return
	   */
	@RequestMapping("/query")
	public Object query() {
		List<Supplier> su = dao.findAll();

		return su;
	}
	 /**
	 * 添加单个对象
	 * @author
	 * @return
	 http://localhost:8089/Supplier/addSupplier?supplierLinkMan=里斯&supplierAddressId=河南省&supplierPhone=12312312312&SupplierText=xshhsb
	 */
	 @RequestMapping(value="addSupplier")
	 public Object addSupplier(Supplier supplier) {
	 Supplier cus = dao.save(supplier);
	 return cus;
	 }
	
	 /**
	 * 删除单个对象
	 * @author
	 * @return localhost:8090/Supplier/deleteSupplier?supplierId=1
	 */
	 @RequestMapping(value="deleteSupplier")
	 public Object deleteSupplier (Integer supplierId) {
	 Supplier supplier = dao.findOne(supplierId);//得到供应商id
	 supplier.setIsdelete(1);//设置状态为1,即为不可用
	 Supplier supplier2 = dao.save(supplier);//保存状态
	 int s = 0;
	 if (supplier2 != null) {
	 s=1;
	 }
	 return supplierId;
	 }

}