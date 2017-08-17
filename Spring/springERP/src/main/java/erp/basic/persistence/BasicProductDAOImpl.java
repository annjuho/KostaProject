package erp.basic.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.basic.domain.Product;
import erp.basic.domain.ProductGroup;
import erp.basic.domain.ProductList;
import erp.basic.domain.Standards;
import erp.basic.domain.Stock;
import erp.pch.domain.GetCustomer;

@Repository
public class BasicProductDAOImpl implements BasicProductDAO{
	 
	@Inject
	private SqlSession session;

	private static String namespace = "erp.basic.mapper.basicProductMapper";

	@Override
	public List<ProductGroup> pgroupList() throws Exception {
		return session.selectList(namespace + ".pgroupList");
	}

	@Override
	public List<Standards> standardList() throws Exception {
		return session.selectList(namespace+".standardList");
	}

	@Override
	public int totalCountProduct() throws Exception {
		return session.selectOne(namespace+".totalCountProduct");
	}

	@Override
	public List<ProductList> productList(int startRow) throws Exception{

		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", startRow+4);
		page.put("end", startRow+5);

		return session.selectList(namespace+".productList", page);
	}

	@Override
	public void productInsert(Product product) throws Exception {
		session.insert(namespace+".productInsert", product);
	}

	@Override
	public void productUpdate(Product product) throws Exception {
		session.update(namespace+".productUpdate", product);
	}

	@Override
	public void productDelete(String product_id) throws Exception {
		session.delete(namespace+".productDelete", product_id);
	}

	@Override
	public List<Product> productCodeJson(String word) throws Exception {
		return session.selectList(namespace+".productCodeJson",word);
	}

	@Override
	public void stockInsert(Stock stock) throws Exception {
		session.insert(namespace+".stockInsert",stock);
	}

	@Override
	public Product getProduct(String product_id) throws Exception {
		return session.selectOne(namespace+".getProduct", product_id);
	}
}
