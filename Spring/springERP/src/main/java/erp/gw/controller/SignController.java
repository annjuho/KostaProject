package erp.gw.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.common.service.CommonService;
import erp.gw.sign.domain.ApReVO;
import erp.gw.sign.domain.DraftFormatVO;
import erp.gw.sign.domain.DraftVO;
import erp.gw.sign.domain.DraftViewVO;
import erp.gw.sign.domain.PersonViewVO;
import erp.gw.sign.service.DraftService;


@Controller
@RequestMapping("/groupware/sign")
public class SignController {
	
	@Inject
	private DraftService service;
	
	// 기안서작성 눌렀을때 뜨는 공통양식 리스트
	@RequestMapping("/format_select_list")
	public String selectFormat(Model model) throws Exception{
		
		List<DraftFormatVO> list = service.listFormat();
		
		model.addAttribute("list", list);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/format_select_list.jsp");
		
		return "/main";
	}
	
	// 공통양식 골라서 기안서 작성페이지로
	@RequestMapping("/draft_write{draft_format_id}")
	public String selectFormat(@PathVariable("draft_format_id") String draft_format_id, Model model) throws Exception{
		System.out.println("/draft_write{draft_format_id}");
		DraftFormatVO draftFormat = service.selectFormat(draft_format_id);
		
		model.addAttribute("draftFormat", draftFormat);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_write.jsp");
		
		return "/main";
	}
	
	// 공통양식 선택없이 기안서 작성페이지로
	@RequestMapping(value="/draft_write", method=RequestMethod.GET)
	public String draftWirte(Model model) throws Exception{		

		System.out.println("/draft_write hohohohoho");
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_write.jsp");
		
		return "/main";
	}
	
	// 기안서 등록
	@RequestMapping(value="/draft_write", method=RequestMethod.POST)
	public String insertDraft(ApReVO apre, DraftVO draft, Model model) throws Exception{
		
		System.out.println("value='/draft_write', method=RequestMethod.POST");
		System.out.println(apre.toString());
		
		draft.setEmp_id(CommonService.getEmployeeId());
		
		System.out.println(draft.toString());
		service.insertDraft(draft);
		
		service.insertApproval(apre.getApproval_emp());
		String draft_id = service.insertReference(apre.getReference_emp());
		
		DraftVO draftVO = service.selectDraft(draft_id);
		
		DraftViewVO draftView = service.createDraftView(draftVO);
		
		model.addAttribute("draftView", draftView);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_view.jsp");
		return "/main";
	}
		
	// 기안서 수정하는 페이지로
	@RequestMapping("/draft_edit{draft_id}")
	public String editDraft(@PathVariable("draft_id") String draft_id, Model model) throws Exception {
		System.out.println("여긴 들어오나?????");
		System.out.println("여긴 들어오나?????" + draft_id);
		DraftViewVO draftView = service.createDraftView(service.selectDraft(draft_id));
		System.out.println("여긴 들어오나?????"+draftView.toString());
		String emp_id = service.selectDraft(draft_id).getEmp_id();
		model.addAttribute("emp_id", emp_id);
		model.addAttribute("draftView", draftView);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_write.jsp");
		return "/main";
	}
	
	// 기안서 수정완료
	@RequestMapping(value="/draft_edit", method=RequestMethod.POST)
	public String editDraft(DraftVO draft, Model model) throws Exception {
		System.out.println("여긴 들어오나?????");
		System.out.println("이얍 ::::: " + draft.toString());
		service.updateDraft(draft);
		DraftViewVO draftView = service.createDraftView(draft);
		System.out.println("여긴 들어오나?????"+draftView.toString());
		model.addAttribute("draftView", draftView);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_view.jsp");
		return "/main";
	}
	
	// 기안서 삭제하기
	@RequestMapping("/draft_delete{draft_id}")
	public String deleteDraft(@PathVariable("draft_id") String draft_id, Model model) throws Exception {
		service.deleteDraft(draft_id);
		System.out.println("delete 실행쿠~!");
//		model.addAttribute("left", "groupware/groupware.jsp");
//		model.addAttribute("contents", "groupware/sign/draft_view.jsp");
		return "redirect:/groupware/sign/all_draft_list";
	}
	
