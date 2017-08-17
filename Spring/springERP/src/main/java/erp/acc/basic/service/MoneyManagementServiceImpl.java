package erp.acc.basic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.acc.basic.domain.MoneyManagement;
import erp.acc.basic.domain.MoneyPlanTimeSet;
import erp.acc.basic.persistence.MoneyManagementDAO;

@Service
public class MoneyManagementServiceImpl implements MoneyManagementService {

	@Inject
	private MoneyManagementDAO dao;

	@Override
	public void moneyManageMentInsert(MoneyManagement mg) throws Exception {
		dao.moneyManageMentInsert(mg);
		
	}

	@Override
	public List<MoneyManagement> moneyManageMentList() throws Exception {
		return dao.moneyManageMentList();
	}

	@Override
	public void moneyPlanInsert(MoneyPlanTimeSet set) throws Exception {
		dao.MoneyplanInsert(set);
		
	}

	@Override
	public List<MoneyPlanTimeSet> monseyPlanAllList(String type) throws Exception {
		return dao.moneyPlanAllList(type);
	}

	@Override
	public MoneyPlanTimeSet useMoney(String funds_id) throws Exception {
		return dao.getMoneyPlan(funds_id);
	}

	
	
}
