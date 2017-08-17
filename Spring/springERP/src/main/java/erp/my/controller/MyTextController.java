package erp.my.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import erp.common.domain.Criteria;
import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.common.service.CommonService;
import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.deptboard.service.DeptBoardService;
import erp.gw.notice.service.NoticeService;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.my.mytext.domain.MyDeptTextCriteria;
import erp.my.mytext.domain.MyDeptTextPageMaker;
import erp.my.mytext.service.MyTextService;

@Controller
@RequestMapping("/mypage/my_text")
public class MyTextController {
	
	@Inject
	private MyTextService service;
	
	@Inject
	private CommonService common;
	
	
	@RequestMapping(value="/my_text", method=RequestMethod.GET)
	public String BoardList(@ModelAttribute("projCri") Criteria projCri, @ModelAttribute("deptCri") MyDeptTextCriteria deptCri, Model model) throws Exception{		
		Map<String, Object> map = new HashMap<String, Object>();
		String emp_id=common.getEmployeeId();
		
		map.put("deptCri", (MyDeptTextCriteria)deptCri);
		map.put("projCri", (Criteria)projCri);
		map.put("emp_id", (String)emp_id);
		
		/* 부서 게시판 내 글 */
		
		List<DeptBoardVO> deptBoardList = service.getDeptBoardList(map);
		model.addAttribute("deptBoardList", deptBoardList);
		DeptBoardVO dept = new DeptBoardVO();
		
		List<String> deptEnameList = new ArrayList<String>();

		for(int i=0; i<deptBoardList.size(); i++){
			dept=deptBoardList.get(i);
			String name = service.enameGet(dept.getEmp_id());
			deptEnameList.add(name);
		}
		
		model.addAttribute("dept_ename_list", deptEnameList);

		MyDeptTextPageMaker deptBoardPageMaker = new MyDeptTextPageMaker();
		deptBoardPageMaker.setDeptCri(deptCri);
		deptBoardPageMaker.setTotalCount(service.deptBoardCount(emp_id));
		model.addAttribute("deptBoardPageMaker", deptBoardPageMaker);

		/* 프로젝트 내 글 */
		
		List<ProjectsVO> myProjList = service.getMyProjList(map);
		model.addAttribute("myProjList", myProjList);
		ProjectsVO pro = new ProjectsVO();
		
		List<String> myProjEnameList = new ArrayList<String>();

		for(int i=0; i<myProjList.size(); i++){
			pro=myProjList.get(i);
			String name = service.enameGet(pro.getEmp_id());
			myProjEnameList.add(name);
		}
		
		model.addAttribute("myProj_Ename_list", myProjEnameList);

		PageMaker myProjPageMaker = new PageMaker();
		myProjPageMaker.setCri(projCri);
		myProjPageMaker.setTotalCount(service.myProjCount(emp_id));
		model.addAttribute("myProjPageMaker", myProjPageMaker);
		
		
		
		model.addAttribute("left", "mypage/mypage.jsp");
		model.addAttribute("contents", "mypage/my_text/my_text.jsp");
		
		return "/main";
	}
}
