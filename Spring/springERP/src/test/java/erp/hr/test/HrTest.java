package erp.hr.test;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erp.hr.domain.EmployeeVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.HrBasicVo;
import erp.hr.domain.HrDeptVO;
import erp.hr.domain.HrDutyVO;
import erp.hr.domain.HrJobVO;
import erp.hr.domain.HrPositionVO;
import erp.hr.domain.IndolInfoViewVO;
import erp.hr.domain.IndolenceInfoVO;
import erp.hr.domain.SearchCriteriaHR;
import erp.hr.persistence.HrDAO;
import erp.hr.service.HrService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class HrTest {
	@Inject
	private HrService service;
	@Inject
	private HrDAO dao;
	
	//--------------------------basic-----------------------------
	/*@Test
	public void basicTest() throws Exception{
		HrBasicVo vo = new HrBasicVo();
		vo.setBasic_id("5000");
		vo.setBasic_name("5000");
		
		//insert
		dao.deptInsert(vo);
		dao.positionInsert(vo);
		dao.dutyInsert(vo);
		dao.jobInsert(vo);
		
		//update
		vo.setBasic_name("6000");
		dao.updateDept(vo);
		dao.updateDuty(vo);
		dao.updateJob(vo);
		dao.updatePosition(vo);	
		
		//list
		List<HrDeptVO> dlist = dao.deptList();
		List<HrPositionVO> plist = dao.positionList();
		List<HrJobVO> jlist = dao.jobList();
		List<HrDutyVO> dulist = dao.dutyList();
		System.out.println(dlist);
		System.out.println(plist);
		System.out.println(jlist);
		System.out.println(dulist);
		
		//delete
		dao.delDept("5000");
		dao.delPosition("5000");
		dao.delDuty("5000");
		dao.delJob("5000");
	}*/
	//---------------------------------------emp----------------------------------------------------
	/*@Test
	public void empTest() throws Exception{
		
		//insert
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		
		EmployeeVO vo = new EmployeeVO();
		vo.setDept_id("1");
		vo.setDuty_id("1");
		vo.setE_address("address");
		vo.setE_age(30);
		vo.setE_email("email");
		vo.setE_hiredate(sqlDate);
		vo.setE_name("ㅎ2");
		vo.setE_pwd("1234");
		vo.setE_sal(9999);
		vo.setEmp_id("6000");
		vo.setJob_id("1");
		vo.setPhone_number("465654654");
		vo.setPosition_id("1");
		vo.setE_profile_pic("aaa");
		service.empInsert(vo);
		
		//list
		SearchCriteriaHR cri = new SearchCriteriaHR();
		cri.setKeyword("ㅎ2");
		cri.setPage(1);
		cri.setPerPageNum(3);
		cri.setSearchType("a");
		List<EmployeeViewVO> list = dao.empListSearch(cri);
		System.out.println(list);
		
		//update
		EmployeeVO vo = dao.getEmp("6000");
		System.out.println(vo);
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		EmployeeVO vo = new EmployeeVO();
		vo.setDept_id("1");
		vo.setDuty_id("1");
		vo.setE_address("address");
		vo.setE_age(30);
		vo.setE_email("email");
		vo.setE_hiredate(sqlDate);
		vo.setE_name("ㅎ2");
		vo.setE_pwd("1234");
		vo.setE_sal(9999);
		vo.setEmp_id("6000");
		vo.setJob_id("1");
		vo.setPhone_number("465654654");
		vo.setPosition_id("1");
		vo.setE_profile_pic("aaa");
		dao.updateEmp(vo);
		
		//delete
		//service.empDelete("6000");
		
	}*/
	@Test
	public void indolTest(){
		
		//list 확인
		/*java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		
		EmployeeVO vo = new EmployeeVO();
		vo.setDept_id("1");
		vo.setDuty_id("1");
		vo.setE_address("address");
		vo.setE_age(30);
		vo.setE_email("email");
		vo.setE_hiredate(sqlDate);
		vo.setE_name("ㅎ2");
		vo.setE_pwd("1234");
		vo.setE_sal(9999);
		vo.setEmp_id("7000");
		vo.setJob_id("1");
		vo.setPhone_number("465654654");
		vo.setPosition_id("1");
		vo.setE_profile_pic("aaa");
		service.empInsert(vo);
		
		SearchCriteriaHR cri = new SearchCriteriaHR();
		cri.setKeyword("ㅎ2");
		cri.setPage(1);
		cri.setPerPageNum(3);
		cri.setSearchType("a");
		List<IndolInfoViewVO> list = service.indolInfoLIst(cri);
		
		System.out.println(list);*/
		
		//update
		/*IndolenceInfoVO vo = new IndolenceInfoVO();
		vo.setAbsence(9);
		vo.setAnnual(2);
		vo.setEmp_id("7000");
		vo.setHalf_annual(1);
		vo.setLateness(2);
		vo.setVacation(5);
		dao.indolUpdate(vo);*/
		
		//request는 직원 요청과 같이 테스트 필요
	}
	
}
