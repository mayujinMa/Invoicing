package com.invoicin.App.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicin.App.dao.CityDao;
import com.invoicin.App.entity.City;
import com.invoicin.App.service.CityService;

@Service
public class CityServiceImpl implements CityService{
	@Autowired
	private CityDao cdao;
	@Override
	public List<City> selByLike(String city) {
		// TODO Auto-generated method stub
		return cdao.selByLike("%"+city+"%");
	}

	@Override
	public City findByCityId(Integer cityId) {
		// TODO Auto-generated method stub
		return cdao.findByCityId(cityId);
	}

}
