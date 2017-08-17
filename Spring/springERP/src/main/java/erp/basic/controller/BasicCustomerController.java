package erp.basic.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.basic.domain.Customer;
import erp.basic.service.BasicCustomerService;
import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;

@Controller
@RequestMapping("/basic/customer/*")
public class BasicCustomerController {
	
	@Inject
	private BasicCustomerService service;
	
	@RequestMapping("list")
	public String customerList(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("left","basic/basic.jsp");
		model.addAttribute("contents","basic/basic_customerList.jsp");
		return "/main";
	}
	@RequestMapping("getCustomer")
	@ResponseBody
	public List<Customer> getCustomer(@RequestParam("customer_id") String customer_id,Model model)throws Exception{
		return service.getCustomer(customer_id);
	}
	@RequestMapping("update")
	public String customerUpdate(Customer customer)throws Exception{
		service.customerUpdate(customer);
		return "redirect:/basic/customer/list";
	}
	@RequestMapping("insert")
	public String customerInsert(Customer customer)throws Exception{
		service.customerInsert(customer);
		return "redirect:/basic/customer/list";
	}
	@RequestMapping("delete")
	public String customerDelete(@RequestParam("array") String[] array)throws Exception{
		for(int i=0;i<array.length;i++){
			service.customerDelete(array[i]);
		}
		return "redirect:/basic/customer/list";
	}
}
