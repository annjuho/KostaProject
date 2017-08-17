package erp.sale.service;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import erp.common.domain.Criteria;
import erp.sale.domain.SaleCustomerChart;
import erp.sale.domain.SaleGoodsDataXml;
import erp.sale.domain.SaleListView;
import erp.sale.domain.SaleProductChart;
import erp.sale.domain.SaleSearch;
import erp.sale.domain.SaleVO;

public interface SaleService {
	public void insertSale(SaleVO vo)throws Exception;
	public List<SaleListView> listSale()throws Exception;
	public void deleteSale(String sell_id)throws Exception;
	public void updateSale(SaleVO vo)throws Exception;
	public List<SaleListView> saleSearchList(SaleSearch ss)throws Exception;
	public List<SaleListView> listAll()throws Exception;
	public List<SaleListView> listCriteria(Criteria cri)throws Exception;
	public int listCountCriteria(Criteria cri)throws Exception;
	public void downloadExcel(OutputStream out ,HttpServletResponse res)throws Exception;
	public void uploadExcel(String path)throws Exception;
	public List<SaleProductChart> saleProductChart(String customer_id) throws Exception;
	public List<SaleCustomerChart> saleCustomerChart() throws Exception;
	public SaleGoodsDataXml selectSaleXml(String sell_id) throws Exception;
}