	// 공통양식 작성페이지로
	@RequestMapping("/draft_format_write")
	public void newFormat(Model model) throws Exception{
		System.out.println("/draft_format_write 들어옴");
	}
	
	// 공통양식 수정페이지로
	@RequestMapping("/format_write{draft_format_id}")
	public String editFormat(@PathVariable("draft_format_id") String draft_format_id, Model model) throws Exception{
		
		DraftFormatVO draftFormat = service.selectFormat(draft_format_id);
		
		model.addAttribute("draftFormat", draftFormat);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_write.jsp");
		return "/main";
	}
	
	// 공통양식 등록
	@RequestMapping(value="/draft_format_write", method=RequestMethod.POST)
	public String insertFormat(DraftFormatVO draftFormat ,Model model) throws Exception{
		System.out.println("과연.... : "+draftFormat);
		service.insertFormat(draftFormat);
		System.out.println("/draft_format_write POST 들어옴22222");
		
		return "redirect:/groupware/sign/draft_format_list";
	}
	
	// 공통양식 리스트
	@RequestMapping("/draft_format_list")
	public String draftFormat(Model model) throws Exception{
		System.out.println("/draft_format_list 도 들어와땅 > <");
		List<DraftFormatVO> list = service.listFormat();
		
		model.addAttribute("list", list);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_format_list.jsp");
		
		System.out.println("/draft_format_list 도 들어와땅 > <222");
		return "/main";
	}
	
	
	// 공통양식 상세
	@RequestMapping("/draft_format_list{draft_format_id}")
	public String draftFormatView(Model model) throws Exception{
		
		//model.addAttribute("list", list);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_format_list.jsp");
		
		return "/main";
	}
	
	
	// 내 결재 관리 리스트
	@RequestMapping("/my_draft_list")
	public String myDraft(Model model) throws Exception{
		List<DraftViewVO> myWriteList = service.myWriteDraftList();
		List<DraftViewVO> myApReList = service.myApReDraftList();
		model.addAttribute("myWriteList", myWriteList);
		model.addAttribute("myApReList", myApReList);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/my_draft_list.jsp");
		return "/main";
	}
	
	// 기안서 리스트
	@RequestMapping("/all_draft_list")
	public String allDraft(Model model) throws Exception{
		List<DraftViewVO> list = service.draftViewList();
		
		model.addAttribute("list", list);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_list.jsp");
		return "/main";
	}
	
	// 기안서 상세보기
	@RequestMapping("/draft_view{draft_id}")
	public String draftView(@PathVariable("draft_id") String draft_id, Model model) throws Exception{
		DraftViewVO draftView = service.createDraftView(service.selectDraft(draft_id));
		model.addAttribute("draftView", draftView);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/sign/draft_view.jsp");
		return "/main";
	}
	
	// 직원 검색하기
	@ResponseBody
	@RequestMapping("/searchPeople")
	public List<PersonViewVO> eNameSearch(@RequestParam("e_name") String e_name)throws Exception{
		return service.enameSearchList(e_name);
	}
	
	// 프린트
	@ResponseBody
	@RequestMapping("/print{draft_id}")
	public DraftVO print(@PathVariable("draft_id") String draft_id) throws Exception{
		return service.selectDraft(draft_id);
	}
	
	// 프린트 새창으로
	@RequestMapping("/printPop{draft_id}")
	public String printPop() throws Exception{
		return "/groupware/sign/printPop";
	}
	
	// 결재확인
	@RequestMapping("/draft_ok{draft_id}")
	public String draftOk(@PathVariable("draft_id") String draft_id) throws Exception{
			service.draftOk(draft_id);
		return "redirect:/groupware/sign/draft_view"+draft_id;
	}
	
	// draft_id 로 emp_id 리스트 뽑기
	@ResponseBody
	@RequestMapping("/approval{draft_id}")
	public List<String> approval(@PathVariable("draft_id") String draft_id) throws Exception{
		return service.selectApprovalDraft(draft_id);
	}
}