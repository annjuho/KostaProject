package erp.acc.basic.persistence;

import java.util.List;

import erp.acc.basic.domain.Accounts;
import erp.acc.basic.domain.Card;
import erp.acc.basic.domain.Diagnosiss;
import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.hr.domain.EmployeeViewVO;

public interface BasicAccountDAO {

	//MoneyCheck
	
	// BASIC ACCOUNT CRUD
	public void accountInsert(Accounts accounts) throws Exception;

	public void accountUpdate(Accounts accounts) throws Exception;

	public void accountDelete(String account_number) throws Exception;

	public List<Accounts> accountList() throws Exception;
	
	public List<Accounts>accountListId(String account_id)throws Exception;

	// BASIC ACCOUNT PAGE
	public List<Accounts> listAll() throws Exception;
	
	public List<Accounts> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;

	public int listSerachCount(SearchCriteria cri) throws Exception;

	public List<Accounts> listSearch(SearchCriteria cri) throws Exception;
	
	// CARD CRUD
	
	public void cardInsert(Card card) throws Exception;

	public void cardUpdate(Card card) throws Exception;

	public void cardDelete(String card_number) throws Exception;

	public List<Card> cardList() throws Exception;

	
	//PROJECT
	
	public void projectUpdate(ProjectsVO vo)throws Exception;
	
	public List<ProjectsVO> projectList()throws Exception;
	
	//diagnosis
	public void diagnosisInsert(Diagnosiss diagnosis)throws Exception;
	public List<Diagnosiss>diagnosisList() throws Exception;
	
	//서치
	public List<Diagnosiss>diagnosisNumberSearch(String diagnosis_number)throws Exception;
	public List<EmployeeViewVO> searchEmp_idList(String emp_id)throws Exception;
	public List<EmployeeViewVO> EmpList()throws Exception;
	

}
