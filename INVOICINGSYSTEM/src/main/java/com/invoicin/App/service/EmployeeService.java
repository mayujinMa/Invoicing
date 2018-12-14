package com.invoicin.App.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.invoicin.App.entity.Employee;
import com.invoicin.App.entity.EmployeeSerch;

public interface EmployeeService {
	List<Employee> findByEmployeeName(String employeeCard); 
	public boolean delete(Integer employeeId);
	public Page<Employee>  queryByDynamicSQLPage(EmployeeSerch employeeSerch, Integer page, Integer size) ;
}
