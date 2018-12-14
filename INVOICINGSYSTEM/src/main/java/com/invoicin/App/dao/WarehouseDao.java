package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.Employee;
import com.invoicin.App.entity.Meterial;
import com.invoicin.App.entity.Product;
import com.invoicin.App.entity.Warehouse;

public interface WarehouseDao extends JpaRepository<Warehouse, Integer> {
	@Query(value = "SELECT COUNT(*) FROM warehouse WHERE isdelete=0", nativeQuery = true)
	int querycount();

	@Query(value = "SELECT * FROM warehouse WHERE isdelete=0 ORDER BY warehouseid DESC LIMIT ?1,?2", nativeQuery = true)
	List<Warehouse> queryall(Integer startRecord, Integer limit);

	@Query(value = "SELECT COUNT(*) FROM warehouse WHERE isdelete=0 and warehousename like %:materialName%  ", nativeQuery = true)
	int querycounter(@Param("materialName") String materialName);

	@Query(value = "SELECT * FROM warehouse WHERE isdelete=0 and warehousename like %?3% ORDER BY warehouseid DESC LIMIT ?1,?2", nativeQuery = true)
	List<Warehouse> queryaller(Integer limit, Integer startRecord, String materialName);

}
