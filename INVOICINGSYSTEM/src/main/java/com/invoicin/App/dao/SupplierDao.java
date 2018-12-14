package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.invoicin.App.entity.CompanyInfo;
import com.invoicin.App.entity.Customers;
import com.invoicin.App.entity.Supplier;

public interface SupplierDao extends JpaRepository<Supplier, Integer>, JpaSpecificationExecutor<Supplier> {

	@Query(value = "SELECT COUNT(*) FROM supplier WHERE isdelete=0", nativeQuery = true)
	int querycount();

	@Query(value = "SELECT * FROM supplier WHERE isdelete=0 ORDER BY supplier_id DESC LIMIT ?1,?2", nativeQuery = true)
	List<Supplier> queryall(Integer startRecord, Integer limit);
}
