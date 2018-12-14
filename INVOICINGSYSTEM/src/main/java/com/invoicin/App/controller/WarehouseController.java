package com.invoicin.App.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.dao.ProductDao;
import com.invoicin.App.dao.WarehouseDao;
import com.invoicin.App.entity.Product;
import com.invoicin.App.entity.Warehouse;

@CrossOrigin
@RestController
@RequestMapping("Warehouse")

public class WarehouseController {
	@Autowired
	private WarehouseDao dao;
	Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * @param page
	 * @param limit
	 * @return localhost:8090/Product/queryProduct/?page=1&rows=10
	 */
	@RequestMapping("/queryWarehouse")
	public Object queryProduct(Integer page, Integer limit, String materialName) {
		int startRecord = (page - 1) * limit;
		List<Warehouse> list = new ArrayList<Warehouse>();
		int total = 0;
		if (materialName == null) {
			total = dao.querycount();
			list = dao.queryall(startRecord, limit);
		} else {
			total = dao.querycounter(materialName);
			list = dao.queryaller(startRecord, limit, materialName);

		}

		map.put("count", total);
		map.put("data", list);
		map.put("code", 0);
		return map;
	}

	/**
	 * @author MAIBENBEN 添加修改方法
	 */
	@RequestMapping("/AddWarehouse")
	public Object AddProduct(Warehouse Met) {
		dao.save(Met);
		int r = 0;
		if (Met != null) {
			r = 1;
		}
		return r;
	}

	/**
	 * @author MAIBENBEN 刪除批量刪除方法
	 */
	@RequestMapping("/deleteWarehouse")
	public Object deleteproduct(Integer warehouseid, String[] eventids) {
		if (warehouseid != null) {
			Warehouse house = dao.findOne(warehouseid);
			house.setIsdelete(1);
			dao.save(house);
		} else {
			for (String string : eventids) {
				Warehouse house = dao.findOne(Integer.parseInt(string));
				house.setIsdelete(1);
				dao.save(house);
			}
		}
		int r = 0;
		if (warehouseid != null || eventids != null) {
			r = 1;
		}
		return r;
	}
}
