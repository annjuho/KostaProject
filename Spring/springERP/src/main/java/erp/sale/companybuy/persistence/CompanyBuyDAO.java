package erp.sale.companybuy.persistence;

import java.util.List;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.pch.domain.PurchaseListView;
import erp.sale.companybuy.domain.CompanyBuy;
import erp.sale.companybuy.domain.CompanyBuyList;

public interface CompanyBuyDAO {
	public void insertCompanyBuy(CompanyBuy cb)throws Exception;
	public List<CompanyBuyList> listCompanyBuy()throws Exception;
	public void deleteCompanyBuy(String cbuy_id)throws Exception;
	public void updateCompanyBuy(CompanyBuy cb)throws Exception;
	public List<CompanyBuyList> listAll() throws Exception;
	public List<CompanyBuyList> listCriteria(Criteria cri) throws Exception;
	public int countPaging(Criteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri)throws Exception;
	public List<CompanyBuyList> listSearch(SearchCriteria cri)throws Exception;
}
