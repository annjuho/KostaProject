package erp.acc.basic.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.acc.basic.domain.AccountAllView;
import erp.acc.basic.domain.AccountAllViewDateSet;
import erp.acc.basic.domain.Accounts;
import erp.acc.basic.domain.Diagnosiss;
import erp.acc.basic.domain.NoteAllSearchDateSet;
import erp.acc.basic.domain.Promissory;
import erp.basic.domain.Customer;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.HrDeptVO;

@Repository
public class SearchDAOImpl implements SearchDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "erp.acc.mapper.SearchMapper";
	
	@Override
	public List<Diagnosiss> diagnosisList() throws Exception {
		return session.selectList(namespace+".diagnosisList");
	}

	@Override
	public List<Diagnosiss> diagnosisNumberSearch(int diagnosis_number) throws Exception {
		return session.selectList(namespace+".diagnosisNumberSearch", diagnosis_number);
	}

	@Override
	public List<EmployeeViewVO> searchEmp_idList(String emp_id) throws Exception {
		return session.selectList(namespace+".searchEmp_idList", emp_id);
	}

	@Override
	public List<EmployeeViewVO> EmpList() throws Exception {
		return session.selectList(namespace+".EmpList");
	}

	@Override
	public List<Accounts> accountList() throws Exception {
		return session.selectList(namespace+".accountList");
	}

	@Override
	public List<Accounts> accountListId(int account_id) throws Exception {
		return session.selectList(namespace+".accountListId", account_id);
	}

	@Override
	public List<HrDeptVO> listDept() throws Exception {
		return session.selectList(namespace+".listDept");
	}

	@Override
	public List<ProjectsVO> projectList() throws Exception {
		return session.selectList(namespace+".projectList");
	}

	@Override
	public List<ProjectsVO> projectProj_idList(int proj_id) throws Exception {
		return session.selectList(namespace+".projectProj_idList", proj_id);
	}

	@Override
	public List<Customer> customerList() throws Exception {
		return session.selectList(namespace+".customerList");
	}

	@Override
	public List<Customer> customerIdList(String customer_id) throws Exception {
		return session.selectList(namespace+".customerIdList", customer_id);
	}

	@Override
	public List<Promissory> promissoryList() throws Exception {
		return session.selectList(namespace+".promissoryList");
	}

	@Override
	public List<Promissory> promissoryIdList(String note_id) throws Exception {
		return session.selectList(namespace+".promissoryIdList", note_id);
	}

	@Override
	public List<Promissory> promissoryPaymentList() throws Exception {
		return session.selectList(namespace+".promissoryPaymentList");
	}

	@Override
	public List<Promissory> promissoryPaymentIdList(String note_id) throws Exception {
		return session.selectList(namespace+".promissoryPaymentIdList", note_id);
	}


	@Override
	public List<Promissory> promissoryNoteAll(NoteAllSearchDateSet nas) throws Exception {
		return session.selectList(namespace+".promissoryNoteAllSearch", nas);
	}

		
	@Override
	public List<AccountAllView> incomeAllview(AccountAllViewDateSet dateSet) throws Exception {
		return session.selectList(namespace+".incomeAllview", dateSet);
		
	}

	@Override
	public List<Promissory> promissoryIdCheck(String word) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
