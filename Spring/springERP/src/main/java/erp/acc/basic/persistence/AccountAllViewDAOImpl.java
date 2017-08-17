package erp.acc.basic.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.acc.basic.domain.AccountAllView;

@Repository
public class AccountAllViewDAOImpl implements AccountAllViewDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.acc.mapper.AccountAllViewMapper";

	
	//손익계산서 총매출
	@Override
	public List<AccountAllView> incomeAllsalesView() throws Exception {
		return session.selectList(namespace+".incomeAllsalesView");
	}

	//직원 1달총월급
	@Override
	public List<AccountAllView> incomeAllEmpSalView() throws Exception {
		return session.selectList(namespace+".incomeAllEmpSalView");
	}

	//직원 1달 총 복리후생금액
	@Override
	public List<AccountAllView> incommAllEmpFringeView() throws Exception {
		return session.selectList(namespace+".incommAllEmpFringeView");
	}
	//영업부서 여비교통비
	@Override
	public List<AccountAllView> incommAllEmpTransportationView() throws Exception {
		return session.selectList(namespace+".incommAllEmpTransportationView");
	}
	//직원 통신비용
	@Override
	public List<AccountAllView> incommAllEmpPostageView() throws Exception {
		return session.selectList(namespace+".incommAllEmpPostageView");
	}
	//부서별 소모품 비용
	@Override
	public List<AccountAllView> incommAllEmpSuppliesView() throws Exception {
		return session.selectList(namespace+".incommAllEmpSuppliesView");
	}
	//직원 보험료 
	@Override
	public List<AccountAllView> incommAllEmpPremiumView() throws Exception {
		return session.selectList(namespace+".incommAllEmpPremiumView");
	}

	@Override
	public List<AccountAllView> incomeProductCostPurchaseAllView() throws Exception {
		return session.selectList(namespace+".incomeProductCostPurchaseAllView");
	}

}
