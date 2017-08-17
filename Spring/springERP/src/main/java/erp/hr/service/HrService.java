package erp.hr.service;

import java.util.List;

import erp.hr.domain.EmployeeVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.HrBasicVo;
import erp.hr.domain.HrDeptVO;
import erp.hr.domain.HrDutyVO;
import erp.hr.domain.HrJobVO;
import erp.hr.domain.HrPositionVO;
import erp.hr.domain.IndolInfoViewVO;
import erp.hr.domain.IndolRequestViewVO;
import erp.hr.domain.IndolenceInfoVO;
import erp.hr.domain.SearchCriteriaHR;

public interface HrService {
	public int deptCheck(String b_id) throws Exception;
	public int positionCheck(String b_id)throws Exception;
	public int jobCheck(String b_id)throws Exception;
	public int dutyCheck(String b_id)throws Exception;
	public void basicInsert(HrBasicVo vo);
	public void basicUpdate(HrBasicVo vo);
	public List<HrDeptVO> listDept()throws Exception;
	public List<HrPositionVO> listPosition()throws Exception;
	public List<HrJobVO> listJob()throws Exception;
	public List<HrDutyVO> listDuty()throws Exception;
	public void basicDel(HrBasicVo vo);
	public int empCheck(String b_id);
	public void empInsert(EmployeeVO vo);
	public List<EmployeeViewVO> empLIst(SearchCriteriaHR cri);
	public int empListSearchCount(SearchCriteriaHR cri);
	public void empDelete(String string) throws Exception;
	public void empUpdate(EmployeeVO vo);
	public EmployeeVO getEmp(String emp_id);
	public List<IndolInfoViewVO> indolInfoLIst(SearchCriteriaHR cri);
	public int indolInfoSearchCount(SearchCriteriaHR cri);
	public IndolenceInfoVO getIndolInfo(String emp_id);
	public void indolUpdate(IndolenceInfoVO vo);
	public List<IndolRequestViewVO> indolRequestLIst(SearchCriteriaHR cri);
	public int indolRequestSearchCount(SearchCriteriaHR cri);
	public void indolApprove(String string) throws Exception;
	public List<EmployeeViewVO> FullempLIst();
	public void autorityDept(String dept_id, String authorities);
	public void autorityEmp(String emp_id, String authorities);
}
