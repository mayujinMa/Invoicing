package com.invoicin.App.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicin.App.dao.ProviceInfoDao;
import com.invoicin.App.entity.ProvinceInfo;
import com.invoicin.App.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProviceInfoDao pdao;

	@Override
	public List<ProvinceInfo> selByLike(String province) {
		// TODO Auto-generated method stub
		return pdao.selByLike("%"+province+"%");
	}
	@Override
	public ProvinceInfo findByProvinceId(String provinceId) {
		// TODO Auto-generated method stub
		return pdao.findByProvinceId(provinceId);
	}

}
