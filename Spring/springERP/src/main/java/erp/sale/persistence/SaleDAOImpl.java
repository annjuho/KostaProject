package erp.sale.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.sale.domain.SaleCustomerChart;
import erp.sale.domain.SaleGoodsDataXml;
import erp.sale.domain.SaleListView;
import erp.sale.domain.SaleProductChart;
import erp.sale.domain.SaleSearch;
import erp.sale.domain.SaleSearchTimeSet;
import erp.sale.domain.SaleVO;

@Repository
public class SaleDAOImpl implements SaleDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static String namespace = "springERP.sale.mapper.saleMapper";
	@Override
	public void addSale(SaleVO vo) throws Exception {
		sqlSession.insert(namespace+".insertSale", vo);
	}
	@Override
	public List<SaleListView> listSale() throws Exception {
		return sqlSession.selectList(namespace+".saleList");
	}
	@Override
	public void removeSale(String sell_id) throws Exception {
		sqlSession.delete(namespace+".deleteSale", sell_id);
	}
	@Override
	public void updateSale(SaleVO vo) throws Exception {
		sqlSession.update(namespace+".updateSale", vo);
	}
	@Override
	public List<SaleListView> searchSale(SaleSearchTimeSet sst) throws Exception {
		return sqlSession.selectList(namespace+".searchSaleList", sst);
	}
	@Override
	public List<SaleListView> listAll() throws Exception {
		return sqlSession.selectList(namespace+".listAll");
	}
	@Override
	public List<SaleListView> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(namespace+".listCriteria",  null, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(namespace+".countPaging",cri);
	}
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace+".listSearchCount", cri);
	}
	@Override
	public List<SaleListView> listSearch(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace+".listSearch", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
	@Override
	public void insertSaleExcel(SaleVO vo) throws Exception {
		sqlSession.insert(namespace+".insertSaleExcel", vo);
	}
	@Override
	public List<SaleProductChart> saleProductChart(String customer_id) throws Exception {
		return sqlSession.selectList(namespace+".saleProductChart", customer_id);
	}
	@Override
	public List<SaleCustomerChart> saleCustomerChart() throws Exception {
		return sqlSession.selectList(namespace+".saleCustomerChart");
	}
	@Override
	public SaleGoodsDataXml selectSaleXml(String sell_id) throws Exception {
		return sqlSession.selectOne(namespace+".selectSaleXml", sell_id);
	}
	@Override
	public void addXmlDataSell(SaleVO vo) throws Exception {
		sqlSession.insert(namespace+".xmlDataInsert", vo);
		
	}
}
