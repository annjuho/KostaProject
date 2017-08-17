package erp.acc.controller;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import erp.acc.basic.domain.Accounts;
import erp.acc.basic.domain.Diagnosiss;
import erp.acc.basic.domain.NoteAllSearch;
import erp.acc.basic.domain.Promissory;
import erp.acc.basic.service.SearchService;
import erp.basic.domain.Customer;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.HrDeptVO;

@Controller
@RequestMapping("/Search/*")

public class SearchController {

	@Inject SearchService service;
	
	@RequestMapping("account/list")
	@ResponseBody
	public List<Accounts> accountList()throws Exception{
		return service.accountList();		
	}
	
	
	@RequestMapping("diagnosis/list")
	@ResponseBody
	public List<Diagnosiss> diagnosisList() throws Exception {
		return service.diagnosisList();
	}

	@RequestMapping("diagnosis/Idlist")
	@ResponseBody
	public List<Diagnosiss> diagnosisNumberSearch(@RequestParam("diagnosis_number") int diagnosis_number) throws Exception {
		return service.diagnosisNumberSearch(diagnosis_number);
	}

	@RequestMapping("emp/Idlist")
	@ResponseBody
	public List<EmployeeViewVO> searchEmp_idList(@RequestParam("emp_id")String emp_id) throws Exception {
		return service.searchEmp_idList(emp_id);
	}

	@RequestMapping("emp/list")
	@ResponseBody
	public List<EmployeeViewVO> EmpList() throws Exception {
		return service.EmpList();
	}	

	@RequestMapping("account/Idlist")
	@ResponseBody
	public List<Accounts> accountListId(@RequestParam("account_id")int account_id) throws Exception {
		return service.accountListId(account_id);
			}

	@RequestMapping("hr/list")
	@ResponseBody
	public List<HrDeptVO> listDept() throws Exception {
		return service.listDept();
	}

	@RequestMapping("gw/list")
	@ResponseBody
	public List<ProjectsVO> projectList() throws Exception {
		return service.projectList();
	}
	
	@RequestMapping("gw/Idlist")
	@ResponseBody
	public List<ProjectsVO> projectProj_idList(@RequestParam("proj_id")int proj_id) throws Exception {
		
		return service.projectProj_idList(proj_id);
	}

	@RequestMapping("basic/list")
	@ResponseBody
	public List<Customer> customerList() throws Exception {
		return service.customerList();
	}

	@RequestMapping("basic/Idlist")
	@ResponseBody
	public List<Customer> customerIdList(@RequestParam("customer_id")String customer_id) throws Exception {
		return service.customerIdList(customer_id);
	}

	@RequestMapping("promissory/list")
	@ResponseBody
	public List<Promissory> promissoryList()throws Exception{
		return service.promissoryList();
	}
	
	@RequestMapping("promissory/Idlist")
	@ResponseBody
	public List<Promissory> promissoryIdList(String note_id)throws Exception{
		return service.promissoryIdList(note_id);
	}
	
	@RequestMapping("promissory/Payment/list")
	@ResponseBody
	public List<Promissory> promissoryPaymentList() throws Exception {
		return service.promissoryPaymentList();
	}
	
	@RequestMapping("promissory/Payment/Idlist")
	@ResponseBody
	public List<Promissory> promissoryPaymentIdList(String note_id) throws Exception {
		return service.promissoryIdList(note_id);
	}
	@RequestMapping("/promissory/noteAllSearch")
	public String promissoryNoteAllSearch(NoteAllSearch nas, Model model)throws Exception{
		System.out.println(nas.getTypelist());
		model.addAttribute("left", "accounting/accounting.jsp");
		model.addAttribute("list", service.promissoryNoteAll(nas));
		model.addAttribute("contents", "accounting/promissory2/promissory_noteAllList.jsp");
		return "/main";
	}
}
