package erp.common.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import erp.common.domain.Criteria;
import erp.common.domain.MessageCriteria;
import erp.common.domain.MessageVO;
import erp.common.domain.MessageViewVO;
import erp.common.domain.PageMakerMessage;
import erp.common.service.MessageService;
import erp.hr.domain.EmployeeVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.SearchCriteriaHR;
import erp.stock.domain.MainStockList;
import erp.stock.service.StockRPService;
import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.common.service.CommonService;
import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.deptboard.service.DeptBoardService;
import erp.gw.notice.domain.NoticeVO;
import erp.gw.notice.service.NoticeService;

@Controller
public class CommonController {
	@Inject
	private MessageService service;
	@Inject
	private NoticeService noticeService;
	@Inject
	private DeptBoardService deptBoardService;
	@Inject
	private StockRPService stockRPService;
	@Inject
	private CommonService commonService;
	
	@RequestMapping("/main")
	public void main(@ModelAttribute("cri") SearchCriteria cri, @RequestParam(value="left", defaultValue="") String left, @RequestParam(value="maincontents", defaultValue="") String contents, Model model) throws Exception{
		model.addAttribute("maincontents","main/mainCon.jsp");
		mainNotice(cri, model);
		mainDeptBoard(cri, model);
		mainStock(model);
		model.addAttribute("mcnt", getMessageCount());
	}

	@RequestMapping("/")
	public String mainT(@ModelAttribute("cri") SearchCriteria cri, @RequestParam(value="left", defaultValue="") String left, @RequestParam(value="maincontents", defaultValue="") String contents, Model model) throws Exception{
		model.addAttribute("maincontents","main/mainCon.jsp");
		mainNotice(cri, model);
		mainDeptBoard(cri, model);
		mainStock(model);
		model.addAttribute("mcnt", getMessageCount());
		
		return "/main";
	}
	public int getMessageCount(){
		String emp_id=commonService.getEmployeeId();
		return service.getNotReadCnt(emp_id);
	}

	public void mainNotice(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		List<NoticeVO> pList = noticeService.listSearchCriteria(cri);
		model.addAttribute("noticeList", pList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(noticeService.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	public void mainStock(Model model) throws Exception{
		List<MainStockList> mainStockList = stockRPService.mainStock();
		System.out.println(mainStockList.toString());
		model.addAttribute("stockList", mainStockList);
	}
	
	public void mainDeptBoard(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		String dept_id=commonService.getDeptId();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("cri", (SearchCriteria)cri);
		map.put("dept_id", (String)dept_id);
		 
		List<DeptBoardVO> dList = deptBoardService.listSearchCriteria(map);
		model.addAttribute("deptBoardList", dList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(deptBoardService.listSearchCount(dept_id));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping("/basic")
	public String leftBasic(Model model){
		model.addAttribute("left","basic/basic.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/purchase")
	public String leftPurchase(Model model){
		model.addAttribute("left","purchase/purchase.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/sale")
	public String leftSale(Model model){
		model.addAttribute("left","sale/sale.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/odm")
	public String leftOdm(Model model){
		model.addAttribute("left","odm/odm.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/stock")
	public String leftStock(Model model){
		model.addAttribute("left","stock/stock.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/accounting")
	public String leftAcc(Model model){
		model.addAttribute("left","accounting/accounting.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/hr")
	public String leftHr(Model model){
		model.addAttribute("left","hr/hr.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/groupware")
	public String leftGroupware(Model model){
		model.addAttribute("left","groupware/groupware.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/mypage")
	public String leftMypage(Model model){
		System.out.println("hoho");
		model.addAttribute("left","mypage/mypage.jsp");
		model.addAttribute("mcnt", getMessageCount());
		return "/main";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "/login";
	}
	
	@RequestMapping(value="/message", method = RequestMethod.GET)
	public String emp_print(@ModelAttribute("cri") MessageCriteria cri, String emp_id, Model model) {
		cri.setEmp_id(emp_id);
		
		model.addAttribute("list", service.getMessageList(cri));
		
		PageMakerMessage pageMaker = new PageMakerMessage();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.messageListCount(cri));
		pageMaker.setEmp_id(emp_id);
		model.addAttribute("pageMaker", pageMaker);
		return "message";
	}
	@RequestMapping("/message/message_delete")
	public String emp_delete(@ModelAttribute("cri") MessageCriteria cri, @RequestParam("array") String[] array, RedirectAttributes rtts) throws Exception{
		for(int i=0;i<array.length;i++){
			try {
				service.messageDelete(array[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		rtts.addAttribute("emp_id", cri.getEmp_id());
		
		return "redirect:/message";
	}
	@RequestMapping(value="/message/getEmpID", method = RequestMethod.POST)
	public ResponseEntity<List<EmployeeViewVO>> getEmp(@RequestBody EmployeeVO vo){
		ResponseEntity<List<EmployeeViewVO>> entity = null;
		try {
			entity = new ResponseEntity<List<EmployeeViewVO>>(service.getEmpID(vo.getE_name()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<EmployeeViewVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/message/sendForm", method = RequestMethod.GET)
	public String sendForm(@RequestParam("emp_id") String emp_id, @RequestParam("receive_id") String receive_id, Model model){
		model.addAttribute("emp_id",emp_id);
		model.addAttribute("receive_id", receive_id);
		return "message_insert";
	}	
	
	@RequestMapping(value="/message/send_message", method = RequestMethod.POST)
	public String send_message(MessageVO vo, RedirectAttributes rtts)throws Exception{
		service.sendMessage(vo);
		rtts.addAttribute("emp_id", vo.getSend_id());
		return "redirect:/message";
	}
	
	@RequestMapping(value="/message/readMessage", method = RequestMethod.GET)
	public String getMessage(@RequestParam("message_id") int message_id, @ModelAttribute("cri") MessageCriteria cri, Model model){
		model.addAttribute("message", service.getMessage(message_id));
		PageMakerMessage pageMaker = new PageMakerMessage();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.messageListCount(cri));
		pageMaker.setEmp_id(cri.getEmp_id());
		model.addAttribute("pageMaker", pageMaker);
		return "readMessage";
	}
	
	@RequestMapping(value="/403page")
	public void errorPage(){
	}
	
	@ResponseBody
	@RequestMapping("/approval")
	public String getEmp(){
		return CommonService.getEmployeeId();
	}
}
