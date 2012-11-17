package com.alipay.test.download.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.alipay.test.download.entity.DataTable;

public interface DataTableDao extends PagingAndSortingRepository<DataTable, Long> {
	List<DataTable> findAll(Sort sort);;
}
