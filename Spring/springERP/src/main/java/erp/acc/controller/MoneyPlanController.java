package erp.acc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.acc.basic.domain.MoneyPlanTimeSet;
import erp.acc.basic.service.MoneyPlanService;

@Controller
@RequestMapping("/accounting/moneyPlan/*")
public class MoneyPlanController {

	@Inject
	private MoneyPlanService service;
	
	// 자금계획현금 리스트
	@RequestMapping("/list")
	public String moneyPlanList(Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("listModel", service.moneyPlanList());
		model.addAttribute("contents", "accounting/moneyPlan/MoneyPlan_view.jsp");
		return "/main";
	}
	//자금계획전표 리스트
	@RequestMapping("/promissorylist")
	public String moneyPlnapromissoryList(Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("listModel", service.moneyPlnapromissoryList());
		model.addAttribute("contents", "accounting/moneyPlan/MoneyPlan_promissory_view.jsp");
		return "/main";
	}
	

	// 자금계획등록 화면
	@RequestMapping(value="/MoneyPlan_Add", method=RequestMethod.GET)
	public String MoneyPlan_AddGET(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/moneyPlan/MoneyPlan_Add.jsp");
		return "/main";
	}
	
	
	// 자금계획등록 -JH
	@RequestMapping(value="/MoneyPlan_Add", method=RequestMethod.POST)
	public String MoneyPlan_AddPOST(MoneyPlanTimeSet plan, Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/moneyPlan/MoneyPlan_Add.jsp");		
		service.moneyPlanInsert(plan);
		System.out.println("등록되었습니다.");
	
		return "/main";
	}	
	
	
	// 자금계획수정 - JH
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String moneyPlanUpdate(MoneyPlanTimeSet plan, Model model) throws Exception {
		service.moneyPlanUpdate(plan);
		return "redirect:/accounting/moneyPlan/list";
	}

	// 자금계획삭제 -JH
	@RequestMapping("/delete")
	public String moneyPlanDelete(@RequestParam("cmt") String[] cmt) throws Exception {
		for (int i = 0; i < cmt.length; i++) {
			service.moneyPlanDelete(cmt[i]);
		}
		return "redirect:/accounting/moneyPlan/list";
	}
	
	@RequestMapping("/MoneyPlan_calendar")
	public String MoneyPlan_calendar(Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/moneyPlan/MoneyPlan_calendar.jsp");
		return "/main";
	}
}
