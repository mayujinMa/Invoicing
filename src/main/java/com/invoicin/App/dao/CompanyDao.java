package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.CompanyInfo;

public interface CompanyDao extends JpaRepository<CompanyInfo,Integer>{

	@Query(value="SELECT * FROM company WHERE company_name like %:companyName% ",nativeQuery=true)
	List<CompanyInfo> selByLike(@Param("companyName")String companyName);
}
