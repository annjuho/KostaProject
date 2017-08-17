package erp.pch.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.basic.domain.Product;
import erp.common.domain.Criteria;
import erp.pch.domain.GetCustomer;
import erp.pch.domain.GetWareHouse;
import erp.pch.domain.JsonDataChart;
import erp.pch.domain.PurchaseListView;
import erp.pch.domain.PurchaseSearch;
import erp.pch.domain.PurchaseVO;
import erp.pch.domain.TotalDataChart;
import erp.sale.domain.SaleListView;

public interface PurchaseService {
	public void insertPch(PurchaseVO vo)throws Exception;
	public List<PurchaseListView> detailPch()throws Exception;
	public void delete(String buy_id)throws Exception;
	public List<GetCustomer> customerList(String customer_id)throws Exception;
	public List<Product> productList(String product_id)throws Exception;
	public List<GetWareHouse> warehouseList(String warehouse_id)throws Exception;
	public List<PurchaseListView> purchaseSearch(PurchaseSearch ps)throws Exception;
	public List<PurchaseListView> listAll()throws Exception;
	public List<PurchaseListView> listCriteria(Criteria cri)throws Exception;
	public int listCountCriteria(Criteria cri)throws Exception;
	public void updatePurchase(PurchaseVO vo)throws Exception;
	public void downloadExcel(OutputStream out,HttpServletResponse res)throws Exception;
	public void uploadExcel(String path)throws Exception;
	public List<JsonDataChart> getChartData()throws Exception;
	public List<TotalDataChart> getTotalSales()throws Exception;
}
