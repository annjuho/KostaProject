package erp.acc.basic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.acc.basic.domain.AccountAllView;
import erp.acc.basic.persistence.AccountAllViewDAO;

@Service
public class AccountAllViewServiceImpl implements AccountAllViewService {

	@Inject
	private AccountAllViewDAO dao;
	
	//손익계산서 총매출
	@Override
	public List<AccountAllView> incomeAllsalesView() throws Exception {
		return dao.incomeAllsalesView();
	}

	//직원 1개월 총 월급
	@Override
	public List<AccountAllView> incomeAllEmpSalView() throws Exception {
		return dao.incomeAllEmpSalView();
	}
	//직원 1달 총 복리후생금액
	@Override
	public List<AccountAllView> incommAllEmpFringeView() throws Exception {
		return dao.incommAllEmpFringeView();
	}

	@Override
	public List<AccountAllView> incommAllEmpTransportationView() throws Exception {
		return dao.incommAllEmpTransportationView();
	}

	@Override
	public List<AccountAllView> incommAllEmpPostageView() throws Exception {
		return dao.incommAllEmpPostageView();
	}

	@Override
	public List<AccountAllView> incommAllEmpSuppliesView() throws Exception {
		return dao.incommAllEmpSuppliesView();
	}

	@Override
	public List<AccountAllView> incommAllEmpPremiumView() throws Exception {
		return dao.incommAllEmpPremiumView();
	}

	@Override
	public List<AccountAllView> incomeProductCostPurchaseAllView() throws Exception {
		return dao.incomeProductCostPurchaseAllView();
	}

}
