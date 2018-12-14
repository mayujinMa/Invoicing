package com.invoicin.App.serviceImpl;


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
import com.invoicin.App.dao.SupplierDao;
import com.invoicin.App.entity.Supplier;
import com.invoicin.App.entity.SupplierSearch;
import com.invoicin.App.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDao sdao;
	@Override
	public Page<Supplier> querySupplierByDynamicSQLPage(SupplierSearch supplierSearch, Integer page,
			Integer limit) {
		Pageable pageable = new PageRequest(page-1,limit);
		return sdao.findAll(this.getWhereCaluse(supplierSearch),pageable);
	}
	private Specification<Supplier> getWhereCaluse(SupplierSearch supplierSearch) {
		return new Specification<Supplier>() {
			
			public Predicate toPredicate(Root<Supplier> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// ��̬SQL���ʽ
				List<Expression<Boolean>> exList = predicate.getExpressions();// ��̬SQL���ʽ����
				if (supplierSearch.getSupplierLinkMan()!= null && !"".equals(supplierSearch.getSupplierLinkMan()
						)) {
					exList.add(cb.like(root.<String>get("supplierLinkMan"), "%" + supplierSearch.getSupplierLinkMan() + "%"));
				}
				if (supplierSearch.getSupplierPhone()!= null && !"".equals(supplierSearch.getSupplierPhone()
						)) {
					exList.add(cb.like(root.<String>get("supplierPhone"), "%" + supplierSearch.getSupplierPhone() + "%"));
				}
				return predicate;
			}
		};
		
	}

	
}
