package com.invoicin.App.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.invoicin.App.entity.Customers;
import com.invoicin.App.entity.Supplier;

public interface SupplierDao extends JpaRepository<Supplier, Integer>,JpaSpecificationExecutor<Supplier>{

}
