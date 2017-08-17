package erp.basic.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erp.basic.domain.Customer;
import erp.basic.service.BasicCustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class basic_customerTEST {
	
	@Inject
	private BasicCustomerService service;
	
	/*@Test
	public void customerInsertTest()throws Exception {
		Customer c = new Customer();
		c.setBankbook_check("a");
		c.setCheckman("a");
		c.setCopy_bankbook("c");
		c.setCustomer_address("c");
		c.setCustomer_email("c");
		c.setCustomer_fax("c");
		c.setCustomer_id("customer_id_12");
		c.setCustomer_name("c");
		c.setPhone_number("c");
		c.setRepre_name("c");
		service.customerInsert(c);
	}*/
	/*@Test
	public void customerUpdateTest()throws Exception{
		Customer c = new Customer();
		c.setBankbook_check("k");
		c.setCheckman("k");
		c.setCopy_bankbook("k");
		c.setCustomer_address("k");
		c.setCustomer_email("k");
		c.setCustomer_fax("k");
		c.setCustomer_id("customer_id_12");
		c.setCustomer_name("k");
		c.setPhone_number("k");
		c.setRepre_name("k");
		service.customerUpdate(c);
	}*/
	/*@Test
	public void customerDeleteTest()throws Exception{
		service.customerDelete("customer_id_12");
	}*/
	@Test
	public void customerList()throws Exception{
		List<Customer> list = service.customerList();
		System.out.println(list);
	}
}
