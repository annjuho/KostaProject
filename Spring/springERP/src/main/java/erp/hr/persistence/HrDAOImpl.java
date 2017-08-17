package erp.hr.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.basic.domain.ProductGroup;
import erp.hr.domain.EmployeeVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.HrBasicVo;
import erp.hr.domain.HrDeptVO;
import erp.hr.domain.HrDutyVO;
import erp.hr.domain.HrJobVO;
import erp.hr.domain.HrPositionVO;
import erp.hr.domain.IndolInfoViewVO;
import erp.hr.domain.IndolRequestVO;
import erp.hr.domain.IndolRequestViewVO;
import erp.hr.domain.IndolenceInfoVO;
import erp.hr.domain.SearchCriteriaHR;

@Repository
public class HrDAOImpl implements HrDAO {

	
	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.hr.mapper.HrMapper";

	@Override
	public int deptChecker(String b_id) throws Exception{
		return session.selectOne(namespace + ".deptChecker", b_id);
	}

	@Override
	public int positionChecker(String b_id) throws Exception{
		return session.selectOne(namespace + ".positionChecker", b_id);
	}

	@Override
	public int jobChecker(String b_id) throws Exception{
		return session.selectOne(namespace + ".jobChecker", b_id);
	}

	@Override
	public int dutyChecker(String b_id) throws Exception{
		return session.selectOne(namespace + ".dutyChecker", b_id);
	}

	@Override
	public void deptInsert(HrBasicVo vo) {
		session.insert(namespace + ".deptInsert", vo);
	}

	@Override
	public void positionInsert(HrBasicVo vo) {
		session.insert(namespace + ".positionInsert", vo);
	}

	@Override
	public void jobInsert(HrBasicVo vo) {
		session.insert(namespace + ".jobInsert", vo);
	}

	@Override
	public void dutyInsert(HrBasicVo vo) {
		session.insert(namespace + ".dutyInsert", vo);
	}

	@Override
	public void updateDept(HrBasicVo vo) {
		session.update(namespace + ".updateDept", vo);
	}

	@Override
	public void updatePosition(HrBasicVo vo) {
		session.update(namespace + ".updatePosition", vo);
	}

	@Override
	public void updateJob(HrBasicVo vo) {
		session.update(namespace + ".updateJob", vo);
	}

	@Override
	public void updateDuty(HrBasicVo vo) {
		session.update(namespace + ".updateDuty", vo);
	}

	@Override
	public List<HrDeptVO> deptList() {
		return session.selectList(namespace + ".deptList");
	}

	@Override
	public List<HrPositionVO> positionList() {
		return session.selectList(namespace + ".positionList");
	}

	@Override
	public List<HrJobVO> jobList() {
		return session.selectList(namespace + ".jobList");
	}

	@Override
	public List<HrDutyVO> dutyList() {
		return session.selectList(namespace + ".dutyList");
	}

	@Override
	public void delDept(String b_id) {
		session.delete(namespace + ".delDept", b_id);
	}

	@Override
	public void delPosition(String b_id) {
		session.delete(namespace + ".delPosition", b_id);
	}

	@Override
	public void delJob(String b_id) {
		session.delete(namespace + ".delJob", b_id);
	}

	@Override
	public void delDuty(String b_id) {
		session.delete(namespace + ".delDuty", b_id);
	}

	@Override
	public int empChecker(String b_id) {
		return session.selectOne(namespace + ".empChecker", b_id);
	}

	@Override
	public void insertEmp(EmployeeVO vo) {
		session.selectOne(namespace + ".insertEmp", vo);
	}

	@Override
	public List<EmployeeViewVO> empListSearch(SearchCriteriaHR cri) {
		return session.selectList(namespace+".empListSearch", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int emlListCount(SearchCriteriaHR cri) {
		return session.selectOne(namespace+".empListSearchCount", cri);
	}

	@Override
	public void empDelete(String string) {
		session.delete(namespace+".empDelete", string);
	}

	@Override
	public void updateEmp(EmployeeVO vo) {
		session.update(namespace+".updateEmp", vo);
	}

	@Override
	public EmployeeVO getEmp(String emp_id) {
		return session.selectOne(namespace+".getEmp", emp_id);
	}

	@Override
	public void indol_info_del(String string) {
		session.delete(namespace+".indol_info_del", string);
	}

	@Override
	public void indol_date_del(String string) {
		session.delete(namespace+".indol_date_del", string);
	}

	@Override
	public List<IndolInfoViewVO> getIndolInfoLIst(SearchCriteriaHR cri) {
		return session.selectList(namespace+".getIndolInfoLIst", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int indolInfoCount(SearchCriteriaHR cri) {
		return session.selectOne(namespace+".indolInfoCount", cri);
	}

	@Override
	public IndolenceInfoVO getIndolInfo(String emp_id) {
		return session.selectOne(namespace+".getIndolInfo", emp_id);
	}

	@Override
	public void indolUpdate(IndolenceInfoVO vo) {
		session.update(namespace+".indolUpdate", vo);
	}

	@Override
	public List<IndolRequestViewVO> getIndolRequestList(SearchCriteriaHR cri) {
		return session.selectList(namespace+".getIndolRequestList", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int getIndolRequestCount(SearchCriteriaHR cri) {
		return session.selectOne(namespace+".getIndolRequestCount", cri);
	}

	@Override
	public void indolApprove(String string) {
		session.update(namespace+".indolApprove", string);
	}

	@Override
	public IndolRequestVO getIndolRequest(String string) {
		return session.selectOne(namespace+".getIndolRequest", string);
	}

	@Override
	public int getVacation(String emp_id) {
		return session.selectOne(namespace+".getVacation", emp_id);
	}

	@Override
	public void updateHaVacation(String emp_id) {
		session.update(namespace+".updateHaVacation", emp_id);
	}

	@Override
	public void updateAVacation(String emp_id) {
		session.update(namespace+".updateAVacation", emp_id);
	}

	@Override
	public String CalVacation(String string) {
		return session.selectOne(namespace+".CalVacation", string);
	}

	@Override
	public void updateVVacation(Map<String, Object> paramMap) {
		session.update(namespace+".updateVVacation", paramMap);
	}

	@Override
	public List<EmployeeViewVO> empFull() {
		return session.selectList(namespace+".empFull");
	}

	@Override
	public void sendIndolMessage(Map<String, String> paramMap) {
		session.insert(namespace+".sendIndolMessage", paramMap);
	}

	@Override
	public void autorityDept(Map<String, String> paramMap) {
		session.update(namespace+".autorityDept", paramMap);
	}

	@Override
	public void autorityEmp(Map<String, String> paramMap) {
		session.update(namespace+".autorityEmp", paramMap);
	}
}
