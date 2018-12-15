package com.invoicin.App.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.invoicin.App.entity.Customers;
import com.invoicin.App.entity.CustomersSearch;

public interface CustomerDao extends JpaRepository<Customers, Integer>,JpaSpecificationExecutor<Customers>{

	List<Customers> findByCredentials(String credentials);

	@Query(value="UPDATE customertb SET credentials=?2,customer_birthday=?3, customer_name=?4,customer_phone=?5,remark=?6 WHERE customer_id=?1	 ",nativeQuery=true)
	@Modifying
	@Transactional
	Integer updCustomer(Integer customerId,String credentials,String customerBirthday,String customerName,String customerPhone,String remark);
	/**
	 * 通过顾客id查询顾客公司中间表的数量
	 * @param customerId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM customer_company WHERE customer_id=?1 ",nativeQuery=true)
	@Modifying
	Integer selCountCustomerId(Integer customerId);
	/**
	 *  通过顾客id删除顾客公司中间表的某条数据
	 * @return
	 */
	@Query(value="DELETE FROM customer_company WHERE customer_id =?1",nativeQuery=true)
	@Modifying
	Integer delCustCompByCustId(Integer customerId);
	
	@Query(value="DELETE FROM customer WHERE customer_id=?1",nativeQuery=true)
	@Modifying
	Integer delByCusId(Integer customerId);

}
