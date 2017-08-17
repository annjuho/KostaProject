package erp.acc.basic.service;

import java.util.List;

import erp.acc.basic.domain.Accounts;
import erp.acc.basic.domain.Card;
import erp.acc.basic.domain.Diagnosiss;
import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.hr.domain.EmployeeViewVO;

public interface BasicAccountService {

	// 통장계좌
	public void accountInsert(Accounts accounts) throws Exception;

	public void accountUpdate(Accounts accounts) throws Exception;

	public void accountDelete(String account_number) throws Exception;

	public List<Accounts> accountList() throws Exception;
	
	public List<Accounts>accountListId(String account_id)throws Exception;
	

	// 페이징
	public List<Accounts> listAll() throws Exception;

	public List<Accounts> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Accounts> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	// 신용카드
	public void cardInsert(Card card) throws Exception;

	public void cardUpdate(Card card) throws Exception;

	public void cardDelete(String card_number) throws Exception;

	public List<Card> cardList() throws Exception;

	// 프로젝트

	public void projectUpdate(ProjectsVO vo) throws Exception;

	public List<ProjectsVO> projectList() throws Exception;

	// diagnosis
	public void diagnosisInsert(Diagnosiss diagnosis) throws Exception;
	public List<Diagnosiss> diagnosisList() throws Exception;
	public List<Diagnosiss>diagnosisNumberSearch(String diagnosis_number)throws Exception;
	
	//empSearch
	public List<EmployeeViewVO> searchEmp_idList(String emp_id)throws Exception;
	public List<EmployeeViewVO> EmpList()throws Exception;
}
