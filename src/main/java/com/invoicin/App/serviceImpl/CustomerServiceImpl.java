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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.invoicin.App.dao.CustomerDao;
import com.invoicin.App.entity.Customers;
import com.invoicin.App.entity.CustomersSearch;
import com.invoicin.App.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao cusdao;
	@Override
	public Page<Customers> queryCustomersByDynamicSQLPage(CustomersSearch customersSearch, Integer page,
			Integer limit) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page-1,limit);
		return cusdao.findAll(this.getWhereCaluse(customersSearch),pageable);
	}
	private Specification<Customers> getWhereCaluse(CustomersSearch customersSearch) {
		// TODO Auto-generated method stub
		return new Specification<Customers>() {

			@Override
			public Predicate toPredicate(Root<Customers> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// ��̬SQL���ʽ
				List<Expression<Boolean>> exList = predicate.getExpressions();// ��̬SQL���ʽ����
				if (customersSearch.getCustomerName()!= null && !"".equals(customersSearch.getCustomerName())) {
					exList.add(cb.like(root.<String>get("customerName"), "%" + customersSearch.getCustomerName() + "%"));
				}
				if (customersSearch.getCustomerPhone()!= null && !"".equals(customersSearch.getCustomerPhone())) {
					exList.add(cb.like(root.<String>get("customerPhone"), "%" + customersSearch.getCustomerPhone() + "%"));
				}
				if (customersSearch.getCredentials()!= null && !"".equals(customersSearch.getCredentials())) {
					exList.add(cb.like(root.<String>get("credentials"), "%" + customersSearch.getCredentials() + "%"));
				}
//				if (customersSearch.getCustomerBirthday()!= null) {
//					exList.add(cb.lessThanOrEqualTo(root.get("customerBirthday").as(Date.class),
//							customersSearch.getCustomerBirthday()));// С�ڵ��ڽ�ֹ����
//				}

				return predicate;
			}
		};
	}
	@Override
	public Integer updCus(Integer customerId, String credentials, String customerBirthday, String customerName,
			String customerPhone, String remark) {
		// TODO Auto-generated method stub
		return cusdao.updCustomer(customerId, credentials, customerBirthday, customerName, customerPhone, remark);
	}
	@Override
	public Customers addCustomer(Customers cus) {
		// TODO Auto-generated method stub
		return cusdao.save(cus);
	}
	@Override
	public List<Customers> findByCredentials(String credentials) {
		// TODO Auto-generated method stub
		return cusdao.findByCredentials(credentials);
	}
	@Override
	public Customers selByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return cusdao.getOne(customerId);
	}
	@Override
	public Integer selCountCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return cusdao.selCountCustomerId(customerId);
	}
	@Override
	public Integer delCustCompByCustId(Integer customerId) {
		// TODO Auto-generated method stub
		return cusdao.delCustCompByCustId(customerId);
	}
	@Override
	public Integer delByCusId(Integer customerId) {
		// TODO Auto-generated method stub
		return cusdao.delByCusId(customerId);
	}
	
	
}
