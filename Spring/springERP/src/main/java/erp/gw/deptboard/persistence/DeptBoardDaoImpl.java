package erp.gw.deptboard.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.deptboard.domain.DeptScheduleVO;
import erp.hr.domain.EmployeeVO;

@Repository
public class DeptBoardDaoImpl implements DeptBoardDao {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.gw.mapper.deptBoardMapper";
	
	@Override
	public List<DeptBoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<DeptBoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", null, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public int listSearchCount(String dept_id) throws Exception {
		return session.selectOne(namespace+".listSearchCount", dept_id);
	}

	@Override
	public int calSearchCount(String dept_id) throws Exception {
		return session.selectOne(namespace+".calSearchCount", dept_id);
	}
/*	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".listSearchCount", cri);
	}
*/
	@Override
	public String enameGet(String emp_id) throws Exception {
		return session.selectOne(namespace+".enameGet", emp_id);
	}

	@Override
	public DeptBoardVO read(int dept_board_id) throws Exception {
		return session.selectOne(namespace + ".read", dept_board_id);
	}
	@Override
	public DeptScheduleVO readSch(int sch_id) throws Exception {
		return session.selectOne(namespace + ".readSch", sch_id);
	}

	@Override
	public void write(DeptBoardVO dept) throws Exception {
		session.insert(namespace + ".writeDept", dept);
	}
	@Override
	public void writeSch(DeptScheduleVO dept) throws Exception {
		session.insert(namespace + ".writeDeptSch", dept);
	}

	@Override
	public void updateDept(DeptBoardVO dept) throws Exception {
		session.update(namespace + ".updateDept", dept);
	}
	@Override
	public void updateSch(DeptScheduleVO dept) throws Exception {
		session.update(namespace + ".updateSch", dept);
	}

	@Override
	public void deleteDept(int dept_board_id) throws Exception {
		session.delete(namespace + ".deleteDept", dept_board_id);
	}
	@Override
	public void deleteSch(int dept_schedule_id) throws Exception {
		session.delete(namespace + ".deleteSch", dept_schedule_id);
	}

	@Override
	public EmployeeVO getEmployee(String emp_id) throws Exception {
		return session.selectOne(namespace + ".getEmployee", emp_id);
	}

	@Override
	public List<DeptBoardVO> listSearch(Map<String, Object> map) throws Exception {
		SearchCriteria cri = (SearchCriteria)map.get("cri");
		return  session.selectList(namespace+".listSearch", map, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public List<DeptScheduleVO> calSearch(Map<String, Object> map) throws Exception {
		SearchCriteria cri = (SearchCriteria)map.get("cri");
		return  session.selectList(namespace+".calSearch", map, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public List<DeptScheduleVO> getList(String dept_id) throws Exception {
		return session.selectList(namespace+".getList", dept_id);
	}



}