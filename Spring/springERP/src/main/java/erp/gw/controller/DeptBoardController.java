package erp.gw.controller;

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
public class DeptBoardController {
	
	@Inject
	private DeptBoardService service;
	
	@Inject
	private CommonService common;
	
	@RequestMapping(value="/dept_board_list", method=RequestMethod.GET)
	public String DeptBoardList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{		
		Map<String, Object> map = new HashMap<String, Object>();
		String dept_id=common.getDeptId();
		
		map.put("cri", (SearchCriteria)cri);
		map.put("dept_id", (String)dept_id);
		
		List<DeptBoardVO> dList = service.listSearchCriteria(map);
		model.addAttribute("list", dList);
		DeptBoardVO dept = new DeptBoardVO();
		
		List<String> eNameList = new ArrayList<String>();

		for(int i=0; i<dList.size(); i++){
			dept=dList.get(i);
			String name = service.enameGet(dept.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("e_name_list", eNameList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(dept_id));
		model.addAttribute("pageMaker", pageMaker);

		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/dept_board_list.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/dept_board_view", method = RequestMethod.GET)
	public void read(@RequestParam("dept_board_id") int dept_board_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		DeptBoardVO dept = service.read(dept_board_id);
		
		model.addAttribute("dept", dept);
		model.addAttribute("e_name", service.enameGet(dept.getEmp_id()));
	}
	
	@RequestMapping(value="/dept_board_write", method = RequestMethod.GET)
	public void writeGET(DeptBoardVO dept)throws Exception{
	}
	
	@RequestMapping(value="/dept_board_write", method=RequestMethod.POST)
	public String writePOST(DeptBoardVO dept, Model model)throws Exception{
		String emp_id=common.getEmployeeId();
		EmployeeVO emp = new EmployeeVO();
		emp = service.getEmployee(emp_id);
		System.out.println("emp to String : "+emp.toString());
		dept.setDept_id(emp.getDept_id());
		dept.setEmp_id(emp_id);
		System.out.println("dept to String : " + dept.toString());
		service.write(dept);
		
		return "redirect:/groupware/dept_board/dept_board_list";
	}
	
	@RequestMapping(value="/dept_board_edit", method = RequestMethod.GET)
	public String editGET(int dept_board_id, Model model)throws Exception{
		DeptBoardVO dept = service.read(dept_board_id);
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/dept_board_edit.jsp");
		model.addAttribute("dept", dept);
		
		return "/main";
	}

	@RequestMapping(value="/dept_board_edit", method = RequestMethod.POST)
	public String editPOST(int dept_board_id, String dept_board_content, String dept_board_title, Model model)throws Exception{
		DeptBoardVO dept = service.read(dept_board_id);
		
		dept.setDept_board_content(dept_board_content);
		dept.setDept_board_title(dept_board_title);
		
		service.updateDept(dept);
		
		model.addAttribute("dept", dept);
		model.addAttribute("e_name", service.enameGet(dept.getEmp_id()));
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/dept_board_view.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/dept_board_delete", method = RequestMethod.GET)
	public String deptRemove(int dept_board_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		service.deleteDept(dept_board_id);
		return "redirect:/groupware/dept_board/dept_board_list";
	}
}