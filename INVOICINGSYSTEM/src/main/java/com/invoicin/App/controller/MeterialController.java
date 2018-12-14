package com.invoicin.App.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invoicin.App.dao.MeterialDao;
import com.invoicin.App.dao.MetrialKindDao;
import com.invoicin.App.entity.Meterial;
import com.invoicin.App.entity.MeterialKind;
import com.invoicin.App.service.MetrialService;

@CrossOrigin
@RestController
@RequestMapping("/Meterial")

public class MeterialController {
	@Autowired
	private MeterialDao dao;
	@Autowired
	private MetrialKindDao mdao;
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	

	/**
	 * @author MAIBENBEN localhost:8090/Meterial/QueryAllMeterial?page=1&limit=10
	 */
	@RequestMapping("/QueryAllMeterial")
	public Object QueryAllMeterial(Integer page, Integer limit, String materialName) {
		int startRecord = (page - 1) * limit;
		List<Meterial> list = new ArrayList<Meterial>();
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
	@RequestMapping("/AddMeterial")
	public Object AddMeterial(Meterial Met) {
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
	@RequestMapping("/deleteMetrail")
	public Object deleteMetrail(Integer meterialId, String[] eventids) {
		if (meterialId != null) {
			Meterial meteria = dao.findOne(meterialId);
			meteria.setIsdelete(1);
			dao.save(meteria);
		} else {
			for (String string : eventids) {
				Meterial meteria = dao.findOne(Integer.parseInt(string));
				meteria.setIsdelete(1);
				dao.save(meteria);
			}
		}
		int r = 0;
		if (meterialId != null || eventids != null) {
			r = 1;
		}
		return r;
	}
}
