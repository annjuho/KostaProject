package erp.acc.basic.service;

import java.util.List;

import erp.acc.basic.domain.AccountAllView;
import erp.acc.basic.domain.AccountAllViewDateSet;
import erp.acc.basic.domain.Accounts;
import erp.acc.basic.domain.Diagnosiss;
import erp.acc.basic.domain.NoteAllSearch;
import erp.acc.basic.domain.Promissory;
import erp.basic.domain.Customer;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.HrDeptVO;

public interface SearchService {

	//계정관리
		public List<Diagnosiss> diagnosisList() throws Exception;

		public List<Diagnosiss> diagnosisNumberSearch(int diagnosis_number) throws Exception;

		//직원
		public List<EmployeeViewVO> searchEmp_idList(String emp_id) throws Exception;

		public List<EmployeeViewVO> EmpList() throws Exception;
		
		
		//계좌
		public List<Accounts> accountList() throws Exception;
		
		public List<Accounts>accountListId(int account_id)throws Exception;
		
		//부서
		public List<HrDeptVO> listDept()throws Exception;
		
		//프로젝트
		public List<ProjectsVO> projectList()throws Exception;
		public List<ProjectsVO> projectProj_idList(int proj_id)throws Exception;
		
		//거래처
		
		public List<Customer> customerList() throws Exception;
		public List<Customer> customerIdList(String customer_id) throws Exception;
	
		//어음지급
		public List<Promissory> promissoryList()throws Exception;
		public List<Promissory> promissoryIdList(String note_id) throws Exception;
		
		//어음결재
		public List<Promissory> promissoryPaymentList()throws Exception;
		public List<Promissory> promissoryPaymentIdList(String note_id) throws Exception;
		
		//어음원장
		public List<Promissory> promissoryNoteAll(NoteAllSearch nas)throws Exception;
		
		
	/*	public List<AccountAllView> incomeAllview (AccountAllView dateSet)throws Exception;*/
}
