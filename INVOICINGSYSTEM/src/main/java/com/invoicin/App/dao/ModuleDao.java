package com.invoicin.App.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.invoicin.App.entity.Module;
import com.invoicin.App.entity.Role;
public interface ModuleDao extends JpaRepository<Module, Integer>,JpaSpecificationExecutor<Module> {
	//public Page<Module>queryByDynamicSQLPage(String moduleName ,Integer page, Integer size) ;
	Module findByModuleName(String moduleName);
	@Query(value="SELECT COUNT(r.module_id) FROM rolewith_module r WHERE r.module_id=?1 ",nativeQuery=true)
	int QueryByroleId(Integer moduleId);
	
}
