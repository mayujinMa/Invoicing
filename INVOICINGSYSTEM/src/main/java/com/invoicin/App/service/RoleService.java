package com.invoicin.App.service;

import org.hibernate.sql.Delete;
import org.springframework.data.domain.Page;
import com.invoicin.App.entity.Role;

public interface RoleService {
	public Page<Role>  queryByDynamicSQLPage(String roleName ,Integer page, Integer size) ;
	Role findByRoleName(String roleName);
	int QueryByroleId(Integer roleId);
}

