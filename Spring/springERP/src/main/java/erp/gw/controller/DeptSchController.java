package erp.gw.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.JSONPObject;

import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.common.service.CommonService;
import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.deptboard.domain.DeptScheduleVO;
import erp.gw.deptboard.service.DeptBoardService;
import erp.hr.domain.EmployeeVO;

@Controller
@RequestMapping("/groupware/dept_board")
public class DeptSchController {
	
	@Inject
	private DeptBoardService service;
	
	@Inject
	private CommonService common;

	@RequestMapping(value="/dept_calendar", method=RequestMethod.GET)
	public String DeptCal(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{		
		Map<String, Object> map = new HashMap<String, Object>();
		String dept_id=common.getDeptId();
		
		map.put("cri", (SearchCriteria)cri);
		map.put("dept_id", (String)dept_id);
		
		List<DeptScheduleVO> dList = service.calSearchCriteria(map);
		model.addAttribute("list", dList);
		DeptScheduleVO dept = new DeptScheduleVO();
		
		List<String> eNameList = new ArrayList<String>();
		
		for(int i=0; i<dList.size(); i++){
			dept=dList.get(i);
			String name = service.enameGet(dept.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("e_name_list", eNameList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.calSearchCount(dept_id));
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/dept_calendar.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/getCalendar")
	@ResponseBody
	public List<DeptScheduleVO> calendarAjax() throws Exception{
		String dept_id=common.getDeptId();
		return service.getList(dept_id);
	}
	
	@RequestMapping(value="/dept_sch_view", method = RequestMethod.GET)
	public void readSch(@RequestParam("sch_id") int sch_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		DeptScheduleVO dept = service.readSch(sch_id);
		
		model.addAttribute("dept", dept);
		model.addAttribute("e_name", service.enameGet(dept.getEmp_id()));
	}
	
	@RequestMapping(value="/dept_sch_write", method = RequestMethod.GET)
	public void writeSchGET(DeptScheduleVO dept)throws Exception{
	}
	
	@RequestMapping(value="/dept_sch_write", method=RequestMethod.POST)
	public String writeSchPOST(DeptScheduleVO dept, Model model)throws Exception{
		String emp_id=common.getEmployeeId();
		EmployeeVO emp = new EmployeeVO();
		emp = service.getEmployee(emp_id);
		dept.setDept_id(emp.getDept_id());
		dept.setEmp_id(emp_id);
		
		service.writeSch(dept);
		
		return "redirect:/groupware/dept_board/dept_calendar";
	}
	
	@RequestMapping(value="/dept_sch_edit", method = RequestMethod.GET)
	public String editSchGET(int dept_schedule_id, Model model)throws Exception{
		DeptScheduleVO dept = service.readSch(dept_schedule_id);
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/dept_sch_edit.jsp");
		model.addAttribute("dept", dept);
		
		return "/main";
	}
	
	@RequestMapping(value="/dept_sch_edit", method = RequestMethod.POST)
	public String editSchPOST(Date start_schedule_date, Date end_schedule_date, int dept_schedule_id, String schedule_content, String schedule_name, Model model)throws Exception{
		DeptScheduleVO dept = service.readSch(dept_schedule_id);
		
		dept.setSchedule_content(schedule_content);
		dept.setSchedule_name(schedule_name);
		dept.setStart_schedule_date(start_schedule_date);
		dept.setEnd_schedule_date(end_schedule_date);
		service.updateSch(dept);
		 
		model.addAttribute("dept", dept);
		model.addAttribute("e_name", service.enameGet(dept.getEmp_id()));
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/dept_sch_view.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/dept_sch_delete", method = RequestMethod.GET)
	public String deptSchRemove(int dept_schedule_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		service.deleteSch(dept_schedule_id);
		return "redirect:/groupware/dept_board/dept_calendar";
	}
	
}