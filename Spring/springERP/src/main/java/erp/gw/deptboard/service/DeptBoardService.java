package erp.gw.deptboard.service;

import java.util.List;
import java.util.Map;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.deptboard.domain.DeptScheduleVO;
import erp.hr.domain.EmployeeVO;

public interface DeptBoardService {
	   public List<DeptBoardVO> listAll()throws Exception;
	   public List<DeptBoardVO> listCriteria(Criteria cri)throws Exception;
	   public int listCountCriteria(Criteria cri)throws Exception;
	   public List<DeptBoardVO> listSearchCriteria(Map<String, Object> map)throws Exception;
	   public List<DeptScheduleVO> calSearchCriteria(Map<String, Object> map)throws Exception;
	   public List<DeptScheduleVO> getList(String dept_id)throws Exception;
	   public int listSearchCount(String dept_id) throws Exception;
	   public int calSearchCount(String dept_id) throws Exception;
/*	   public int listSearchCount(SearchCriteria cri) throws Exception;
*/	   public String enameGet(String emp_id) throws Exception;
	   public DeptBoardVO read(int dept_board_id)throws Exception;
	   public DeptScheduleVO readSch(int sch_id)throws Exception;
	   public void write(DeptBoardVO dept)throws Exception;
	   public void writeSch(DeptScheduleVO dept)throws Exception;
	   public void updateDept(DeptBoardVO dept)throws Exception;
	   public void updateSch(DeptScheduleVO dept)throws Exception;
	   public void deleteDept(int dept_board_id)throws Exception;
	   public void deleteSch(int dept_schedule_id)throws Exception;
	   public EmployeeVO getEmployee(String emp_id) throws Exception;
	   
}