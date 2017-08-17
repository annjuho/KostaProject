package erp.sale.companybuy.service;

import java.util.List;

import erp.common.domain.Criteria;
import erp.pch.domain.PurchaseListView;
import erp.sale.companybuy.domain.CompanyBuy;
import erp.sale.companybuy.domain.CompanyBuyList;

public interface CompanyBuyService {
	public void insertCBuy(CompanyBuy cb)throws Exception;
	public List<CompanyBuyList> listCBuy()throws Exception;
	public void deleteCBuy(String cbuy_id)throws Exception;
	public void updateCBuy(CompanyBuy cb)throws Exception;
	public List<CompanyBuyList> listAll()throws Exception;
	public List<CompanyBuyList> listCriteria(Criteria cri)throws Exception;
	public int listCountCriteria(Criteria cri)throws Exception;
}
