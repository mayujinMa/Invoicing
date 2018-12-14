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
import com.invoicin.App.dao.ModuleDao;
import com.invoicin.App.dao.RoleDao;
import com.invoicin.App.entity.Employee;
import com.invoicin.App.entity.EmployeeSerch;
import com.invoicin.App.entity.Module;
import com.invoicin.App.entity.Role;
import com.invoicin.App.service.EmployeeService;
import com.invoicin.App.service.ModuleService;
import com.invoicin.App.service.RoleService;

@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleDao mDao;

	/* 
	 * 模块查询
	 * @see com.invoicin.App.service.ModuleService#queryByDynamicSQLPage(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	/*@Override
	public Page<Module> queryByDynamicSQLPage(String moduleName, Integer page, Integer size) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Sort.Direction.DESC, "moduleId");
		Pageable pageable = new PageRequest(page, size, sort);
		return mDao.findAll(this.getWhereClause(moduleName), pageable);
	}
	private Specification<Module> getWhereClause(String moduleName) {
		return new Specification<Module>() {
			@Override
			public Predicate toPredicate(Root<Module> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			Predicate predicate = cb.conjunction();//动态SQL表达式
			List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合
			if( moduleName!= null && !"".equals(moduleName)){
				exList.add(cb.like(root.<String>get("moduleName"), "%"+moduleName+"%"));
				}
			exList.add(cb.lessThan(root.<Integer>get("state"), 1));
			return predicate;
			}
		};
	}*/
	/*
	 * 通过模块名称查询单个模块
	 *  (non-Javadoc)
	 * @see com.invoicin.App.service.ModuleService#findByRoleName(java.lang.String)
	 */
	@Override
	public Module findByModuleName(String moduleName) {
		// TODO Auto-generated method stub
		return mDao.findByModuleName(moduleName);
	}
	
	/* 
	 * 
	 * (non-Javadoc)
	 * @see com.invoicin.App.service.ModuleService#QueryByroleId(java.lang.Integer)
	 */
	@Override
	public int QueryByroleId(Integer moduleId) {
		// TODO Auto-generated method stub
		return mDao.QueryByroleId(moduleId);
	}

	
	
	
	

}
