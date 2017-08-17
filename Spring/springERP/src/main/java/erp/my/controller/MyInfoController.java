package erp.my.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import erp.common.service.CommonService;
import erp.hr.domain.EmployeeVO;
import erp.hr.domain.IndolRequestVO;
import erp.my.myinfo.service.MyInfoService;

@Controller
@RequestMapping("/mypage/my_info")
public class MyInfoController {
	
	@Inject
	private MyInfoService service;
	@Inject
	private CommonService common;
	
	@RequestMapping("")
	public String myinfoMain(Model model){
		EmployeeVO employee = service.selectEmpInfo(CommonService.getEmployeeId());
		
		model.addAttribute("employee", employee);
		model.addAttribute("left", "mypage/mypage.jsp");
		model.addAttribute("contents", "mypage/my_info/my_info.jsp");
		
		return "/main";
	}
	
	// employee 테이블 개인정보 수정하기 - 보람
	@RequestMapping(value="/edit_info", method=RequestMethod.POST)
	public String myinfoEdit(@ModelAttribute("employee") EmployeeVO employee, Model model){
		String pass = common.passwordEncoder(employee.getPassword());
		
		employee.setE_pwd(pass);
		
		service.editEmpInfo(employee);
		
		model.addAttribute("employee", employee);
		model.addAttribute("left", "mypage/mypage.jsp");
		model.addAttribute("contents", "mypage/my_info/my_info.jsp");
		
		return "/main";
	}
	
	// 휴가신청 - 보람
	@RequestMapping(value="/indol_request", method=RequestMethod.POST)
	public String myinfoRequest(@ModelAttribute("indolRequest") IndolRequestVO indolRequest, Model model){
		EmployeeVO employee = service.selectEmpInfo(CommonService.getEmployeeId());
		service.insertIndolRequest(indolRequest);
		
		model.addAttribute("employee", employee);
		model.addAttribute("indolRequest", indolRequest);
		model.addAttribute("left", "mypage/mypage.jsp");
		model.addAttribute("contents", "mypage/my_info/my_info.jsp");
		
		return "/main";
	}
}
