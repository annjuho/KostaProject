package erp.basic.persistence;
import java.util.List;

import erp.basic.domain.Product;
import erp.basic.domain.ProductGroup;
import erp.basic.domain.ProductList;
import erp.basic.domain.Standards;
import erp.basic.domain.Stock;
import erp.pch.domain.GetCustomer;

public interface BasicProductDAO {

	public List<ProductGroup> pgroupList() throws Exception;

	public List<Standards> standardList() throws Exception;

	public int totalCountProduct() throws Exception;

	public List<ProductList> productList(int startRow) throws Exception;

	public void productInsert(Product product) throws Exception;

	public void productUpdate(Product product) throws Exception;

	public void productDelete(String product_id) throws Exception;

	public List<Product> productCodeJson(String word) throws Exception;

	public void stockInsert(Stock stock) throws Exception;
	
	public Product getProduct(String product_id)throws Exception;
}
