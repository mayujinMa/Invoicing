package com.invoicin.App.service;

import org.hibernate.sql.Delete;
import org.springframework.data.domain.Page;

import com.invoicin.App.entity.Module;
import com.invoicin.App.entity.Role;

public interface ModuleService {
	//public Page<Module>  queryByDynamicSQLPage(String moduleName ,Integer page, Integer size) ;
	Module findByModuleName(String moduleName);
	int QueryByroleId(Integer moduleId);
}

