package erp.gw.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.common.service.CommonService;
import erp.gw.deptboard.domain.DeptScheduleVO;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.gw.projectboard.service.ProjectBoardService;

@Controller
@RequestMapping("/groupware/project_board")
public class ProjectBoardController {
	
	@Inject
	private ProjectBoardService service;
	
	@Inject
	private CommonService common;
	
	@RequestMapping(value="/pb_myproject_list", method=RequestMethod.GET)
	public String myProjectList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{		
		Map<String, Object> map = new HashMap<String, Object>();
		String emp_id=common.getEmployeeId();
		
		map.put("cri", (SearchCriteria)cri);
		map.put("emp_id", (String)emp_id);
		
		List<ProjectsVO> pList = service.listSearchCriteria(map);
		model.addAttribute("list", pList);
		ProjectsVO pro = new ProjectsVO();
		
		List<String> eNameList = new ArrayList<String>();

		for(int i=0; i<pList.size(); i++){
			pro=pList.get(i);
			String name = service.enameGet(pro.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("e_name_list", eNameList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(emp_id));
		model.addAttribute("pageMaker", pageMaker);

		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/project_board/pb_myproject_list.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/all_project_list", method=RequestMethod.GET)
	public String allProjectList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{		
		List<ProjectsVO> pList = service.allSearchCriteria(cri);
		model.addAttribute("list", pList);
		ProjectsVO pro = new ProjectsVO();
		
		List<String> eNameList = new ArrayList<String>();
		
		for(int i=0; i<pList.size(); i++){
			pro=pList.get(i);
			String name = service.enameGet(pro.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("e_name_list", eNameList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.allSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/project_board/all_project_list.jsp");
		
		return "/main";
	}
	
	/*	메인 달력 전체 프로젝트 들고가기*/
	@RequestMapping(value="/getAllPro")
	@ResponseBody
	public List<ProjectsVO> getAllPro() throws Exception{		
		return service.getAllPro();
	}
	
	@RequestMapping(value="/pb_myproject_view", method = RequestMethod.GET)
	public void read(@RequestParam("proj_id") int proj_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		ProjectsVO pro = service.read(proj_id);
		model.addAttribute("project", pro);
		model.addAttribute("e_name", service.enameGet(pro.getEmp_id()));
	}

	@RequestMapping(value="/all_project_view", method = RequestMethod.GET)
	public void allRead(@RequestParam("proj_id") int proj_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		ProjectsVO pro = service.read(proj_id);
		model.addAttribute("project", pro);
		model.addAttribute("e_name", service.enameGet(pro.getEmp_id()));
	}
	
	@RequestMapping(value="/pb_myproject_write", method = RequestMethod.GET)
	public void writeGET(ProjectsVO project)throws Exception{
	}
	
	@Transactional
	@RequestMapping(value="/pb_myproject_write", method=RequestMethod.POST)
	public String writePOST(ProjectsVO project, Model model)throws Exception{
		DeptScheduleVO dsvo = new DeptScheduleVO();
		
		String emp_id=common.getEmployeeId();
		String dept_id=common.getDeptId();
		
		Date start = project.getProj_start_date();
		Date end = project.getProj_end_date();
		
		long day = end.getTime() - start.getTime();
		int minus = (int)day/(1000*60*60*24);
		System.out.println("일 수 : "+minus);
		project.setEmp_id(emp_id);
		project.setProj_period(minus);
		service.write(project);
		
		dsvo.setEmp_id(emp_id);
		dsvo.setEnd_schedule_date(end);
		dsvo.setStart_schedule_date(start);
		dsvo.setSchedule_content(project.getProj_content());
		dsvo.setSchedule_name(project.getProj_name());
		dsvo.setDept_id(dept_id);
		
		service.dsvoWrite(dsvo);
		
		return "redirect:/groupware/project_board/pb_myproject_list";
	}
	
	@RequestMapping(value="/pb_myproject_edit", method = RequestMethod.GET)
	public String editGET(int proj_id, Model model)throws Exception{
		ProjectsVO project = service.read(proj_id);
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/project_board/pb_myproject_edit.jsp");
		model.addAttribute("project", project);
		
		return "/main";
	}

	@RequestMapping(value="/pb_myproject_edit", method = RequestMethod.POST)
	public String editPOST(int proj_id, String proj_content, String proj_name, Model model)throws Exception{
		ProjectsVO project = service.read(proj_id);
		
		project.setProj_content(proj_content);
		project.setProj_name(proj_name);
		
		service.updateProj(project);
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/project_board/pb_myproject_view.jsp");
		
		ProjectsVO pro = service.read(proj_id);
		
		model.addAttribute("project", pro);
		model.addAttribute("e_name", service.enameGet(pro.getEmp_id()));
		
		return "/main";
	}
	
	@RequestMapping(value="/proj_delete", method = RequestMethod.GET)
	public String projRemove(int proj_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		service.deleteProj(proj_id);
		return "redirect:/groupware/project_board/pb_myproject_list";
	}
	
}