package com.invoicin.App.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicin.App.entity.CompanyInfo;

public interface CompanyDao extends JpaRepository<CompanyInfo,Integer>{

}
