package erp.acc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import erp.acc.basic.service.BasicAccountService;
import erp.gw.projectboard.domain.ProjectsVO;

@Controller
@RequestMapping("/accounting/project")
public class ProjectController {

	@Inject
	private BasicAccountService service;
	
	//프로젝트 리스트
	@RequestMapping("/list")
	public String ProjectList(Model model)throws Exception{
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("listModel", service.projectList());
		model.addAttribute("contents", "accounting/basic/Project.jsp");
		return "/main";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String projectUpdate(ProjectsVO vo)throws Exception{
		System.out.println("update come");
		service.projectUpdate(vo);
		return  "redirect:/accounting/project/list";
	}
	
}
