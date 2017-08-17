package erp.acc.basic.service;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.acc.basic.domain.AccountAllView;
import erp.acc.basic.domain.AccountAllViewDateSet;
import erp.acc.basic.domain.Accounts;
import erp.acc.basic.domain.Diagnosiss;
import erp.acc.basic.domain.NoteAllSearch;
import erp.acc.basic.domain.NoteAllSearchDateSet;
import erp.acc.basic.domain.Promissory;
import erp.acc.basic.persistence.SearchDAO;
import erp.basic.domain.Customer;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.HrDeptVO;

@Service
public class SearchServcieImpl implements SearchService {

	@Inject
	SearchDAO dao;

	// 계정관리
	@Override
	public List<Diagnosiss> diagnosisList() throws Exception {
		return dao.diagnosisList();
	}

	@Override
	public List<Diagnosiss> diagnosisNumberSearch(int diagnosis_number) throws Exception {
		return dao.diagnosisNumberSearch(diagnosis_number);
	}

	// 직원정보
	@Override
	public List<EmployeeViewVO> searchEmp_idList(String emp_id) throws Exception {
		return dao.searchEmp_idList(emp_id);
	}

	@Override
	public List<EmployeeViewVO> EmpList() throws Exception {
		return dao.EmpList();
	}

	// 통장계좌
	@Override
	public List<Accounts> accountList() throws Exception {
		return dao.accountList();
	}

	@Override
	public List<Accounts> accountListId(int account_id) throws Exception {
		return dao.accountListId(account_id);
	}

	// 부서
	@Override
	public List<HrDeptVO> listDept() throws Exception {
		return dao.listDept();
	}

	// 프로젝트
	@Override
	public List<ProjectsVO> projectList() throws Exception {
		return dao.projectList();
	}

	@Override
	public List<ProjectsVO> projectProj_idList(int proj_id) throws Exception {

		return dao.projectProj_idList(proj_id);
	}

	// 거래처
	@Override
	public List<Customer> customerList() throws Exception {
		return dao.customerList();
	}

	@Override
	public List<Customer> customerIdList(String customer_id) throws Exception {
		return dao.customerIdList(customer_id);
	}

	// 어음지급
	@Override
	public List<Promissory> promissoryList() throws Exception {
		return dao.promissoryList();
	}

	@Override
	public List<Promissory> promissoryIdList(String note_id) throws Exception {
		return dao.promissoryIdList(note_id);
	}

	// 어음결재
	@Override
	public List<Promissory> promissoryPaymentList() throws Exception {
		return dao.promissoryPaymentList();
	}

	@Override
	public List<Promissory> promissoryPaymentIdList(String note_id) throws Exception {
		return dao.promissoryPaymentIdList(note_id);
	}

	@Override
	public List<Promissory> promissoryNoteAll(NoteAllSearch getNas) throws Exception {
		NoteAllSearchDateSet nas = new NoteAllSearchDateSet();
		if(getNas.getStart_date() != "" && getNas.getEnd_date() != ""){
			nas.setStart_date(Date.valueOf(getNas.getStart_date()));
			nas.setEnd_date(Date.valueOf(getNas.getEnd_date()));
		}else{
			nas.setStart_date(Date.valueOf("1000-01-01"));
			nas.setEnd_date(Date.valueOf("3000-12-31"));
		}
		nas.setCard_number(getNas.getCard_number());
		nas.setDept_id(getNas.getDept_id());
		nas.setProject_number(getNas.getProject_number());
		nas.setTypelist(getNas.getTypelist());
		return dao.promissoryNoteAll(nas);
	}


}
