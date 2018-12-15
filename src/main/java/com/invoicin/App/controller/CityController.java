package com.invoicin.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.entity.City;
import com.invoicin.App.entity.ProvinceInfo;
import com.invoicin.App.service.CityService;
import com.invoicin.App.service.ProvinceService;

@RestController
public class CityController {
	@Autowired
	private CityService cService;
	
    @RequestMapping("/cityByname")
    public Object queryByname(String city) {
         List<City> pro = cService.selByLike(city);
         return pro;
    }
    @RequestMapping("/cityById")
    public Object findById(Integer cityId) {
    	City pro = cService.findByCityId(cityId);
    	return pro;
    }
}
