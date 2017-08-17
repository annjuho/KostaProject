package erp.gw.sign.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.common.service.CommonService;
import erp.gw.sign.domain.ApprovalVO;
import erp.gw.sign.domain.DraftFormatVO;
import erp.gw.sign.domain.DraftVO;
import erp.gw.sign.domain.DraftViewVO;
import erp.gw.sign.domain.PersonViewVO;
import erp.gw.sign.domain.ReferenceVO;
import erp.gw.sign.persistence.DraftDao;
import erp.hr.domain.EmployeeViewVO;

@Service
public class DraftServiceImpl implements DraftService {
	
	@Inject
	private DraftDao dao;

	@Override
	public List<DraftFormatVO> listFormat() throws Exception {
		System.out.println("hoho");
		return dao.listFormat();
	}

	@Override
	public DraftFormatVO selectFormat(String draft_format_id) throws Exception {
		return dao.selectFormat(draft_format_id);
	}

	@Override
	public void insertDraft(DraftVO draft) throws Exception {
		System.out.println("insertDraft 서비스 한당 > <");
		System.out.println(draft.toString());
		dao.insertDraft(draft);
	}

	@Override
	public void insertFormat(DraftFormatVO draftFormat) throws Exception {
		dao.insertFormat(draftFormat);
	}

	@Override
	public List<DraftVO> selectDraftEmpId(String emp_id) throws Exception {
		return dao.selectDraftEmpId(emp_id);
	}

	@Override
	public List<DraftVO> listDraft() throws Exception {
		return dao.listDraft();
	}

	@Override
	public DraftVO selectDraft(String draft_id) throws Exception {
		return dao.selectDraft(draft_id);
	}

	@Override
	public List<PersonViewVO> enameSearchList(String e_name) throws Exception {
		
		List<EmployeeViewVO> e_list = dao.enameSearchList(e_name);
		List<PersonViewVO> list = new ArrayList<PersonViewVO>();
		
		for(int i=0; i<e_list.size(); i++){
			PersonViewVO personView = new PersonViewVO();
			personView.setEmp_id(e_list.get(i).getEmp_id());
			personView.setE_name(e_list.get(i).getE_name());
			personView.setE_email(e_list.get(i).getE_email());
			personView.setDept_name(e_list.get(i).getDept_name());
			personView.setPosition_name(e_list.get(i).getPosition_name());
			personView.setJob_name(e_list.get(i).getJob_name());
			personView.setDuty_name(e_list.get(i).getDuty_name());
			
			list.add(personView);
		}
		return list;
	}
	
	// emp_id 로 e_name 구하기
	@Override
	public String getEname(String emp_id) throws Exception {
		return dao.getEname(emp_id);
	}

	// draft 전체 목록
	@Override
	public List<DraftViewVO> draftViewList() throws Exception {
		List<DraftVO> draftList = dao.listDraft();
		List<DraftViewVO> draftViewList = new ArrayList<DraftViewVO>();
		
		for(int i=0; i<draftList.size(); i++){
			draftViewList.add(createDraftView(draftList.get(i)));
		}
		
		System.out.println("이야압! 간다! ");
		System.out.println(draftViewList.toString());
		return draftViewList;
	}
	
