package erp.stock.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import erp.basic.domain.Customer;
import erp.basic.service.BasicCustomerService;
import erp.stock.domain.StockRPSearch;
import erp.stock.service.StockRPService;

@Controller
@RequestMapping("/stock/rp/*")
public class StockRPController {
	
	@Inject
	private StockRPService service;
	@Inject
	private BasicCustomerService customerService;
	
	@RequestMapping("/insert_form")
	public String stockRpForm(Model model) throws Exception{

		model.addAttribute("list", service.productList());
		model.addAttribute("clist", customerService.customerList());
		model.addAttribute("left", "stock/stock.jsp");
		model.addAttribute("contents", "stock/stock_search_calendar.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/stockRP_search", method=RequestMethod.GET)
	public String stockRP_search(Model model) throws Exception{
		
		model.addAttribute("list", service.productList());
		model.addAttribute("left", "stock/stock.jsp");
		model.addAttribute("contents", "stock/stock_search.jsp");
		
		return "/main";
	}
	
	@RequestMapping("/stockRP_searchList")
	public String stockRP_search_list(StockRPSearch search,Model model) throws Exception{
		System.out.println(search.getStart_date());
		System.out.println(search.getEnd_date());

		model.addAttribute("list", service.stockRPSearchList(search));
		model.addAttribute("left", "stock/stock.jsp");
		model.addAttribute("contents", "stock/stock_rp_list.jsp");
		
		return "/main";
	}
	
	@RequestMapping("/stock_list")
	public String stock_list(Model model) throws Exception{
		model.addAttribute("list", service.stockList());
		model.addAttribute("left", "stock/stock.jsp");
		model.addAttribute("contents", "stock/stock_list.jsp");
		
		return "/main";
	}
	
}
