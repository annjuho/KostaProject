package erp.pch.persistence;


import java.util.List;
import java.util.Map;

import erp.basic.domain.Product;
import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.pch.domain.GetCustomer;
import erp.pch.domain.GetWareHouse;
import erp.pch.domain.PurchaseListView;
import erp.pch.domain.PurchaseSearch;
import erp.pch.domain.PurchaseSearchTimeSet;
import erp.pch.domain.PurchaseVO;
import erp.pch.domain.Slip;
import erp.sale.domain.SaleListView;

public interface PurchaseDAO {
	public void addPch(PurchaseVO vo)throws Exception;
	public List<PurchaseListView> readPch()throws Exception;
	public void removePch(String buy_id)throws Exception;
	public List<GetCustomer> customerList(String customer_id)throws Exception;
	public List<Product> productList(String product_id)throws Exception;
	public List<GetWareHouse> warehouseList(String warehouse_id)throws Exception;
	public List<PurchaseListView> purchaseSearch(PurchaseSearchTimeSet ps)throws Exception;
	public void updatePurchase(PurchaseVO vo)throws Exception;
	public List<PurchaseListView> listAll() throws Exception;
	public List<PurchaseListView> listCriteria(Criteria cri) throws Exception;
	public int countPaging(Criteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri)throws Exception;
	public List<PurchaseListView> listSearch(SearchCriteria cri)throws Exception;
	public String getCustomerId(String customer_name)throws Exception;
	public String getProductId(String product_name)throws Exception;
	public String getWarehouseId(String warehouse_name)throws Exception;
	public void insertExcel(PurchaseVO vo)throws Exception;
	public List<PurchaseListView> getTotalPrice()throws Exception;
	public List<PurchaseListView> getCustomerGroup()throws Exception;
	public List<Slip> getTotalSales()throws Exception;
	public List<Slip> getMonth(String value)throws Exception;
}
