package erp.acc.basic.persistence;

import java.util.List;

import erp.acc.basic.domain.MoneyManagement;
import erp.acc.basic.domain.MoneyPlanTimeSet;

public interface MoneyManagementDAO {

	public void moneyManageMentInsert(MoneyManagement mg) throws Exception;
	public List<MoneyManagement> moneyManageMentList() throws Exception;
	
	public List<MoneyPlanTimeSet> moneyPlanAllList(String type)throws Exception;
	public void MoneyplanInsert(MoneyPlanTimeSet set)throws Exception;
	
	public MoneyPlanTimeSet getMoneyPlan(String funds_id)throws Exception;
}
