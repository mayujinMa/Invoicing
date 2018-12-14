package com.invoicin.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.entity.ProvinceInfo;
import com.invoicin.App.service.ProvinceService;

@RestController
@RequestMapping("/province")
public class ProvinceController {
	@Autowired
	private ProvinceService pService;
	
	//http://localhost:8089/queryByname?province=河
    @RequestMapping("/queryByname")
    public Object queryByname(String province) {
         List<ProvinceInfo> pro = pService.selByLike(province);
         return pro;
    }
    @RequestMapping("/queryById")
    public Object findById(String provinceId) {
    	ProvinceInfo pro = pService.findByProvinceId(provinceId);
    	return pro;
    }
}
