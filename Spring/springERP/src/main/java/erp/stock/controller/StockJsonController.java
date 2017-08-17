package erp.stock.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import erp.stock.domain.StockCalendar;
import erp.stock.domain.StockRP;
import erp.stock.service.StockRPService;

@RestController
@RequestMapping("/stock/rp/*")
public class StockJsonController {

	@Inject
	private StockRPService service;

	@RequestMapping("/calendar")
	public List<StockCalendar> stockCalendar() throws Exception{
		
		return service.stockCalendarJson();
	}
	
	@RequestMapping("/insert")
	public int stockRPInsert(StockRP stock) throws Exception{
		int re = 0;
		
		re = service.stockRPInsert(stock);
		
		return re;
	}
	
	@RequestMapping("/update")
	public int stockRPupdate(StockRP stock, Model model) throws Exception{
		int re =0;
		
		re = service.stockRPUpdate(stock);
		
		return re;
	}
}
