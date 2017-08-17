package erp.sale.persistence;

import java.util.List;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.sale.domain.SaleCustomerChart;
import erp.sale.domain.SaleGoodsDataXml;
import erp.sale.domain.SaleListView;
import erp.sale.domain.SaleProductChart;
import erp.sale.domain.SaleSearch;
import erp.sale.domain.SaleSearchTimeSet;
import erp.sale.domain.SaleVO;

public interface SaleDAO {
	public void addSale(SaleVO vo) throws Exception;
	public List<SaleListView> listSale() throws Exception;
	public void removeSale(String sell_id) throws Exception;
	public void updateSale(SaleVO vo) throws Exception;
	public List<SaleListView> searchSale(SaleSearchTimeSet sst) throws Exception;
	public List<SaleListView> listAll() throws Exception;
	public List<SaleListView> listCriteria(Criteria cri) throws Exception;
	public int countPaging(Criteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri)throws Exception;
	public List<SaleListView> listSearch(SearchCriteria cri)throws Exception;
	public void insertSaleExcel(SaleVO vo)throws Exception;
	public List<SaleProductChart> saleProductChart(String customer_id) throws Exception;
	public List<SaleCustomerChart> saleCustomerChart() throws Exception;
	public SaleGoodsDataXml selectSaleXml(String sell_id) throws Exception;
	public void addXmlDataSell(SaleVO vo) throws Exception;
}
