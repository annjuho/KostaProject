package erp.gw.sign.persistence;

import java.util.List;

import erp.gw.sign.domain.ApprovalVO;
import erp.gw.sign.domain.DraftFormatVO;
import erp.gw.sign.domain.DraftVO;
import erp.gw.sign.domain.ReferenceVO;
import erp.hr.domain.EmployeeViewVO;

public interface DraftDao {
	//기안서
	public void insertDraft(DraftVO draft) throws Exception;
	public void updateDraft(DraftVO draft) throws Exception;
	public void deleteDraft(String draft_id) throws Exception;
	public DraftVO selectDraft(String draft_id) throws Exception;
	public List<DraftVO> selectDraftEmpId(String emp_id) throws Exception;
	public List<DraftVO> listDraft() throws Exception;
	public List<EmployeeViewVO> enameSearchList(String e_name) throws Exception;
	public void insertApproval(ApprovalVO approval) throws Exception;
	public void updateApproval(ApprovalVO approval) throws Exception;
	public void insertReference(ReferenceVO reference) throws Exception;
	public void deleteApproval(String draft_id) throws Exception;
	public void deleteReference(String draft_id) throws Exception;
	public List<ApprovalVO> approvalListDraft(String draft_id) throws Exception;
	public List<String> selectApprovalDraft(String draft_id) throws Exception;
	public List<String> selectReferenceDraft(String draft_id) throws Exception;
	public List<String> selectApprovalEmpId(String emp_id) throws Exception;
	public List<String> selectReferenceEmpId(String emp_id) throws Exception;
	public int currvalDraft() throws Exception;
	public String getEname(String emp_id) throws Exception;
	
	// 공통양식
	public List<DraftFormatVO> listFormat() throws Exception;
	public DraftFormatVO selectFormat(String draft_format_id) throws Exception;
	public void insertFormat(DraftFormatVO draftFormat) throws Exception;
}
