package com.invoicin.App.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.invoicin.App.entity.Employee;
import com.invoicin.App.entity.EmployeeSerch;
import com.invoicin.App.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employee;
	Map<String, Object> map = new HashMap<String, Object>();
	
	/* 
	 * 员工模糊查询
	 * @see com.invoicin.App.service.EmployeeService#queryByDynamicSQLPage(com.invoicin.App.entity.EmployeeSerch, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Page<Employee> queryByDynamicSQLPage(EmployeeSerch employeeSerch, Integer page, Integer size) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Sort.Direction.DESC,"employeeId");
		Pageable pageable = new PageRequest(page, size, sort);
		return employee.findAll(this.getWhereClause(employeeSerch), pageable);
		
	}
	
	/**
	 * 动态sql
	 * @param employeeSerch
	 * @return predicate
	 */
	private Specification<Employee> getWhereClause(final EmployeeSerch employeeSerch) {
		// TODO Auto-generated method stub
		return new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			Predicate predicate = cb.conjunction();//动态SQL表达式
			List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合
			if( employeeSerch.getEmployeeName() != null && !"".equals(employeeSerch.getEmployeeName()) ){
				exList.add(cb.like(root.<String>get("employeeName"), "%"+employeeSerch.getEmployeeName()+"%"));
				}
			if( employeeSerch.getEmployeeCard() != null && !"".equals(employeeSerch.getEmployeeCard()) ){
				exList.add(cb.like(root.<String>get("employeeCard"), "%"+employeeSerch.getEmployeeCard()+"%"));
				}
			exList.add(cb.lessThan(root.<Integer>get("isdelete"), 1));
			
			return predicate;
			}
		};
		}

	@Override
	public boolean delete(Integer employeeId) {
		// TODO Auto-generated method stub
		boolean boo=false;
		Employee employee2 = employee.findOne(employeeId);
		if (employee2 != null) {
			employee2.setIsdelete(1);
			Employee employee1 = employee.save(employee2);
			if (employee1 != null) {
				boo=true;
			}
		}
		return boo;
	}

	@Override
	public List<Employee> findByEmployeeName(String employeeCard) {
		// TODO Auto-generated method stub
		return employee.findByEmployeeName(employeeCard);
	}

}
