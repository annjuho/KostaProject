package erp.pch.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erp.basic.test.basic_productTEST;
import erp.sale.companybuy.domain.CompanyBuy;
import erp.sale.companybuy.domain.CompanyBuyList;
import erp.sale.companybuy.service.CompanyBuyService;
import erp.sale.domain.SaleListView;
import erp.sale.domain.SaleSearch;
import erp.sale.domain.SaleVO;
import erp.sale.persistence.SaleDAO;
import erp.sale.service.SaleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class SaleTest {

	@Inject
	private SaleService service;
	@Inject
	private CompanyBuyService cbService;
	private static final Logger logger = LoggerFactory.getLogger(basic_productTEST.class);

	/*
	 * @Test public void cBuyUpdateTest()throws Exception{ CompanyBuy cb = new
	 * CompanyBuy();
	 * 
	 * cb.setCbuy_amount(9999); cb.setCbuy_priceout(9999);
	 * cb.setPay_type("9999"); cb.setCbuy_id("1"); cbService.updateCBuy(cb); }
	 */

	/*
	 * @Test public void cBuyDeleteTest()throws Exception{
	 * cbService.deleteCBuy("a12a34"); }
	 */

	/*
	 * @Test public void cBuyListTest()throws Exception{ List<CompanyBuyList>
	 * list = cbService.listCBuy(); System.out.println(list); }
	 */

	/*
	 * @Test public void cBuyInsertTest()throws Exception{ CompanyBuy cb = new
	 * CompanyBuy(); cb.setCbuy_amount(500); cb.setCbuy_id("a12a34");
	 * cb.setCbuy_priceout(1020); cb.setCustomer_id("customer_id_02");
	 * cb.setPay_type("1a2aa"); cb.setProduct_id("product_id_1");
	 * cb.setWarehouse_id("warehouse_id_05"); cbService.insertCBuy(cb); }
	 */

	/*
	 * @Test public void saleSearchList()throws Exception{ SaleSearch ss = new
	 * SaleSearch(); ss.setStart_date("2016-05-05");
	 * ss.setEnd_date("2016-06-06"); List<SaleListView> list =
	 * service.saleSearchList(ss); System.out.println(list); }
	 */

	/*@Test
	public void insertSaleTest() throws Exception {
		SaleVO sale = new SaleVO();
		sale.setCustomer_id("customer_id_01");
		sale.setPay_type("현금");
		sale.setProduct_id("product_id_1");
		sale.setSell_amount(5);
		sale.setSell_id("sell_id_25");
		sale.setSell_price(5000);
		sale.setWarehouse_id("warehouse_id_02");

		service.insertSale(sale);
	}*/

	@Test
	public void listSaleTest() throws Exception {
		List<SaleListView> list = service.listSale();
		for (SaleListView lists : list) {
			logger.info(lists.getSell_id());
			logger.info(lists.getProduct_name());
			logger.info(Integer.toString((lists.getSell_amount())));
		}
	}

	/*@Test8
	public void deleteSaleTest() throws Exception {
		service.deleteSale("sell_id_10");
	}*/

	/*@Test
	public void updateSaleTest() throws Exception {
		SaleVO sale = new SaleVO();
		sale.setPay_type("어음");
		sale.setSell_amount(10);
		sale.setSell_id("sell_id_15");
		sale.setSell_price(4000);
		service.updateSale(sale);
	}
*/
}
