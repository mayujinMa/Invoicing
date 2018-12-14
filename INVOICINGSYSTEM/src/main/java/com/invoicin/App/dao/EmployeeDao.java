package com.invoicin.App.dao;

import java.util.List;

import org.hibernate.secure.internal.JaccSecurityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.invoicin.App.entity.Employee;
public interface EmployeeDao extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee> {
	@Query(value = "SELECT * FROM employee WHERE employee_card=?1 AND employee_pass_work=?2 ", nativeQuery = true)
	Employee querylogin(Integer employeeCard, String pwd);
	@Query(value = "SELECT * FROM employee WHERE employee_card=?1", nativeQuery = true)
	List<Employee> findByEmployeeName(String employeeCard); 

}
