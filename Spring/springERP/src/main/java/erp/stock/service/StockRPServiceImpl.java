 package erp.stock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.basic.domain.Product;
import erp.common.service.CommonService;
import erp.stock.domain.MainStockList;
import erp.stock.domain.StockCalendar;
import erp.stock.domain.StockList;
import erp.stock.domain.StockRP;
import erp.stock.domain.StockRPSearch;
import erp.stock.persistence.StockRPDAO;

@Service
public class StockRPServiceImpl implements StockRPService {

	@Inject
	private StockRPDAO dao;
	
	@Transactional
	@Override
	public int stockRPInsert(StockRP stock) throws Exception {
		int max = dao.inoutMax();
		int re = 0;
		stock.setEmp_id(CommonService.getEmployeeId());
		stock.setInout_id("rp_"+(max+1));

		try {
			re = dao.stockRPInsert(stock);
			dao.stockUpdate(stock);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return re;	
		
	}

	@Override
	public List<Product> productList() throws Exception {
		return dao.productList();
	}

	@Override
	public List<StockCalendar> stockCalendarJson() throws Exception {
		return dao.stockCalendarJson();
	}

	@Override
	public int stockRPUpdate(StockRP stock) throws Exception {
		return dao.stockRPUpdate(stock);
	}

	@Override
	public List<StockRPSearch> stockRPSearchList(StockRPSearch search) throws Exception {
		List<StockRPSearch> list = null;
		//list.add(search);
		list = dao.stockRPSearchList(search);
		return list;
	}

	@Override
	public List<StockList> stockList() throws Exception {
		return dao.stockList();
	}

	@Override
	public List<MainStockList> mainStock() throws Exception {
		return dao.mainStock();
	}

	
}
