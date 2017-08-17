package erp.basic.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import erp.basic.domain.Product;
import erp.basic.service.BasicProductService;

@Controller
@RequestMapping("/basic/product/*")
public class BasicProductController {
	
	@Inject
	private BasicProductService service;
	
	/*품목 목록 - MJ*/
	@RequestMapping("/list")
	public String productList(Model model, @RequestParam(value="pageNum", defaultValue="1") int page) throws Exception{
		
		model.addAttribute("plist", service.pgroupList());
		model.addAttribute("slist", service.standardList());
		model.addAttribute("listModel",service.productList(page));
		model.addAttribute("left","basic/basic.jsp");
		model.addAttribute("contents","basic/basic_productList.jsp");
		
		return "/main";
	}
	
	/*품목 등록 - MJ*/
	@RequestMapping("/insert")
	public String productInsert(Product product) throws Exception {
		
		service.productInsert(product);

		return "redirect:/basic/product/list";
	}
	
	/*품목 수정 - MJ*/
	@RequestMapping("/update")
	public String productUpdate(Product product) throws Exception {
		
		service.productUpdate(product);
		
		return "redirect:/basic/product/list";
	}
	
	/*품목 삭제 - MJ*/
	@RequestMapping("/delete")
	public String productDelete(@RequestParam("checks") String product_id) throws Exception {
		
		service.productDelete(product_id);
		
		return "redirect:/basic/product/list";
	}
	/*바코드 이미지화 -MJ*/
	@RequestMapping("/barcode")
	public String producBarcode(@RequestParam("product_id") String product_id, HttpServletResponse res)throws Exception{
		
		service.productBarcode(res, product_id);		
		return "redirect:/list";
	}

}
