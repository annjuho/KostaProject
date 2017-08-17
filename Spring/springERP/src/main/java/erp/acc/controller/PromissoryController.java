package erp.acc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.acc.basic.domain.Promissory;
import erp.acc.basic.service.PromissoryService;

@Controller
@RequestMapping("/accounting/promissory/*")
public class PromissoryController {

	@Inject
	private PromissoryService service;

	//어음원장
	@RequestMapping("/list")
	public String promissoryList(Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("listModel", service.promissoryList());
		model.addAttribute("contents", "accounting/promissory2/promissory_noteAll.jsp");
		return "/main";
	}

	//어음등록GET
	@RequestMapping(value="promissory_note", method = RequestMethod.GET)
	public String promissoryInsertGET(Model model) throws Exception {
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/promissory2/promissory_note.jsp");
		return "/main";
	}

	//어음등록 POST
	@RequestMapping(value="promissory_note", method = RequestMethod.POST)
	public String promissoryInsertPOST(Model model, Promissory promissory) throws Exception {
		System.out.println(promissory.getEx_date());
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/promissory2/promissory_note.jsp");
		service.promissoryInsert(promissory);
		return "/main";
	}
	
	//어음결재GET
	@RequestMapping(value="promissory_notePayment", method = RequestMethod.GET)
	public String promissory_notePaymentGET(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("contents", "accounting/promissory2/promissory_notePayment.jsp");
		return "/main";
	}
	
	//어음결재POST
		@RequestMapping(value="promissory_notePayment", method = RequestMethod.POST)
		public String promissory_notePaymentPOST(Promissory promissory, Model model)throws Exception{
			model.addAttribute("left", "accounting/accounting.jsp");
			model.addAttribute("contents", "accounting/promissory2/promissory_notePayment.jsp");
			service.promissoryUpdate(promissory);
			return "/main";
		}
	
	
	//할인/만기GET
		@RequestMapping(value="promissory_noteBill", method = RequestMethod.GET)
		public String promissory_noteBillGET(Model model)throws Exception{
			model.addAttribute("left", "accounting/accounting.jsp");
			model.addAttribute("contents", "accounting/promissory2/promissory_noteBill.jsp");
			return "/main";
		}
		
		//할인/만기POST
		@RequestMapping(value="promissory_noteBill", method = RequestMethod.POST)
		public String promissory_noteBillPOST(Promissory promissory,Model model)throws Exception{
			model.addAttribute("left", "accounting/accounting.jsp");
			model.addAttribute("contents", "accounting/promissory2/promissory_noteBill.jsp");
			service.promissorygiveUpdate(promissory);
			return "/main";
				}
	
		
	//어음지급GET
		@RequestMapping(value="promissory_give", method = RequestMethod.GET)
		public String promissory_noteGiveGET(Model model)throws Exception{
			model.addAttribute("left", "accounting/accounting.jsp");
			model.addAttribute("contents", "accounting/promissory2/promissory_notegive.jsp");
			return "/main";
		}
	//어음지급POST
		@RequestMapping(value="promissory_give", method=RequestMethod.POST)
		public String promissory_noteGivePOST(Promissory promissory, Model model)throws Exception{
			model.addAttribute("left", "accounting/accounting.jsp");
			model.addAttribute("contents", "accounting/promissory2/promissory_notegive.jsp");
			service.promissoryUpdate(promissory);
			return "/main";
		}
		
		
	
}
