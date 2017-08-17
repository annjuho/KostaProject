package erp.gw.sign.service;

import java.util.List;

import erp.gw.sign.domain.DraftFormatVO;
import erp.gw.sign.domain.DraftVO;
import erp.gw.sign.domain.DraftViewVO;
import erp.gw.sign.domain.PersonViewVO;

public interface DraftService {
	//기안서
	public void insertDraft(DraftVO draft) throws Exception;
	public void updateDraft(DraftVO draft) throws Exception;
	public void deleteDraft(String draft_id) throws Exception;
	public DraftVO selectDraft(String draft_id) throws Exception;
	public DraftViewVO createDraftView(DraftVO draft) throws Exception;
	public List<DraftVO> selectDraftEmpId(String emp_id) throws Exception;
	public List<DraftVO> listDraft() throws Exception;
	public List<DraftViewVO> draftViewList() throws Exception;
	public List<DraftViewVO> myDraftViewList() throws Exception;
	public List<PersonViewVO> enameSearchList(String e_name) throws Exception;
	public String insertApproval(List<String> approvalList) throws Exception;
	public List<String> selectApprovalDraft(String draft_id) throws Exception;
	public String insertReference(List<String> referenceList) throws Exception;
	public String getEname(String emp_id) throws Exception;
	public List<DraftViewVO> myWriteDraftList() throws Exception;
	public List<DraftViewVO> myApReDraftList() throws Exception;
	public void draftOk(String draft_id) throws Exception;

	// 공통양식
	public List<DraftFormatVO> listFormat() throws Exception;
	public DraftFormatVO selectFormat(String draft_format_id) throws Exception;
	public void insertFormat(DraftFormatVO draftFormat) throws Exception;
}
