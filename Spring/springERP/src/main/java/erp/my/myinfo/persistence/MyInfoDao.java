package erp.my.myinfo.persistence;

import erp.hr.domain.EmployeeVO;
import erp.hr.domain.IndolRequestVO;

public interface MyInfoDao {
	public EmployeeVO selectEmpInfo(String emp_id);
	public void editEmpInfo(EmployeeVO employee);
	public void insertIndolRequest(IndolRequestVO indolRequest);
}
