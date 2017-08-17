package erp.pch.controller;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import erp.basic.domain.Product;
import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.pch.domain.GetCustomer;
import erp.pch.domain.GetWareHouse;
import erp.pch.domain.JsonDataChart;
import erp.pch.domain.PurchaseListView;
import erp.pch.domain.PurchaseSearch;
import erp.pch.domain.PurchaseVO;
import erp.pch.domain.TotalDataChart;
import erp.pch.service.PurchaseService;

@Controller
@RequestMapping("/purchase/*")
public class PurchaseController {
	
	@Inject
	private PurchaseService service;
	
	@RequestMapping(value="purchase_add", method = RequestMethod.GET)
	public String purchase_addGET(Model model)throws Exception{
		model.addAttribute("left", "purchase/purchase.jsp");
		model.addAttribute("contents", "purchase/purchase_add.jsp");
		return "/main";
	}
	@RequestMapping(value="purchase_add", method = RequestMethod.POST)
	public String purchase_addPOST(PurchaseVO vo)throws Exception{
		service.insertPch(vo);
		return "redirect:purchase_check";
	}
	@RequestMapping(value="/purchase_check", method=RequestMethod.GET)
	public String purchaseCheckPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("left", "purchase/purchase.jsp");
		model.addAttribute("contents", "purchase/purchase_check.jsp");
		return "/main";
	}
	@RequestMapping("purchase_delete")
	public String purchase_delete(@RequestParam("array") String[] array) throws Exception{
		for(int i=0;i<array.length;i++){
			service.delete(array[i]);
		}
		return "redirect:purchase_check";
	}
	@RequestMapping("customer_id_search")
	@ResponseBody
	public List<GetCustomer> customerIdSearch(@RequestParam("customer_id") String customer_id)throws Exception{
		return service.customerList(customer_id);
	}
	@RequestMapping("product_id_search")
	@ResponseBody
	public List<Product> productIdSearch(@RequestParam("product_id") String product_id)throws Exception{
		return service.productList(product_id);
	}
	@RequestMapping("warehouse_id_search")
	@ResponseBody
	public List<GetWareHouse> warehouseIdSearch(@RequestParam("warehouse_id") String warehouse_id)throws Exception{
		return service.warehouseList(warehouse_id);
	}
	
	
	@RequestMapping(value="purchase_accounts", method=RequestMethod.GET)
	public String account(Model model)throws Exception{
		model.addAttribute("left", "purchase/purchase.jsp");
		model.addAttribute("contents", "purchase/purchase_accounts.jsp");
		return "/main";
	}
	
	@RequestMapping(value="purchase_search", method = RequestMethod.POST)
	public String purchase_searchPOST(PurchaseSearch ps ,Model model)throws Exception{
		List<PurchaseListView> list = service.purchaseSearch(ps);
		model.addAttribute("left", "purchase/purchase.jsp");
		model.addAttribute("contents", "purchase/purchase_searchList.jsp");
		model.addAttribute("list", list);
		return "/main";
	}
	@RequestMapping(value="purchase_search", method = RequestMethod.GET)
	public String purchase_searchGET(PurchaseSearch ps, Model model)throws Exception{
		model.addAttribute("left", "purchase/purchase.jsp");
		model.addAttribute("contents", "purchase/purchase_search.jsp");
		return "/main";
	}
	@RequestMapping("purchase_update")
	public String puchaseUpdate(PurchaseVO vo)throws Exception{
		service.updatePurchase(vo);
		return "redirect:purchase_check";
	}
	@RequestMapping("purchase_excel")
	public String purchase_Excel(OutputStream out ,HttpServletResponse res,Model model)throws Exception{
		service.downloadExcel(out, res);
		return "/purchase/purchase_check";
	}
	@RequestMapping("excelUp")
	public String purchase_ExcelUp(MultipartHttpServletRequest request, Model model)throws Exception{
		
		
							Map<String, MultipartFile> files = request.getFileMap();
							CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("excelFile");
							String path ="c:/upload/"+cmf.getOriginalFilename();
							File file = new File(path);
							cmf.transferTo(file);
							
							
		service.uploadExcel(path);
		return "redirect:purchase_check";
	}
	
	@RequestMapping("chartData")
	@ResponseBody
	public List<JsonDataChart> chartData()throws Exception{
		return service.getChartData();
	}
	@RequestMapping("total_chart")
	public String totalChart(Model model)throws Exception{
		model.addAttribute("left", "purchase/purchase.jsp");
		model.addAttribute("contents", "purchase/main_total.jsp");
		return "/main";
	}
	@RequestMapping("totalDataChart")
	@ResponseBody
	public List<TotalDataChart> totalData()throws Exception{
		return service.getTotalSales();
	}
}
