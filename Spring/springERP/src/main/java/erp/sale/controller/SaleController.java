package erp.sale.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.xmlbeans.XmlDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import erp.basic.service.BasicCustomerService;
import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.pch.persistence.PurchaseDAO;
import erp.sale.domain.Goods_data;
import erp.sale.domain.SaleCustomerChart;
import erp.sale.domain.SaleGoodsDataXml;
import erp.sale.domain.SaleListView;
import erp.sale.domain.SaleProductChart;
import erp.sale.domain.SaleSearch;
import erp.sale.domain.SaleVO;
import erp.sale.domain.XMLData;
import erp.sale.service.SaleService;

@Controller
@RequestMapping("/sale/*")
public class SaleController {
	
	@Inject
	private SaleService service;
	@Inject
	private BasicCustomerService basicService;
	@Inject
	private PurchaseDAO pdao;
	
	@RequestMapping(value="sale_add", method=RequestMethod.GET)
	public String saleAddGET(Model model)throws Exception{
		model.addAttribute("left", "sale/sale.jsp");
		model.addAttribute("contents", "sale/sale_add.jsp");
		return "/main";
	}
	@RequestMapping(value="sale_add", method=RequestMethod.POST)
	public String saleAddPOST(SaleVO vo, RedirectAttributes rtts)throws Exception{
		service.insertSale(vo);
		rtts.addAttribute("sell_id", vo.getSell_id());
		return "redirect:sale_check";
	}
	@RequestMapping("sale_delete")
	public String saleDelete(@RequestParam("array") String[] array) throws Exception{
		for(int i=0;i<array.length;i++){
			service.deleteSale(array[i]);
		}
		return "redirect:sale_check";
	}
	@RequestMapping("sale_update")
	public String saleUpdate(SaleVO vo)throws Exception{
		service.updateSale(vo);
		return "redirect:sale_check";
	}
	@RequestMapping(value="sale_search", method=RequestMethod.GET)
	public String saleSearchGET(Model model)throws Exception{
		model.addAttribute("left", "sale/sale.jsp");
		model.addAttribute("contents", "sale/sale_search.jsp");
		return "/main";
	}
	@RequestMapping(value="sale_search", method=RequestMethod.POST)
	public String saleSearchPOST(SaleSearch ss, Model model)throws Exception{
		List<SaleListView> list = service.saleSearchList(ss);
		model.addAttribute("left", "sale/sale.jsp");
		model.addAttribute("contents", "sale/sale_searchList.jsp");
		model.addAttribute("list", list);
		return "/main";
	}
	@RequestMapping(value="/sale_check", method=RequestMethod.GET)
	public String saleCheckPage(@ModelAttribute("cri") SearchCriteria cri, Model model, @RequestParam(value="sell_id", defaultValue="null") String sell_id) throws Exception{		
		if(!sell_id.equals("null")){
			model.addAttribute("sell_id", sell_id);
			System.out.println("sell_id    "+sell_id);
		}
		if(sell_id.equals("null")){
			System.out.println("sell_id null!!!!!!!!!!");
		}
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("left", "sale/sale.jsp");
		model.addAttribute("contents", "sale/sale_check.jsp");
		return "/main";
	}
	@RequestMapping("sale_excel")
	public String purchase_Excel(OutputStream out ,HttpServletResponse res,Model model)throws Exception{
		service.downloadExcel(out, res);
		return "/sale/sale_check";
	}
	@RequestMapping("excelUp")
	public String purchase_ExcelUp(MultipartHttpServletRequest request, Model model)throws Exception{
		
		Map<String, MultipartFile> files = request.getFileMap();
		CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("excelFile");
		
		String path ="c:/upload/"+cmf.getOriginalFilename();
		File file = new File(path);
		cmf.transferTo(file);
		service.uploadExcel(path);
		return "redirect:sale_check";
	}
	@RequestMapping("sale_accounts")
	public String saleAccounts(Model model) throws Exception{
		
		model.addAttribute("list", basicService.customerList());
		model.addAttribute("left", "sale/sale.jsp");
		model.addAttribute("contents", "sale/sale_accounts.jsp");
		return "/main";
	}
	
	@RequestMapping("customer_chart")
	@ResponseBody
	public List<SaleCustomerChart> saleCustomerChart() throws Exception{
		return service.saleCustomerChart();
	}
	@RequestMapping("product_chart")
	@ResponseBody
	public List<SaleProductChart> saleProductChart(@RequestParam("customer_name") String customer_name) throws Exception{
		String customer_id = pdao.getCustomerId(customer_name);
		return service.saleProductChart(customer_id);
	}
	
	@RequestMapping("/xmltest")
	@ResponseBody
	public XMLData xmltest(@RequestParam("sell_id") String sell_id) throws Exception{
		int re = 0;
		String totStock = "";
		SaleGoodsDataXml goods = service.selectSaleXml(sell_id);
		
		Goods_data data = new Goods_data();
		
		data.setGoods_category(goods.getPgroup_name());
		data.setGoods_price(goods.getPrice_out());
		data.setUsestock("o");
		data.setGoodsnm(goods.getProduct_name());
		data.setGoodscd(goods.getProduct_id());
		totStock = Integer.toString(goods.getSell_amount());
		data.setTotstock(totStock);
		
		XMLData xml = new XMLData(data);
		
		return xml;
	}
}
