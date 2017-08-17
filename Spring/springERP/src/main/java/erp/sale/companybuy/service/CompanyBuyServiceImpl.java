package erp.sale.companybuy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.common.domain.Criteria;
import erp.sale.companybuy.domain.CompanyBuy;
import erp.sale.companybuy.domain.CompanyBuyList;
import erp.sale.companybuy.persistence.CompanyBuyDAO;

@Service
public class CompanyBuyServiceImpl implements CompanyBuyService {

	@Inject
	private CompanyBuyDAO dao;
	
	@Override
	public void insertCBuy(CompanyBuy cb) throws Exception {
		dao.insertCompanyBuy(cb);		
	}

	@Override
	public List<CompanyBuyList> listCBuy() throws Exception {
		return dao.listCompanyBuy();
	}

	@Override
	public void deleteCBuy(String cbuy_id) throws Exception {
		dao.deleteCompanyBuy(cbuy_id);
	}

	@Override
	public void updateCBuy(CompanyBuy cb) throws Exception {
		dao.updateCompanyBuy(cb);
	}

	@Override
	public List<CompanyBuyList> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<CompanyBuyList> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

}