	// 내 결재관리 리스트
	@Override
	public List<DraftViewVO> myDraftViewList() throws Exception {
		
		List<DraftVO> draftList = new ArrayList<DraftVO>();
		List<DraftViewVO> draftViewList = new ArrayList<DraftViewVO>();
		
		// 결재자, 참조자에 내이름 있으면 가져오기
		List<String> ap_draftId_list = dao.selectApprovalEmpId(CommonService.getEmployeeId());
		List<String> re_draftId_list = dao.selectReferenceEmpId(CommonService.getEmployeeId());
		
		// 결재자에 내가 있는 기안서 목록에 추가하기
		for(int i=0; i<ap_draftId_list.size(); i++){
			draftList.add(dao.selectDraft(ap_draftId_list.get(i)));
		}
		
		// 참조라인에서 결재라인에 중복되지 않는것만 기안서 목록에 추가하기
		for(int i=0;i<re_draftId_list.size();i++){
			boolean check = true;
			for(int j=0;j<draftList.size();j++){
				if(re_draftId_list.get(i).equals(draftList.get(j).getDraft_id())){
					check = false;
					break;
				}
			}
			if(check){
				draftList.add(dao.selectDraft(re_draftId_list.get(i)));
			}
		}
		
		System.out.println("?hoho?");
		System.out.println(CommonService.getEmployeeId());
		
		// 내가 쓴 기안서 목록 가져오기
		List<DraftVO> myDraftList = dao.selectDraftEmpId(CommonService.getEmployeeId());

		int myDraftListSize = myDraftList.size();
		int draftListSize = draftList.size();
		
		// 내가 쓴 글들 중에서 참조라인, 결재라인에서 불러온 것들과 중복되지 않는것만 기안서 목록에 추가하기
		for(int i=0;i<myDraftListSize;i++){
			boolean check = true;
			for(int j=0;j<draftListSize;j++){
				if(myDraftList.get(i).getDraft_id().equals(draftList.get(j).getDraft_id())){
					System.out.println("같을때:"+draftList.get(j).getDraft_id() +":" +myDraftList.get(i).getDraft_id());
					check = false;
					break;
				}
			}
			if(check){
				draftList.add(dao.selectDraft(myDraftList.get(i).getDraft_id()));
				System.out.println("다를때:"+":"+myDraftList.get(i).getDraft_id());
			}
		}
		
		for(int i=0; i<draftList.size(); i++){
			draftViewList.add(createDraftView(draftList.get(i)));
		}
		
		System.out.println("이야압! 간다! 되라되라 !! ");
		System.out.println(draftViewList.toString());
		return draftViewList;
	}

	
	
	
	// 내가 쓴 기안서 리스트
	@Override
	public List<DraftViewVO> myWriteDraftList() throws Exception {
		
		List<DraftVO> draftList = new ArrayList<DraftVO>();
		List<DraftViewVO> draftViewList = new ArrayList<DraftViewVO>();
		
		// 내가 쓴 기안서 목록 가져오기
		List<DraftVO> myDraftList = dao.selectDraftEmpId(CommonService.getEmployeeId());
		
		// 내가 쓴 글들 중에서 참조라인, 결재라인에서 불러온 것들과 중복되지 않는것만 기안서 목록에 추가하기
		for(int i=0;i<myDraftList.size();i++){
			draftList.add(dao.selectDraft(myDraftList.get(i).getDraft_id()));
		}
		
		for(int i=0; i<draftList.size(); i++){
			System.out.println("뽀문에 들어오나여 ??? : " + i);
			draftViewList.add(createDraftView(draftList.get(i)));
		}
		
		System.out.println("!!!! 탭 1 달려!!!!!! ");
		return draftViewList;
	}
	
	
	// 내가 결재라인/참조라인에 불린 기안서 리스트
	@Override
	public List<DraftViewVO> myApReDraftList() throws Exception {
		List<DraftVO> draftList = new ArrayList<DraftVO>();
		List<DraftViewVO> draftViewList = new ArrayList<DraftViewVO>();
		
		// 결재자, 참조자에 내이름 있으면 가져오기
		List<String> ap_draftId_list = dao.selectApprovalEmpId(CommonService.getEmployeeId());
		List<String> re_draftId_list = dao.selectReferenceEmpId(CommonService.getEmployeeId());
		
		// 결재자에 내가 있는 기안서 목록에 추가하기
		for(int i=0; i<ap_draftId_list.size(); i++){
			draftList.add(dao.selectDraft(ap_draftId_list.get(i)));
			System.out.println("포문을찍어보쟝111 : " + i + ap_draftId_list.get(i));
		}
		
		// 참조라인에서 결재라인에 중복되지 않는것만 기안서 목록에 추가하기
		for(int i=0;i<re_draftId_list.size();i++){
			boolean check = true;
			for(int j=0;j<draftList.size();j++){
				if(re_draftId_list.get(i).equals(draftList.get(j).getDraft_id())){
					System.out.println("같을때:"+draftList.get(j).getDraft_id() +":" +re_draftId_list.get(i));
					check = false;
					break;
				}
			}
			if(check){
				draftList.add(dao.selectDraft(re_draftId_list.get(i)));
				System.out.println("다를때:"+":"+re_draftId_list.get(i));
			}
		}
		
		for(int i=0; i<draftList.size(); i++){
			System.out.println("뽀문에 들어오나여 ??? : " + i);
			draftViewList.add(createDraftView(draftList.get(i)));
		}
		
		System.out.println("탭투 달려!!!");
		return draftViewList;
	}
	
	
	// DraftVO로 DraftViewVO 생성하기
	@Override
	public DraftViewVO createDraftView(DraftVO draft) throws Exception {
		System.out.println("----- createCraftView 에 들어온 draft : " + draft.toString());
		
		DraftViewVO draftView = new DraftViewVO();
		
		List<String> ap_empId_list = dao.selectApprovalDraft(draft.getDraft_id());
		List<String> re_empId_list = dao.selectReferenceDraft(draft.getDraft_id());
		
		List<String> ap_eName_list = new ArrayList<String>();
		List<String> re_eName_list = new ArrayList<String>();
		
		for(int i=0; i<ap_empId_list.size(); i++){
			ap_eName_list.add(dao.getEname(ap_empId_list.get(i)));
		}
		for(int i=0; i<re_empId_list.size(); i++){
			re_eName_list.add(dao.getEname(re_empId_list.get(i)));
		}
		draftView.setDraft_id(draft.getDraft_id());
		draftView.setDraft_title(draft.getDraft_title());
		draftView.setDraft_content(draft.getDraft_content());
		draftView.setDraft_type(draft.getDraft_type());
		draftView.setDraft_date(draft.getDraft_date());
		draftView.setEmp_id(draft.getEmp_id());
		draftView.setE_name(dao.getEname(draft.getEmp_id()));
		draftView.setDraft_state(draft.getDraft_state());
		draftView.setApproval(ap_eName_list);
		draftView.setReference(re_eName_list);
		
		return draftView;
	}
	
