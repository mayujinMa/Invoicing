package com.invoicin.App.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.ProvinceInfo;

public interface ProvinceService {
	
	List<ProvinceInfo> selByLike(String province);
	
	ProvinceInfo findByProvinceId(String provinceId);

}
