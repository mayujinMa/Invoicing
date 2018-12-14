package com.invoicin.App.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.invoicin.App.entity.Role;
public interface RoleDao extends JpaRepository<Role, Integer>,JpaSpecificationExecutor<Role> {
	Role findByRoleName(String roleName);
	@Query(value="SELECT COUNT(r.roleid)  FROM  employeewith_role  r WHERE r.roleid=?1",nativeQuery=true)
	int QueryByroleId(Integer roleId);
}
