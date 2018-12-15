package com.invoicin.App.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.invoicin.App.dao.CompanyDao;
import com.invoicin.App.entity.CompanyInfo;
import com.invoicin.App.entity.Customers;
import com.invoicin.App.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao cdao;

	@Override
	public List<CompanyInfo> selByLike(String companyName) {
		// TODO Auto-generated method stub
		return cdao.selByLike("%"+companyName+"%");
	}

	@Override
	public CompanyInfo selByCompanyId(Integer companyId) {
		// TODO Auto-generated method stub
		return cdao.getOne(companyId);
	}

	
}
