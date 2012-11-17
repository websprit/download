//package com.alipay.test.download.web.task;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.math.BigDecimal;
//import java.util.Map;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//
//import org.apache.shiro.SecurityUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springside.modules.web.Servlets;
//
//import com.alipay.test.download.entity.Task;
//import com.alipay.test.download.entity.User;
//import com.alipay.test.download.service.account.ShiroDbRealm.ShiroUser;
//import com.alipay.test.download.service.task.TaskService;
//import com.google.common.collect.Maps;
//
///**
// * Task管理的Controller, 使用Restful风格的Urls:
// * 
// * List page     : GET /task/
// * Create page   : GET /task/create
// * Create action : POST /task/create
// * Update page   : GET /task/update/{id}
// * Update action : POST /task/update
// * Delete action : GET /task/delete/{id}
// * 
// * @author calvin
// */
//@Controller
//@RequestMapping(value = "/task")
//public class CopyOfTaskController {
//
//	private static final int PAGE_SIZE = 3;
//
//	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
//	static {
//		sortTypes.put("auto", "自动");
//		sortTypes.put("title", "标题");
//	}
//
//	@Autowired
//	private TaskService taskService;
//
//	@RequestMapping(value = "")
//	public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
//			@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request) {
//
//		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Long userId = getCurrentUserId();
//
//		Page<Task> tasks = taskService.getUserTask(userId, searchParams, pageNumber, PAGE_SIZE, sortType);
//		model.addAttribute("tasks", tasks);
//		model.addAttribute("sortType", sortType);
//		model.addAttribute("sortTypes", sortTypes);
//		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
//
//		return "task/taskList";
//	}
//
//	@RequestMapping(value = "create", method = RequestMethod.GET)
//	public String createForm(Model model) {
//		model.addAttribute("task", new Task());
//		model.addAttribute("action", "create");
//		return "task/taskForm";
//	}
//	
//	@RequestMapping(value = "fangjia", method = RequestMethod.GET)
//	public String fangjia(Model model) {
//		model.addAttribute("action", "fangjia");
//		return "task/fangjiaForm";
//	}
//	
//	@RequestMapping(value = "xuefei", method = RequestMethod.GET)
//	public String xuefei(Model model) {
//		model.addAttribute("action", "xuefei");
//		return "task/xuefeiForm";
//	}
//	
//	@RequestMapping(value = "xuefei", method = RequestMethod.POST)
//	public String jisuan(String youeryuan,String xiaoxue,
//			String zhongxue,String gaozhong,String daxue,
//			String Axuenian,
//			String Bxuenian,String Cxuenian,
//			String Dxuenian,String Exuenian
//			,String zengz,Model model,RedirectAttributes redirectAttributes) {
//		Double youeryuan_d = Double.valueOf(youeryuan);
//		Double xiaoxue_d = Double.valueOf(xiaoxue);
//		Double zhongxue_d = Double.valueOf(zhongxue);
//		Double gaozhongi_d = Double.valueOf(gaozhong);
//		Double daxue_d = Double.valueOf(daxue);
//		Integer Ayears_i = Integer.valueOf(Axuenian);
//		Integer Byears_i = Integer.valueOf(Bxuenian);
//		Integer Cyears_i = Integer.valueOf(Cxuenian);
//		Integer Dyears_i = Integer.valueOf(Dxuenian);
//		Integer Eyears_i = Integer.valueOf(Exuenian);
//		Double zengz_d = Double.valueOf(5)/100;
//
//		int i = 0;
//		while(i < Ayears_i){
//			youeryuan_d = youeryuan_d * (1+zengz_d);
//			++i;
//		}
//		
//		BigDecimal totalamt = new BigDecimal(youeryuan_d).multiply(new BigDecimal(Axuenian));
//		
//		
//		 i = 0;
//		while(i < Byears_i){
//			xiaoxue_d = xiaoxue_d * (1+zengz_d);
//			++i;
//		}
//		
//		 totalamt =totalamt.add(  new BigDecimal(xiaoxue_d).multiply(new BigDecimal(Bxuenian)));
//		
//		 i = 0;
//		while(i < Cyears_i){
//			zhongxue_d = zhongxue_d * (1+zengz_d);
//			++i;
//		}
//		
//		 totalamt =totalamt.add(  new BigDecimal(zhongxue_d).multiply(new BigDecimal(Cxuenian)));
//		
//		 i = 0;
//		while(i < Dyears_i){
//			gaozhongi_d = gaozhongi_d * (1+zengz_d);
//			++i;
//		}
//		
//		 totalamt = totalamt.add( new BigDecimal(gaozhongi_d).multiply(new BigDecimal(Dxuenian)));
//		
//		 i = 0;
//		while(i < Eyears_i){
//			daxue_d = daxue_d * (1+zengz_d);
//			++i;
//		}
//		
//		 totalamt =totalamt.add( new BigDecimal(daxue_d).multiply(new BigDecimal(Exuenian)));
//		
//		redirectAttributes.addFlashAttribute("message", "毕业总费用：" + totalamt + "元");
//		return "redirect:/task";
//	}   
//
//	@RequestMapping(value = "create", method = RequestMethod.POST)
//	public String create(@Valid Task newTask, RedirectAttributes redirectAttributes) {
//		User user = new User(getCurrentUserId());
//		newTask.setUser(user);
//
//		taskService.saveTask(newTask);
//		redirectAttributes.addFlashAttribute("message", "创建任务成功");
//		return "redirect:/task/";
//	}
//
//	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
//	public String updateForm(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("task", taskService.getTask(id));
//		model.addAttribute("action", "update");
//		return "task/taskForm";
//	}
//
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(@Valid @ModelAttribute("preloadTask") Task task, RedirectAttributes redirectAttributes) {
//		taskService.saveTask(task);
//		redirectAttributes.addFlashAttribute("message", "更新任务成功");
//		return "redirect:/task/";
//	}
//
//	@RequestMapping(value = "delete/{id}")
//	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
//		taskService.deleteTask(id);
//		redirectAttributes.addFlashAttribute("message", "删除任务成功");
//		return "redirect:/task/";
//	}
//	
//	@RequestMapping(value = "love")
//	public String love(RedirectAttributes redirectAttributes) {
//		redirectAttributes.addFlashAttribute("message", "老婆真棒!");
//		return "redirect:/task/";
//	}
//	
//	@RequestMapping(value = "download", method = RequestMethod.GET)
//	public String download(HttpServletResponse response) {
//		response.setContentType("application/zip"); 
//	    response.setHeader("Content-Disposition","attachment; filename=\"DATA.ZIP\"");
//	    try {
//			OutputStream resOs= response.getOutputStream();  
//			byte[] zip = zipFiles();
//			resOs.write(zip);
//			resOs.flush();   
//			resOs.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	/**
//	 * Compress the given directory with all its files.
//	 */
//	private byte[] zipFiles() throws IOException {
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ZipOutputStream zos = new ZipOutputStream(baos);
//		byte bytes[] = "1234567".getBytes();
//
//		zos.putNextEntry(new ZipEntry("1.txt"));
//		zos.write(bytes);
//		zos.closeEntry();
//
//		zos.flush();
//		baos.flush();
//		zos.close();
//		baos.close();
//
//		return baos.toByteArray();
//	}
//
//	/**
//	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
//	 * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
//	 */
//	@ModelAttribute("preloadTask")
//	public Task getTask(@RequestParam(value = "id", required = false) Long id) {
//		if (id != null) {
//			return taskService.getTask(id);
//		}
//		return null;
//	}
//
//	/**
//	 * 取出Shiro中的当前用户Id.
//	 */
//	private Long getCurrentUserId() {
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		return user.id;
//	}
//}
