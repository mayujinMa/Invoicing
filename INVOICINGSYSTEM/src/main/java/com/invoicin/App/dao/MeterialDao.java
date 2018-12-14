package com.invoicin.App.dao;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.Meterial;
import com.invoicin.App.entity.MeterialKind;

public interface MeterialDao extends JpaRepository<Meterial, Integer> {
	@Query(value = "SELECT COUNT(*) FROM meterial WHERE isdelete=0", nativeQuery = true)
	int querycount();

	@Query(value = "SELECT * FROM meterial WHERE isdelete=0 ORDER BY meterial_id DESC LIMIT ?1,?2", nativeQuery = true)
	List<Meterial> queryall(Integer startRecord, Integer limit);

	@Query(value = "SELECT COUNT(*) FROM meterial WHERE isdelete=0 and material_name like %:materialName%  ", nativeQuery = true)
	int querycounter(@Param("materialName") String materialName);

	@Query(value = "SELECT * FROM meterial WHERE isdelete=0 and material_name like %?3% ORDER BY meterial_id DESC LIMIT ?1,?2", nativeQuery = true)
	List<Meterial> queryaller(Integer limit, Integer startRecord, String materialName);
	
	
}
