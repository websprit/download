package com.alipay.test.download.web.datatable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.test.download.entity.DataTable;
import com.alipay.test.download.service.account.AccountService;
import com.alipay.test.download.service.datatable.DataTableService;

/**
 * Task管理的Controller, 使用Restful风格的Urls:
 * 
 * List page     : GET /task/
 * Create page   : GET /task/create
 * Create action : POST /task/create
 * Update page   : GET /task/update/{id}
 * Update action : POST /task/update
 * Delete action : GET /task/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/data/line")
public class DataTableController {



	@Autowired
	private DataTableService dataTableService;
	
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<DataTable> datas = dataTableService.getAllData();
		model.addAttribute("datas", datas);

		return "data/line";
	}

}
