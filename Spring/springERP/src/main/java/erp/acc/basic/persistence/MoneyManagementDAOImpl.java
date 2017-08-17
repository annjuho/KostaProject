package erp.acc.basic.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.acc.basic.domain.MoneyManagement;
import erp.acc.basic.domain.MoneyPlanTimeSet;

@Repository
public class MoneyManagementDAOImpl implements MoneyManagementDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "erp.acc.mapper.MoneyManageMentMapper";

	@Override
	public void moneyManageMentInsert(MoneyManagement mg) throws Exception {
		session.insert(namespace + ".moneyManageMentInsert", mg);

	}

	@Override
	public List<MoneyManagement> moneyManageMentList() throws Exception {
		return session.selectList(namespace + ".moneyManageMentList");
	}

	@Override
	public List<MoneyPlanTimeSet> moneyPlanAllList(String type) throws Exception {
		return session.selectList(namespace + ".moneyPlanAllList",type);
	}

	@Override
	public void MoneyplanInsert(MoneyPlanTimeSet set) throws Exception {
		session.insert(namespace + ".MoneyplanInsert", set);

	}
	@Override
	public MoneyPlanTimeSet getMoneyPlan(String funds_id) throws Exception {
		return session.selectOne(namespace+".moneyPlanOne", funds_id);
	}
}
