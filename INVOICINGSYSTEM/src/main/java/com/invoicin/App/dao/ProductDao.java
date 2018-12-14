package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.Employee;
import com.invoicin.App.entity.Meterial;
import com.invoicin.App.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	@Query(value = "SELECT COUNT(*) FROM product WHERE isdelete=0", nativeQuery = true)
	int querycount();

	@Query(value = "SELECT * FROM product WHERE isdelete=0 ORDER BY product_id DESC LIMIT ?1,?2", nativeQuery = true)
	List<Product> queryall(Integer startRecord, Integer limit);

	@Query(value = "SELECT COUNT(*) FROM product WHERE isdelete=0 and product_name like %:materialName%  ", nativeQuery = true)
	int querycounter(@Param("materialName") String materialName);

	@Query(value = "SELECT * FROM product WHERE isdelete=0 and product_name like %?3% ORDER BY product_id DESC LIMIT ?1,?2", nativeQuery = true)
	List<Product> queryaller(Integer limit, Integer startRecord,String materialName);

}
