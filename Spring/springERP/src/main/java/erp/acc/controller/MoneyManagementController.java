package erp.acc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.acc.basic.domain.MoneyManagement;
import erp.acc.basic.domain.MoneyPlanTimeSet;
import erp.acc.basic.service.MoneyManagementService;

@Controller
@RequestMapping("/accounting/moneymanagement")
public class MoneyManagementController {

	@Inject
	private MoneyManagementService service;

	// �쁽湲덇�由� 由ъ뒪�듃
	@RequestMapping("/list")
	public String moneyPlanList(Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("listModel", service.moneyManageMentList());
		model.addAttribute("contents", "accounting/moneymanagement/inoutMoney.jsp");
		return "/main";
	}

	//�엯湲� all�옄湲덇퀎�쉷議고쉶
	@RequestMapping("/allListIn")
	@ResponseBody
	public List<MoneyPlanTimeSet> allListIn()throws Exception{
		return service.monseyPlanAllList("입금");
	}
	//異쒓툑 all�옄湲덇퀎�쉷議고쉶
	@RequestMapping("/allListOut")
	@ResponseBody
	public List<MoneyPlanTimeSet> allListOut()throws Exception{
		return service.monseyPlanAllList("출금");
	}	

	
	// 嫄곕옒泥섑쁽湲덇�由� �벑濡� - JH
	@RequestMapping(value = "/inoutCompanyMoney", method = RequestMethod.GET)
	public String inoutCompanyMoneyGET(Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/moneymanagement/inoutCompanyMoney.jsp");
		return "/main";
	}

	// 嫄곕옒泥섑쁽湲덇�由� �벑濡� -JH
	@RequestMapping(value = "/inoutCompanyMoney", method = RequestMethod.POST)
	public String inoutCompanyMoneyPOST(MoneyManagement mg, Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/moneymanagement/inoutCompanyMoney.jsp");
		service.moneyManageMentInsert(mg);
		System.out.println("�벑濡앸릺�뿀�뒿�땲�떎.");

		return "/main";
	}

	// 嫄곕옒泥섑쁽湲덇�由� �벑濡� - JH
	@RequestMapping(value = "/inoutMoney", method = RequestMethod.GET)
	public String inoutMoneyGET(Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/moneymanagement/inoutMoney.jsp");
		return "/main";
	}
	
	@RequestMapping("/useMoney")
	public String useMoney(@RequestParam("array") String[] array,Model model)throws Exception{
		List<MoneyPlanTimeSet> list = new ArrayList<MoneyPlanTimeSet>();
		for(int i=0;i<array.length;i++){
			list.add(service.useMoney(array[i]));
		}
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/moneymanagement/inoutMoney.jsp");
		model.addAttribute("list", list);
		return "/main";
	}

}
