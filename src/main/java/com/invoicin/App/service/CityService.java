package com.invoicin.App.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.City;
import com.invoicin.App.entity.ProvinceInfo;

public interface CityService {
	
	List<City> selByLike(String city);
	
	City findByCityId(Integer cityId);

}
