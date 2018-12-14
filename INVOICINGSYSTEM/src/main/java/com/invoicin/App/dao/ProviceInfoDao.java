package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.invoicin.App.entity.ProvinceInfo;

public interface ProviceInfoDao extends JpaRepository<ProvinceInfo,String>,JpaSpecificationExecutor<ProvinceInfo> {

	@Query(value="SELECT * FROM provinces WHERE province like %:province% ",nativeQuery=true)
	List<ProvinceInfo> selByLike(@Param("province")String province);
	
	ProvinceInfo findByProvinceId(String provinceId);
	
}
