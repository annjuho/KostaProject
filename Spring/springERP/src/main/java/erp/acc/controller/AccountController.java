package erp.acc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.acc.basic.domain.Accounts;
import erp.acc.basic.domain.Diagnosiss;
import erp.acc.basic.service.BasicAccountService;
import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;



@Controller
@RequestMapping("/accounting/account")
public class AccountController {
	
	@Inject
	private BasicAccountService service;
	
	
	//계좌 리스트
	@RequestMapping("/list")
	public String accountList(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("listModel", service.accountList());
		model.addAttribute("contents", "accounting/basic/Account.jsp");
		return "/main";
	}
		
	//계좌등록 -JH
	@RequestMapping("/insert")
	public String accountInsert(Accounts accounts)throws Exception{
		service.accountInsert(accounts);
		return "redirect:/accounting/account/list";
	}
	
	//계좌수정 - JH
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String accountUpdate(Accounts accounts, Model model)throws Exception{
	service.accountUpdate(accounts);
	return "redirect:/accounting/account/list";
}
	//계좌삭제 -JH
	@RequestMapping("/delete")
	public String accountDelete(@RequestParam("count") String[] count )throws Exception{
		for (int i = 0; i < count.length; i++) {
			service.accountDelete(count[i]);
		}		
	return "redirect:/accounting/account/list";
	}
	
	//계좌리스트 페이징처리
	@RequestMapping(value="/Account", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);		
	}
	
	
	@RequestMapping(value="/test/list", method=RequestMethod.GET)
	public String moneyCheckView(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/basic/moneyCheck.jsp");
	return "/main";
	}
	
	
	
}
	

