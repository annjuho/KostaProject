package erp.sale.companybuy.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.sale.companybuy.domain.CompanyBuy;
import erp.sale.companybuy.domain.CompanyBuyList;
import erp.sale.companybuy.service.CompanyBuyService;

@Controller
@RequestMapping("/sale/companyBuy/*")
public class CompanyBuyController {
	
	@Inject
	private CompanyBuyService service;
	
	/*@RequestMapping(value="companyBuy_check", method=RequestMethod.GET)
	public String companyBuyCheckGET(Model model)throws Exception{
		List<CompanyBuyList> list = service.listCBuy();
		model.addAttribute("left", "sale/sale.jsp");
		model.addAttribute("contents", "sale/companyBuy/companyBuy_check.jsp");
		model.addAttribute("list", list);
		return "/main";
	}*/
	@RequestMapping(value="/companyBuy_check", method=RequestMethod.GET)
	public String companyBuyCheckPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("left", "sale/sale.jsp");
		model.addAttribute("contents", "sale/companyBuy/companyBuy_check.jsp");
		return "/main";
	}
	@RequestMapping(value="companyBuy_add", method=RequestMethod.GET)
	public String companyBuyAddGET(Model model)throws Exception{
		model.addAttribute("left", "sale/sale.jsp");
		model.addAttribute("contents", "sale/companyBuy/companyBuy_add.jsp");
		return "/main";
	}
	@RequestMapping(value="companyBuy_add", method=RequestMethod.POST)
	public String companyBuyAddPOST(CompanyBuy cb,Model model)throws Exception{
		service.insertCBuy(cb);
		return "redirect:companyBuy_check";
	}
	@RequestMapping("cbuy_delete")
	public String cbuyDelete(@RequestParam("array") String[] array)throws Exception{
		for(int i=0;i<array.length;i++){
			service.deleteCBuy(array[i]);
		}
		return "redirect:companyBuy_check";
	}
	@RequestMapping("cbuy_update")
	public String cbuyUpdate(CompanyBuy cb)throws Exception{
		service.updateCBuy(cb);
		return "redirect:companyBuy_check";
	}
}
