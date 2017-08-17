package erp.pch.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erp.pch.domain.PurchaseListView;
import erp.pch.domain.PurchaseSearch;
import erp.pch.domain.PurchaseVO;
import erp.pch.domain.Slip;
import erp.pch.domain.TotalDataChart;
import erp.pch.persistence.PurchaseDAO;
import erp.pch.service.PurchaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PurchaseTest {
	
	@Inject
	private PurchaseService service;
	@Inject
	private PurchaseDAO dao;
	
	@Test
	public void getMonth()throws Exception{
		List<TotalDataChart> list = new ArrayList<TotalDataChart>();
		List<Slip> slipList = null;
		long[] temps = new long[12];
		for(int i=1;i<13;i++){
			long val = 0;
			if(i<10){
				slipList = dao.getMonth("16/0"+i+"%");
			}else{
				slipList = dao.getMonth("16/"+i+"%");
			}
			for(int j=0;j<slipList.size();j++){
				//temps[i-1] = 1;
				val += slipList.get(j).getSlip_amount();
			}
			temps[i-1] = val;
		}
		for(int i=0;i<temps.length;i++){
			System.out.println(i+1+ ":" +temps[i]);
		}
	}
	/*@Test
	public void getTotalPriceTest()throws Exception{
		List<PurchaseListView> list = dao.getTotalPrice();
		List<PurchaseListView> customerList = dao.getCustomerGroup();
		
		for(int i=0;i<customerList.size();i++){
			int tmp = 0;
			boolean check = false;
			for(int j=0;j<list.size();j++){				
				if(customerList.get(i).getCustomer_name().equals(list.get(j).getCustomer_name())){
					tmp += list.get(j).getBuy_price() * list.get(j).getBuy_amount();
					System.out.println(customerList.get(i).getCustomer_name()+":"+list.get(j).getCustomer_name()+":"+tmp);
					check = true;
				}
			}
			if(check){
				customerList.get(i).setBuy_price(tmp);
			}
		}
	}*/
	
	/*@Test
	public void getCustomerId()throws Exception{
		String str = dao.getCustomerId("옥션");
		System.out.println(str);
	}*/
	
	/*@Test
	public void purchaseSearch()throws Exception{
		PurchaseSearch ps = new PurchaseSearch();
		ps.setStart_date("2016-05-05");
		ps.setEnd_date("2016-06-05");
		//ps.setCustomer_id("customer_id_02");
		//ps.setProduct_id("product_id_3");
	//	ps.setWarehouse_id("warehouse_id_05");
		List<PurchaseListView> list = service.purchaseSearch(ps);
		System.out.println(list);
	}*/
	/*@Test
	public void insertTest() throws Exception {
		PurchaseVO vo = new PurchaseVO();
		vo.setBuy_amount(1);
		vo.setBuy_id("1c2c3c");
		vo.setBuy_price(1);
		vo.setCustomer_id("customer_id_01");
		vo.setEmp_id("2");
		vo.setPay_type("aa");
		vo.setProduct_id("product_id_3");
		vo.setWarehouse_id("warehouse_id_01");
		service.insertPch(vo);
	}
	/*@Test
	public void detailTest()throws Exception{
		List<PurchaseListView> list = dao.readPch();
		System.out.println(list);
	}*/
	/*@Test
	public void deleteTest()throws Exception{
		dao.removePch("aa");
	}*/
}
