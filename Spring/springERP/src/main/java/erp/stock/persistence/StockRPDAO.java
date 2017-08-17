package erp.stock.persistence;

import java.util.List;

import erp.basic.domain.Product;
import erp.stock.domain.MainStockList;
import erp.stock.domain.StockCalendar;
import erp.stock.domain.StockList;
import erp.stock.domain.StockRP;
import erp.stock.domain.StockRPSearch;

public interface StockRPDAO {
	public int stockRPInsert(StockRP stock) throws Exception;
	public List<Product> productList() throws Exception;
	public int inoutMax() throws Exception;
	public void stockUpdate(StockRP stock) throws Exception;
	public List<StockCalendar> stockCalendarJson() throws Exception;
	public int stockRPUpdate(StockRP stock) throws Exception;
	public List<StockRPSearch> stockRPSearchList(StockRPSearch search) throws Exception;
	public List<StockList> stockList() throws Exception;
	public List<MainStockList> mainStock() throws Exception;
}
