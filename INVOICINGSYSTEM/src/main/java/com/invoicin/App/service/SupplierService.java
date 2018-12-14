package com.invoicin.App.service;

import org.springframework.data.domain.Page;
import com.invoicin.App.entity.Supplier;
import com.invoicin.App.entity.SupplierSearch;

public interface SupplierService {
	Page<Supplier> querySupplierByDynamicSQLPage(SupplierSearch supplierSearch,Integer page,Integer limit);
}
