package erp.sale.companybuy.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.pch.domain.PurchaseListView;
import erp.sale.companybuy.domain.CompanyBuy;
import erp.sale.companybuy.domain.CompanyBuyList;

@Repository
public class CompanyBuyDAOImpl implements CompanyBuyDAO {

	private static String namespace = "springERP.sale.mapper.saleCompanyBuyMapper";
	@Inject
	private SqlSession session;
	
	
	@Override
	public void insertCompanyBuy(CompanyBuy cb) throws Exception {
		session.insert(namespace+".insertCbuy", cb);
	}

	@Override
	public List<CompanyBuyList> listCompanyBuy() throws Exception {
		return session.selectList(namespace+".cBuyList");
	}

	@Override
	public void deleteCompanyBuy(String cbuy_id) throws Exception {
		session.delete(namespace+".deleteCbuy", cbuy_id);
	}

	@Override
	public void updateCompanyBuy(CompanyBuy cb) throws Exception {
		session.update(namespace+".updateCbuy", cb);
	}

	@Override
	public List<CompanyBuyList> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<CompanyBuyList> listCriteria(Criteria cri) throws Exception {
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
	public List<CompanyBuyList> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}
}
