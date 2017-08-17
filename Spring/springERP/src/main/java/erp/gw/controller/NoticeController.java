package erp.gw.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.common.service.CommonService;
import erp.gw.notice.domain.NoticeReplyVO;
import erp.gw.notice.domain.NoticeVO;
import erp.gw.notice.service.NoticeReplyService;
import erp.gw.notice.service.NoticeService;
import erp.gw.projectboard.service.ProjectBoardService;

@Controller
@RequestMapping("/groupware/notice")
public class NoticeController {
	
	@Inject
	private NoticeService service;
	
	@Inject
	private NoticeReplyService reService;
	
	@Inject
	private CommonService common;
	
	@RequestMapping(value="/notice_list", method=RequestMethod.GET)
	public String myProjectList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{		
		List<NoticeVO> pList = service.listSearchCriteria(cri);
		model.addAttribute("list", pList);
		NoticeVO pro = new NoticeVO();
		
		List<String> eNameList = new ArrayList<String>();

		for(int i=0; i<pList.size(); i++){
			pro=pList.get(i);
			String name = service.enameGet(pro.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("e_name_list", eNameList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/notice/notice_list.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/notice_view", method = RequestMethod.GET)
	public void read(@RequestParam("notice_id") int notice_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		NoticeVO notice = service.read(notice_id);
		model.addAttribute("notice", notice);
		model.addAttribute("e_name", service.enameGet(notice.getEmp_id()));
		

		List<NoticeReplyVO> reList = reService.reList(notice_id);
		model.addAttribute("list", reList);
		
		NoticeReplyVO noRe = new NoticeReplyVO();
		
		List<String> eNameList = new ArrayList<String>();

		for(int i=0; i<reList.size(); i++){
			noRe=reList.get(i);
			String name = service.enameGet(noRe.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("re_name", eNameList);
	}
	
	@RequestMapping(value="/notice_write", method = RequestMethod.GET)
	public void writeGET(NoticeVO notice)throws Exception{
	}
	
	@RequestMapping(value="/notice_write", method=RequestMethod.POST)
	public String writePOST(NoticeVO notice, Model model)throws Exception{
		String emp_id=common.getEmployeeId();
		notice.setEmp_id(emp_id);
		service.write(notice);
		
		return "redirect:/groupware/notice/notice_list";
	}
	
	@RequestMapping(value="/notice_edit", method = RequestMethod.GET)
	public String editGET(int notice_id, Model model)throws Exception{
		NoticeVO notice = service.read(notice_id);
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/notice/notice_edit.jsp");
		model.addAttribute("notice", notice);
		
		return "/main";
	}

	@RequestMapping(value="/notice_edit", method = RequestMethod.POST)
	public String editPOST(int notice_id, String notice_content, String notice_title, Model model)throws Exception{
		NoticeVO notice = service.read(notice_id);
		
		notice.setNotice_content(notice_content);
		notice.setNotice_title(notice_title);
		
		service.updateNotice(notice);
		
		model.addAttribute("notice", notice);
		model.addAttribute("e_name", service.enameGet(notice.getEmp_id()));
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/notice/notice_view.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/notice_delete", method = RequestMethod.GET)
	public String projRemove(int notice_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		service.deleteNotice(notice_id);
		return "redirect:/groupware/notice/notice_list";
	}
	
	@RequestMapping(value="/notice_reply_insert", method=RequestMethod.POST)
	public String replyInsert(int notice_id, NoticeReplyVO reVO, Model model) throws Exception{
		String emp_id=common.getEmployeeId();
		reVO.setEmp_id(emp_id);
		reVO.setNotice_id(notice_id);
		reService.reInsert(reVO);

		List<NoticeReplyVO> reList = reService.reList(notice_id);
		model.addAttribute("list", reList);
		
		NoticeReplyVO noRe = new NoticeReplyVO();
		
		List<String> eNameList = new ArrayList<String>();

		for(int i=0; i<reList.size(); i++){
			noRe=reList.get(i);
			String name = service.enameGet(noRe.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("re_name", eNameList);

		
		NoticeVO notice = service.read(notice_id);
		
		model.addAttribute("notice", notice);
		model.addAttribute("e_name", service.enameGet(notice.getEmp_id()));
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/notice/notice_view.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/notice_reply_delete")
	public String replyDelete(@RequestParam("re_id") int re_id, @RequestParam("notice_id") int notice_id, Model model) throws Exception{
		reService.reDelete(re_id);

		List<NoticeReplyVO> reList = reService.reList(notice_id);
		model.addAttribute("list", reList);
		
		NoticeReplyVO noRe = new NoticeReplyVO();
		
		List<String> eNameList = new ArrayList<String>();

		for(int i=0; i<reList.size(); i++){
			noRe=reList.get(i);
			String name = service.enameGet(noRe.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("re_name", eNameList);

		
		NoticeVO notice = service.read(notice_id);
		
		model.addAttribute("notice", notice);
		model.addAttribute("e_name", service.enameGet(notice.getEmp_id()));
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/notice/notice_view.jsp");
		
		return "/main";
	}
	
	@RequestMapping(value="/notice_reply_update", method=RequestMethod.POST)
	public String replyUpdate(@RequestParam("re_id") int re_id, NoticeReplyVO reVO){
		System.out.println("ggggggggggggggggggg");
		System.out.println("id : "+ reVO.getNreply_id() + "con : "+reVO.getNreply_content());
		System.out.println(re_id);
		return "/main";
	}
}