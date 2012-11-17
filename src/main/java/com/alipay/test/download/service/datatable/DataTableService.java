package com.alipay.test.download.service.datatable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.test.download.entity.DataTable;
import com.alipay.test.download.repository.DataTableDao;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class DataTableService {

	private DataTableDao dataTableDao;


	@Autowired
	public void setDataTableDao(DataTableDao dataTableDao) {
		this.dataTableDao = dataTableDao;
	}



	public List<DataTable> getAllData() {
		return (List<DataTable>) dataTableDao.findAll();
	}


}
