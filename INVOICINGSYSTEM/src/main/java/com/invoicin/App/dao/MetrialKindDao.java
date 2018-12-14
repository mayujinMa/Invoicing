package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicin.App.entity.MeterialKind;

public interface MetrialKindDao extends JpaRepository<MeterialKind, Integer>{
	List<MeterialKind> findByParentId(Integer parentId);
}
