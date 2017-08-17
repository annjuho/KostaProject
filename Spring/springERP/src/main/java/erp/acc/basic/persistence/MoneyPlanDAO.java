package erp.acc.basic.persistence;

import java.util.List;

import erp.acc.basic.domain.MoneyPlan;
import erp.acc.basic.domain.MoneyPlanTimeSet;
import erp.acc.basic.domain.Promissory;

public interface MoneyPlanDAO {

	public void moneyPlanInsert(MoneyPlanTimeSet set) throws Exception;

	public void moneyPlanUpdate(MoneyPlanTimeSet plan) throws Exception;

	public void moneyPlanDelete(String funds_id) throws Exception;

	public List<MoneyPlanTimeSet> moneyPlanList() throws Exception;

	public List<MoneyPlanTimeSet> moneyPlnapromissoryList()throws Exception;

	public List<MoneyPlanTimeSet> moneyAllList();
}
