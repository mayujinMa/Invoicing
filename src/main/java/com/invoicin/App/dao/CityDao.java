package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.City;
import com.invoicin.App.entity.ProvinceInfo;

public interface CityDao extends JpaRepository<City,String>,JpaSpecificationExecutor<City> {

	@Query(value="SELECT * FROM cities WHERE city like %:city% ",nativeQuery=true)
	List<City> selByLike(@Param("city")String city);
	
	City findByCityId(Integer cityId);
	
}
