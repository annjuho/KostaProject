package erp.my.myinfo.service;

import erp.hr.domain.EmployeeVO;
import erp.hr.domain.IndolRequestVO;

public interface MyInfoService {
	public EmployeeVO selectEmpInfo(String emp_id);
	public void editEmpInfo(EmployeeVO employee);
	public void insertIndolRequest(IndolRequestVO indolRequest);
}
