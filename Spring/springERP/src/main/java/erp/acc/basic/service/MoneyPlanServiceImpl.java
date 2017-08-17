package erp.acc.basic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.acc.basic.domain.MoneyPlan;
import erp.acc.basic.domain.MoneyPlanTimeSet;
import erp.acc.basic.persistence.MoneyPlanDAO;

@Service
public class MoneyPlanServiceImpl implements MoneyPlanService {

	@Inject
	private MoneyPlanDAO dao;

	@Override
	public void moneyPlanInsert(MoneyPlanTimeSet plan) throws Exception {
		MoneyPlanTimeSet set = new MoneyPlanTimeSet();
		set.setMoneytype(plan.getMoneytype());
		set.setTypelist(plan.getTypelist());
		set.setFunds_id(plan.getFunds_id());
		set.setRepeat_unit(plan.getRepeat_unit());
		set.setStart_date(plan.getStart_date());
		set.setPeriods(plan.getPeriods());
		set.setDept_id(plan.getDept_id());
		set.setProj_id(plan.getProj_id());
		set.setAccount_id(plan.getAccount_id());
		set.setDiagnosis_number(plan.getDiagnosis_number());
		set.setCustomer_id(plan.getCustomer_id());
		set.setSums(plan.getSums());
		set.setRemarks(plan.getRemarks());
		dao.moneyPlanInsert(set);

	}

	@Override
	public void moneyPlanUpdate(MoneyPlanTimeSet plan) throws Exception {
		dao.moneyPlanUpdate(plan);

	}

	@Override
	public void moneyPlanDelete(String funds_id) throws Exception {
		dao.moneyPlanDelete(funds_id);

	}

	@Override
	public List<MoneyPlanTimeSet> moneyPlanList() throws Exception {
		return dao.moneyPlanList();
	}

	@Override
	public List<MoneyPlanTimeSet> moneyPlnapromissoryList() throws Exception {
		return	dao.moneyPlnapromissoryList();
	}

	@Override
	public List<MoneyPlanTimeSet> moneyAllList() {
		return dao.moneyAllList();
	}
}
