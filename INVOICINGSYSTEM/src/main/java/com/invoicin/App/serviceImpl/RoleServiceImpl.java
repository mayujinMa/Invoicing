package com.invoicin.App.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.invoicin.App.dao.EmployeeDao;
import com.invoicin.App.dao.RoleDao;
import com.invoicin.App.entity.Employee;
import com.invoicin.App.entity.EmployeeSerch;
import com.invoicin.App.entity.Role;
import com.invoicin.App.service.EmployeeService;
import com.invoicin.App.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;

	@Override
	public Page<Role> queryByDynamicSQLPage(String roleName ,Integer page, Integer size) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Sort.Direction.DESC,"roleId");
		Pageable pageable = new PageRequest(page, size, sort);
		return roleDao.findAll(this.getWhereClause(roleName),pageable);
	}

	private Specification<Role> getWhereClause(String roleName) {
		return new Specification<Role>() {
			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			Predicate predicate = cb.conjunction();//动态SQL表达式
			List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合
			if( roleName!= null && !"".equals(roleName) ){
				exList.add(cb.like(root.<String>get("roleName"), "%"+roleName+"%"));
				}
			return predicate;
			}
		};
	}

	@Override
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.findByRoleName(roleName);
	}

	@Override
	public int QueryByroleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleDao.QueryByroleId(roleId);
	}
	
	
	

}
