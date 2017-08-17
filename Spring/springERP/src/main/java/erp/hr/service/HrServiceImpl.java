package erp.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.common.service.CommonService;
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
import erp.hr.persistence.HrDAO;

@Service
public class HrServiceImpl implements HrService {
	
	@Inject
	private HrDAO dao;

	@Override
	public int deptCheck(String b_id)throws Exception {
		return dao.deptChecker(b_id);
	}

	@Override
	public int positionCheck(String b_id)throws Exception {
		return dao.positionChecker(b_id);
	}

	@Override
	public int jobCheck(String b_id)throws Exception {
		return dao.jobChecker(b_id);
	}

	@Override
	public int dutyCheck(String b_id)throws Exception {
		return dao.dutyChecker(b_id);
	}

	@Override
	public void basicInsert(HrBasicVo vo) {
		String type = vo.getBasic_type();
		if(type.equals("dept")){
			dao.deptInsert(vo);
		}
		else if(type.equals("position")){
			dao.positionInsert(vo);
		}
		else if(type.equals("job")){
			dao.jobInsert(vo);
		}
		else{
			dao.dutyInsert(vo);
		}
	}

	@Override
	public void basicUpdate(HrBasicVo vo) {
		String type = vo.getBasic_type();
		if(type.equals("dept")){
			dao.updateDept(vo);
		}
		else if(type.equals("position")){
			dao.updatePosition(vo);
		}
		else if(type.equals("job")){
			dao.updateJob(vo);
		}
		else{
			dao.updateDuty(vo);
		}
	}

	@Override
	public List<HrDeptVO> listDept() throws Exception {
		return dao.deptList();
	}

	@Override
	public List<HrPositionVO> listPosition() throws Exception {
		return dao.positionList();
	}

	@Override
	public List<HrJobVO> listJob() throws Exception {
		return dao.jobList();
	}

	@Override
	public List<HrDutyVO> listDuty() throws Exception {
		return dao.dutyList();
	}

	@Override
	public void basicDel(HrBasicVo vo) {
		String type = vo.getBasic_type();
		String b_id = vo.getBasic_id();
		if(type.equals("dept")){
			dao.delDept(b_id);
		}
		else if(type.equals("position")){
			dao.delPosition(b_id);
		}
		else if(type.equals("job")){
			dao.delJob(b_id);
		}
		else{
			dao.delDuty(b_id);
		}
	}

	@Override
	public int empCheck(String b_id) {
		return dao.empChecker(b_id);
	}

	@Override
	public void empInsert(EmployeeVO vo) {
		dao.insertEmp(vo);
	}

	@Override
	public List<EmployeeViewVO> empLIst(SearchCriteriaHR cri) {
		return dao.empListSearch(cri);
	}

	@Override
	public int empListSearchCount(SearchCriteriaHR cri) {
		return dao.emlListCount(cri);
	}

	@Transactional
	@Override
	public void empDelete(String string) throws Exception{
		dao.indol_info_del(string);
		dao.indol_date_del(string);
		dao.empDelete(string);
	}

	@Override
	public void empUpdate(EmployeeVO vo) {
		dao.updateEmp(vo);
	}

	@Override
	public EmployeeVO getEmp(String emp_id) {
		return dao.getEmp(emp_id);
	}

	@Override
	public List<IndolInfoViewVO> indolInfoLIst(SearchCriteriaHR cri) {
		return dao.getIndolInfoLIst(cri);
	}

	@Override
	public int indolInfoSearchCount(SearchCriteriaHR cri) {
		return dao.indolInfoCount(cri);
	}

	@Override
	public IndolenceInfoVO getIndolInfo(String emp_id) {
		return dao.getIndolInfo(emp_id);
	}

	@Override
	public void indolUpdate(IndolenceInfoVO vo) {
		dao.indolUpdate(vo);
	}

	@Override
	public List<IndolRequestViewVO> indolRequestLIst(SearchCriteriaHR cri) {
		return dao.getIndolRequestList(cri);
	}

	@Override
	public int indolRequestSearchCount(SearchCriteriaHR cri) {
		return dao.getIndolRequestCount(cri);
	}
	
	@Transactional
	@Override
	public void indolApprove(String string) throws Exception{
		IndolRequestVO vo = dao.getIndolRequest(string);
		int vacation = dao.getVacation(vo.getEmp_id());
		if(vo.getRequest_type().equals("ha")){
			if(vacation>=0.5){
				dao.updateHaVacation(vo.getEmp_id());
			}
			else{
				throw new Exception();
			}
		}
		else if(vo.getRequest_type().equals("a")){
			if(vacation>=1){
				dao.updateAVacation(vo.getEmp_id());
			}
			else {
				throw new Exception();
			}
			
		}
		else{
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("vacation", Integer.parseInt(dao.CalVacation(string)));
			paramMap.put("emp_id", vo.getEmp_id());
			int check = (Integer)(paramMap.get("vacation"));

			if(vacation>=check){
				dao.updateVVacation(paramMap);
			}
			else {
				throw new Exception();
			}
		}
		
		
		dao.indolApprove(string);
		CommonService cservice = new CommonService();
		String send_id = cservice.getEmployeeId();
		String receive_id = vo.getEmp_id();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("send_id", send_id);
		paramMap.put("receive_id", receive_id);
		
		dao.sendIndolMessage(paramMap);
	}

	@Override
	public List<EmployeeViewVO> FullempLIst() {
		return dao.empFull();
	}

	@Override
	public void autorityDept(String dept_id, String authorities) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("dept_id", dept_id);
		paramMap.put("authorities", authorities);
		dao.autorityDept(paramMap);
	}

	@Override
	public void autorityEmp(String emp_id, String authorities) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("emp_id", emp_id);
		paramMap.put("authorities", authorities);
		dao.autorityEmp(paramMap);
	}
}
