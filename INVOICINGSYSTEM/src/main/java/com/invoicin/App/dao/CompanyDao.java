package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.CompanyInfo;
import com.invoicin.App.entity.Warehouse;

public interface CompanyDao extends JpaRepository<CompanyInfo, Integer> {

	@Query(value = "SELECT * FROM company WHERE company_name like %:companyName% ", nativeQuery = true)
	List<CompanyInfo> selByLike(@Param("companyName") String companyName);

	@Query(value = "SELECT COUNT(*) FROM company WHERE isdelete=0", nativeQuery = true)
	int querycount();

	@Query(value = "SELECT * FROM company WHERE isdelete=0 ORDER BY company_id DESC LIMIT ?1,?2", nativeQuery = true)
	List<CompanyInfo> queryall(Integer startRecord, Integer limit);
}
