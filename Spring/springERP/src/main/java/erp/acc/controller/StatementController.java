package erp.acc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import erp.acc.basic.service.StatementService;

@Controller
@RequestMapping("/StateMent/*")
public class StatementController {

	@Inject
	private StatementService service;
	
	//매입청구서
	@RequestMapping(value = "StatementAllPurchaseList", method=RequestMethod.GET)
	public String StatementPurchaseListGET(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("AllPurchase", service.StatementAllPurchaseList());
	/*	model.addAttribute("CashPurchase", service.StatementCashPurchaseList());*/
		model.addAttribute("contents", "accounting/statements/Statement_purchaseList.jsp");
		
		return "/main";
	}	
	
	
	//매출 청구서
	@RequestMapping(value = "StatementAllSalesList", method=RequestMethod.GET)
	public String StatementSalesListGET(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("Allsales", service.StatementAllSalesList());
		/*model.addAttribute("Cashsales", service.StatementCashSalesList());*/
		model.addAttribute("contents", "accounting/statements/Statemnet_SalesList.jsp");
		
		return "/main";		
	}
	
	/*@RequestMapping(value = "StatementSalesList", method=RequestMethod.POST)
	public String StatementSalesListPOST(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		
		model.addAttribute("contents", "accounting/statements/Statement_purchaseList.jsp");			
		return "/main";
	}*/
	
	//전표조회
	@RequestMapping(value = "StatementAllViewList", method=RequestMethod.GET)
	public String StatementAllViewListGET(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("Allsales", service.StatementAllSalesList());
		model.addAttribute("AllPurchase", service.StatementAllPurchaseList());
		model.addAttribute("contents", "accounting/statements/Statement_AllView.jsp");
		return "/main";
	}
	
}
