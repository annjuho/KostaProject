package erp.my.myinfo.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.hr.domain.EmployeeVO;
import erp.hr.domain.IndolRequestVO;

@Repository
public class MyInfoDaoImpl implements MyInfoDao{

private static String namespace ="springERP.mypage.mapper.myInfoMapper";
	
	@Inject
	private SqlSession session;
	
	// 로그인한사람 정보 employee 테이블에서 가져오기  - 보람
	@Override
	public EmployeeVO selectEmpInfo(String emp_id) {
		return session.selectOne(namespace + ".selectEmpInfo", emp_id);
	}
	
	// employee 테이블 개인정보 수정하기 - 보람
	@Override
	public void editEmpInfo(EmployeeVO employee) {
		session.update(namespace + ".editEmpInfo", employee);
	}
	
	// 휴가신청
	@Override
	public void insertIndolRequest(IndolRequestVO indolRequest) {
		session.insert(namespace + ".insertIndolRequest", indolRequest);
	}

}
