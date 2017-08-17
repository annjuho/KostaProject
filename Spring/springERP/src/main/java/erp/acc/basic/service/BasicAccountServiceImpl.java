package erp.acc.basic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.acc.basic.domain.Accounts;
import erp.acc.basic.domain.Card;
import erp.acc.basic.domain.Diagnosiss;
import erp.acc.basic.persistence.BasicAccountDAO;
import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.hr.domain.EmployeeViewVO;


@Service
public class BasicAccountServiceImpl implements BasicAccountService {

	@Inject
	private BasicAccountDAO dao;
	
	
	//통장계좌
	@Override
	public void accountInsert(Accounts accounts) throws Exception {
		dao.accountInsert(accounts);
	}
	@Override
	public void accountUpdate(Accounts accounts) throws Exception {
		dao.accountUpdate(accounts);
	}
	
	@Override
	public void accountDelete(String account_number) throws Exception {
		dao.accountDelete(account_number);
	}
	@Override
	public List<Accounts> accountList() throws Exception {
		return dao.accountList();
	}
	
	//페이징처리
	@Override
	public List<Accounts> listAll() throws Exception {
		return dao.listAll();
	}
	
	@Override
	public List<Accounts> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}
	@Override
	public List<Accounts> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSerachCount(cri);
	}
	
	//신용카드추가
	@Override
	public void cardInsert(Card card) throws Exception {
		dao.cardInsert(card);
	}
	//신용카드수정
	@Override
	public void cardUpdate(Card card) throws Exception {
		dao.cardUpdate(card);
	}
	//신용카드삭제
	@Override
	public void cardDelete(String card_number) throws Exception {
		dao.cardDelete(card_number);
	}
	//신용카드 리스트
	@Override
	public List<Card> cardList() throws Exception {
		return dao.cardList();
	}
	@Override
	public void projectUpdate(ProjectsVO vo) throws Exception {
		System.out.println(vo.getProj_id());
		System.out.println(vo.getProj_name());
			System.out.println(vo.getSums());
			System.out.println(vo.getAccount_number());
			System.out.println(vo.getRemarks());	
			dao.projectUpdate(vo);
				
	}
	@Override
	public List<ProjectsVO> projectList() throws Exception {
		return dao.projectList();
	}
	@Override
	public void diagnosisInsert(Diagnosiss diagnosis) throws Exception {
		dao.diagnosisInsert(diagnosis);
		
	}
	@Override
	public List<Diagnosiss> diagnosisList() throws Exception {
		return dao.diagnosisList();
	}
	@Override
	public List<Accounts> accountListId(String account_id) throws Exception {
		return dao.accountListId(account_id);
	}
	
	//계정넘버검색
	@Override
	public List<Diagnosiss> diagnosisNumberSearch(String diagnosis_number) throws Exception {
		return dao.diagnosisNumberSearch(diagnosis_number);
	}
	//사원검색
	@Override
	public List<EmployeeViewVO> searchEmp_idList(String emp_id) throws Exception {
		return dao.searchEmp_idList(emp_id);
	}
	@Override
	public List<EmployeeViewVO> EmpList() throws Exception {
		return dao.EmpList();
	}
	
	
	
	
	
}
