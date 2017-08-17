package erp.gw.deptboard.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.deptboard.domain.DeptScheduleVO;
import erp.gw.deptboard.persistence.DeptBoardDao;
import erp.hr.domain.EmployeeVO;

@Service
public class DeptBoardServiceImpl implements DeptBoardService {

	@Inject
	private DeptBoardDao dao;

	@Override
	public List<DeptBoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<DeptBoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<DeptBoardVO> listSearchCriteria(Map<String, Object> map) throws Exception {
		return dao.listSearch(map);
	}

	@Override
	public List<DeptScheduleVO> calSearchCriteria(Map<String, Object> map) throws Exception {
		return dao.calSearch(map);
	}

	@Override
	public int listSearchCount(String dept_id) throws Exception {
		return dao.listSearchCount(dept_id);
	}

	@Override
	public int calSearchCount(String dept_id) throws Exception {
		return dao.calSearchCount(dept_id);
	}
/*	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
*/
	@Override
	public String enameGet(String emp_id) throws Exception {
		return dao.enameGet(emp_id);
	}

	@Override
	public DeptBoardVO read(int dept_board_id) throws Exception {
		return dao.read(dept_board_id);
	}
	@Override
	public DeptScheduleVO readSch(int sch_id) throws Exception {
		return dao.readSch(sch_id);
	}

	@Override
	public void write(DeptBoardVO dept) throws Exception {
		dao.write(dept);
	}
	@Override
	public void writeSch(DeptScheduleVO dept) throws Exception {
		dao.writeSch(dept);
	}

	@Override
	public void updateDept(DeptBoardVO dept) throws Exception {
		dao.updateDept(dept);
	}
	@Override
	public void updateSch(DeptScheduleVO dept) throws Exception {
		dao.updateSch(dept);
	}

	@Override
	public void deleteDept(int dept_board_id) throws Exception {
		dao.deleteDept(dept_board_id);
	}

	@Override
	public void deleteSch(int dept_schedule_id) throws Exception {
		dao.deleteSch(dept_schedule_id);
	}

	@Override
	public EmployeeVO getEmployee(String emp_id) throws Exception {
		return dao.getEmployee(emp_id);
	}

	@Override
	public List<DeptScheduleVO> getList(String dept_id) throws Exception {
		return dao.getList(dept_id);
	}

}