	// 기안서 수정하기
	@Override
	public void updateDraft(DraftVO draft) throws Exception {
		dao.updateDraft(draft);
	}
	
	// 기안서 삭제하기
	@Override
	public void deleteDraft(String draft_id) throws Exception {
		dao.deleteDraft(draft_id);
		dao.deleteApproval(draft_id);
		dao.deleteReference(draft_id);
	}

	@Override
	public String insertApproval(List<String> approvalList) throws Exception {
		List<ApprovalVO> list = new ArrayList<ApprovalVO>();
		
		String draft_id = dao.currvalDraft()+"";
		
		for(int i=0; i<approvalList.size(); i++){
			System.out.println("결재자 아이디를 얻어보쟝" + i + " : " + approvalList.get(i));
			ApprovalVO approval = new ApprovalVO();
			approval.setDraft_id(draft_id);
			approval.setEmp_id(approvalList.get(i));
			list.add(approval);
		}
		
		for(int i=0; i<list.size(); i++){
			dao.insertApproval(list.get(i));
		}
		
		return draft_id;
	}

	@Override
	public String insertReference(List<String> referenceList) throws Exception {
		List<ReferenceVO> list = new ArrayList<ReferenceVO>();
		
		String draft_id = dao.currvalDraft()+"";
		
		for(int i=0; i<referenceList.size(); i++){
			System.out.println("결재자 아이디를 얻어보쟝" + i + " : " + referenceList.get(i));
			ReferenceVO reference = new ReferenceVO();
			reference.setDraft_id(draft_id);
			reference.setEmp_id(referenceList.get(i));
			list.add(reference);
		}
		
		for(int i=0; i<list.size(); i++){
			dao.insertReference(list.get(i));
		}
		
		return draft_id;
	}

	@Override
	public void draftOk(String draft_id) throws Exception {
		
		DraftVO draft = dao.selectDraft(draft_id);
		List<ApprovalVO> approvalList = dao.approvalListDraft(draft_id);
		
		for(int i=0; i<approvalList.size(); i++){
			if(approvalList.get(i).getConfirm().equals("NO")){
				if(approvalList.get(i).getEmp_id().equals(CommonService.getEmployeeId())){
					approvalList.get(i).setConfirm("OK");
					dao.updateApproval(approvalList.get(i));
				} else {
					System.out.println("같지않아 ");
				}
			} else {
				System.out.println("이미 결재했어용");
			}
		}
		
		boolean temp = true;
		
		for(int i=0; i<approvalList.size(); i++){
			if(approvalList.get(i).getConfirm().equals("NO")){
				temp = false;
			}
		}
		
		if(temp){
			draft.setDraft_state("OK");
		}
		
		dao.updateDraft(draft);
	}
	
	// draft_id 로 emp_id 리스트 뽑기
	@Override
	public List<String> selectApprovalDraft(String draft_id) throws Exception {
		return dao.selectApprovalDraft(draft_id);
	}
	

}
