package com.invoicin.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import com.invoicin.App.entity.Customers;

public interface CustomerDao extends JpaRepository<Customers, Integer>,JpaSpecificationExecutor<Customers>{

	//Integer count(Integer customerId);
	
}
