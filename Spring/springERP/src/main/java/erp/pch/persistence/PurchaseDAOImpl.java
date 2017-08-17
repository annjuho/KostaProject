package erp.pch.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

@Repository
public class PurchaseDAOImpl implements PurchaseDAO{

	private static String namespace = "springERP.purchase.mapper.purchaseMapper";
	@Inject
	private SqlSession session;
	@Override
	public void addPch(PurchaseVO vo) throws Exception {
		session.insert(namespace+".insertPurchase", vo);
		session.update(namespace+".stockUpdate", vo);
	}
	@Override
	public List<PurchaseListView> readPch() throws Exception {
		return session.selectList(namespace+".purchaseList");
	}
	@Override
	public void removePch(String buy_id) throws Exception {
		session.delete(namespace+".deletePurchase", buy_id);
	}
	@Override
	public List<GetCustomer> customerList(String customer_id) throws Exception {
		return session.selectList(namespace+".customerList", "%"+customer_id+"%");
	}
	@Override
	public List<PurchaseListView> purchaseSearch(PurchaseSearchTimeSet ps) throws Exception {
		return session.selectList(namespace+".searchPurchaseList", ps);
	}
	@Override
	public List<Product> productList(String product_id) throws Exception {
		return session.selectList(namespace+".productList", "%"+product_id+"%");
	}
	@Override
	public List<GetWareHouse> warehouseList(String warehouse_id) throws Exception {
		return session.selectList(namespace+".warehouseList", "%"+warehouse_id+"%");
	}
	@Override
	public List<PurchaseListView> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}
	@Override
	public List<PurchaseListView> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria",  null, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace+".countPaging",cri);
	}
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".listSearchCount", cri);
	}
	@Override
	public List<PurchaseListView> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
	@Override
	public void updatePurchase(PurchaseVO vo) throws Exception {
		session.update(namespace+".updatePurchase", vo);
	}
	@Override
	public String getCustomerId(String customer_name) throws Exception {
		return session.selectOne(namespace+".getCustomerId", customer_name);
	}
	@Override
	public String getProductId(String product_name) throws Exception {
		return session.selectOne(namespace+".getProductId", product_name);
	}
	@Override
	public String getWarehouseId(String warehouse_name) throws Exception {
		return session.selectOne(namespace+".getWarehouseId", warehouse_name);
	}
	@Override
	public void insertExcel(PurchaseVO vo) throws Exception {
		session.insert(namespace+".insertExcel", vo);
	}
	@Override
	public List<PurchaseListView> getTotalPrice() throws Exception {
		return session.selectList(namespace+".getTotalPrice");
	}
	@Override
	public List<PurchaseListView> getCustomerGroup() throws Exception {
		return session.selectList(namespace+".getCustomerGroup");
	}
	@Override
	public List<Slip> getTotalSales() throws Exception {
		return session.selectList(namespace+".getTotalSales");
	}
	
	
	
	
									@Override
									public List<Slip> getMonth(String value) throws Exception {
										return session.selectList(namespace+".getMonth", value);
									}
									
									
									
									
									
									
									
									
}
