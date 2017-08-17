package erp.basic.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erp.basic.domain.Product;
import erp.basic.persistence.BasicProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class basic_productTEST {


	private static final Logger logger = LoggerFactory.getLogger(basic_productTEST.class);
	
	@Inject
	private BasicProductDAO dao;
	
//	/*품목 그룹 테스트 - MJ*/
//	@Test
//	public void pgroupListTEST() throws Exception {
//		dao.pgroupList();
//	}
//	/*규격 목록 테스트 - MJ*/
//	@Test
//	public void standardListTEST() throws Exception {
//		dao.standardList();
//	}
//	/*품목 목록 총 갯수 테스트 - MJ*/
//	@Test
//	public void totalCountProductTEST() throws Exception{
//		dao.totalCountProduct();
//	}
//	/*품목 목록 테스트 - MJ*/
//	@Test
//	public void productListTEST() throws Exception {
//		dao.productList(0);
//	}
//	/*품목 등록 테스트 - MJ*/
//	@Test
//	public void productInsertTEST() throws Exception {
//		dao.productInsert(new Product("민정", "123456", "pg1", 20000, 20000, "바코드바코드", "sd1", "캐나다"));
//	}
//	/*품목 수정 테스트 - MJ*/
//	@Test
//	public void productUpdateTEST() throws Exception{
//		dao.productUpdate(new Product("민정", "2222222", "pg1", 20000, 20000, "바코드코코코코", "sd1", "웨얼아유프롬"));
//	}
//	/*품목 삭제 테스트 - MJ*/
//	@Test
//	public void prodcutDeleteTEST() throws Exception{
//		dao.productDelete("민정");
//	}

}
