package erp.my.myinfo.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.hr.domain.EmployeeVO;
import erp.hr.domain.IndolRequestVO;
import erp.my.myinfo.persistence.MyInfoDao;

@Service
public class MyInfoServiceImpl implements MyInfoService {
	
	@Inject
	private MyInfoDao dao;
	
	// 로그인한사람 정보 employee 테이블에서 가져오기  - 보람
	@Override
	public EmployeeVO selectEmpInfo(String emp_id) {
		return dao.selectEmpInfo(emp_id);
	}
	
	// employee 테이블 개인정보 수정하기 - 보람
	@Override
	public void editEmpInfo(EmployeeVO employee) {
		dao.editEmpInfo(employee);
	}

	// 휴가신청
	@Override
	public void insertIndolRequest(IndolRequestVO indolRequest) {
		dao.insertIndolRequest(indolRequest);
	}

}
