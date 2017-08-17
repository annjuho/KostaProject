package erp.acc.basic.service;

import java.util.List;

import erp.acc.basic.domain.AccountAllView;

public interface AccountAllViewService {

		//손익계산서총매출
		public List<AccountAllView> incomeAllsalesView()throws Exception;
		
		//손익계산서매입원가
		public List<AccountAllView> incomeProductCostPurchaseAllView()throws Exception;
		
		//직원 1개월 총 월급
		public List<AccountAllView> incomeAllEmpSalView()throws Exception;
		
		//직원 복리후생 총 비용
		public List<AccountAllView> incommAllEmpFringeView()throws Exception;
		
		//영업부서 여비교통비
		public List<AccountAllView> incommAllEmpTransportationView()throws Exception;

		//직원 통신비용
		public List<AccountAllView> incommAllEmpPostageView()throws Exception;
		
		//부서별 소모품 비용
		public List<AccountAllView> incommAllEmpSuppliesView()throws Exception;

		//직원 보험료 
		public List<AccountAllView> incommAllEmpPremiumView()throws Exception;

}
