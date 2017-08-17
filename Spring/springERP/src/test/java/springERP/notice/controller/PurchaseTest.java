package springERP.notice.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erp.pch.domain.PurchaseListView;
import erp.pch.domain.PurchaseVO;
import erp.pch.persistence.PurchaseDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PurchaseTest {
	
	@Inject
	private PurchaseDAO dao;
	
	/*@Test
	public void insertTest() throws Exception {
		PurchaseVO vo = new PurchaseVO();
		vo.setBuy_amount(1);
		vo.setBuy_id("aa");
		vo.setBuy_price(1);
		vo.setCustomer_id("customer_id_01");
		vo.setEmp_id("2");
		vo.setPay_type("aa");
		vo.setProduct_id("product_id_1");
		vo.setWarehouse_id("warehouse_id_01");
		dao.addPch(vo);
	}*/
	/*@Test
	public void detailTest()throws Exception{
		List<PurchaseListView> list = dao.readPch();
		System.out.println(list);
	}*/
	/*@Test
	public void deleteTest()throws Exception{
		dao.removePch("aa");
	}*/
	@Test
	public void updateTest()throws Exception{
	}
}
