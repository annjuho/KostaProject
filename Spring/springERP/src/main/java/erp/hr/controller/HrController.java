package erp.hr.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.FileCopyUtils;

import erp.common.service.CommonService;
import erp.hr.domain.EmployeeVO;
import erp.hr.domain.EmployeeViewVO;
import erp.hr.domain.HrBasicVo;
import erp.hr.domain.HrDeptVO;
import erp.hr.domain.HrDutyVO;
import erp.hr.domain.HrJobVO;
import erp.hr.domain.HrPositionVO;
import erp.hr.domain.IndolenceInfoVO;
import erp.hr.domain.PageMakerHR;
import erp.hr.domain.SearchCriteriaHR;
import erp.hr.service.HrService;

@Controller
@RequestMapping("/hr")
public class HrController {
	private static final Logger logger = LoggerFactory.getLogger(HrController.class);

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	private HrService service;

	@Inject
	private CommonService common;
	
	// left메뉴
	@RequestMapping(value = "/hr_basic")
	public String hr_basic(Model model) {
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/hr_basic.jsp");
		return "/main";
	}

/*	@RequestMapping(value = "/emp")
	public String emp(Model model) {
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/emp_info.jsp");
		return "/main";
	}*/
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String empList(@ModelAttribute("cri") SearchCriteriaHR cri, Model model) throws Exception{
		List<EmployeeViewVO> list =  service.empLIst(cri);
		for(EmployeeViewVO vo : list){
			System.out.println(vo.getE_hiredate());
		}
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/emp_info.jsp");
		model.addAttribute("list", service.empLIst(cri));
		
		PageMakerHR pageMaker = new PageMakerHR();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.empListSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		return "/main";
	}
	@RequestMapping(value = "/indol", method=RequestMethod.GET)
	public String indol(@ModelAttribute("cri") SearchCriteriaHR cri, Model model) throws Exception{
		
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/indol_info.jsp");
		model.addAttribute("list", service.indolInfoLIst(cri));
		
		PageMakerHR pageMaker = new PageMakerHR();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.indolInfoSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		return "/main";
	}

	@RequestMapping(value = "/indol_request", method=RequestMethod.GET)
	public String indol_request(@ModelAttribute("cri") SearchCriteriaHR cri, Model model) {
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/indol_request.jsp");
		model.addAttribute("list", service.indolRequestLIst(cri));
		
		PageMakerHR pageMaker = new PageMakerHR();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.indolRequestSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		return "/main";
	}

	@RequestMapping(value = "/authority")
	public String jubis(Model model) {
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/authority.jsp");
		return "/main";
	}

	// emp관련 메뉴 삽입접근
	@RequestMapping(value = "/emp/insert")
	public String empInsert(Model model) {
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/insert_emp.jsp");
		return "/main";
	}
	
	//emp 수정 접근
	@RequestMapping(value = "/emp/emp_update")
	public String empUpdate(@ModelAttribute("cri") SearchCriteriaHR cri, @RequestParam("emp_id") String emp_id, Model model) {
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/update_emp.jsp");
		model.addAttribute("employeeVO", service.getEmp(emp_id));
		return "/main";
	}
	
	//indol_info 수정 접근
	@RequestMapping(value = "/indol_info/indol_info_update")
	public String indol_info_update(@ModelAttribute("cri") SearchCriteriaHR cri, @RequestParam("emp_id") String emp_id, Model model) {
		model.addAttribute("left", "hr/hr.jsp");
		model.addAttribute("contents", "hr/IndolInfoUpdate.jsp");
		model.addAttribute("indolInfoVO", service.getIndolInfo(emp_id));
		return "/main";
	}

	// 인사 기초등록 중복검사
	@RequestMapping(value = "/hr_basic/basic_check", method = RequestMethod.POST)
	public ResponseEntity<String> basic_check(@RequestBody HrBasicVo vo) {
		ResponseEntity<String> entity = null;
		int count = 0;
		String type = vo.getBasic_type();
		if (type.equals("dept")) {
			try {
				count = service.deptCheck(vo.getBasic_id());
				if (count > 0) {
					entity = new ResponseEntity<String>("no", HttpStatus.OK);
				} else {
					entity = new ResponseEntity<String>("ok", HttpStatus.OK);
				}
			} catch (Exception e) {
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}

		} else if (type.equals("position")) {
			try {
				count = service.positionCheck(vo.getBasic_id());
				if (count > 0) {
					entity = new ResponseEntity<String>("no", HttpStatus.OK);
				} else {
					entity = new ResponseEntity<String>("ok", HttpStatus.OK);
				}
			} catch (Exception e) {
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else if (type.equals("job")) {
			try {
				count = service.jobCheck(vo.getBasic_id());
				if (count > 0) {
					entity = new ResponseEntity<String>("no", HttpStatus.OK);
				} else {
					entity = new ResponseEntity<String>("ok", HttpStatus.OK);
				}
			} catch (Exception e) {
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else if (type.equals("duty")) {
			try {
				count = service.dutyCheck(vo.getBasic_id());
				if (count > 0) {
					entity = new ResponseEntity<String>("no", HttpStatus.OK);
				} else {
					entity = new ResponseEntity<String>("ok", HttpStatus.OK);
				}
			} catch (Exception e) {
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			try {
				count = service.empCheck(vo.getBasic_id());
				if (count > 0) {
					entity = new ResponseEntity<String>("no", HttpStatus.OK);
				} else {
					entity = new ResponseEntity<String>("ok", HttpStatus.OK);
				}
			} catch (Exception e) {
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		return entity;
	}

	// 인사 기초등록 등록
	@RequestMapping(value = "/hr_basic/basic_insert", method = RequestMethod.POST)
	public String basicInsert(HrBasicVo vo) throws Exception {
		service.basicInsert(vo);
		return "redirect:/hr/hr_basic";
	}

	// 인사 기초등록 수정
	@RequestMapping(value = "/hr_basic/basic_update", method = RequestMethod.POST)
	public String basicUpdate(HrBasicVo vo) throws Exception {
		service.basicUpdate(vo);
		return "redirect:/hr/hr_basic";
	}

	// 인사 기초등록 부서출력
	@RequestMapping(value = "/hr_basic/dept", method = RequestMethod.GET)
	public ResponseEntity<List<HrDeptVO>> deptlist() {
		ResponseEntity<List<HrDeptVO>> entity = null;
		try {
			entity = new ResponseEntity<List<HrDeptVO>>(service.listDept(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	// 인사 기초등록 직급출력
	@RequestMapping(value = "/hr_basic/position", method = RequestMethod.GET)
	public ResponseEntity<List<HrPositionVO>> positionlist() {
		ResponseEntity<List<HrPositionVO>> entity = null;
		try {
			entity = new ResponseEntity<List<HrPositionVO>>(service.listPosition(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	// 인사 기초등록 직무출력
	@RequestMapping(value = "/hr_basic/job", method = RequestMethod.GET)
	public ResponseEntity<List<HrJobVO>> joblist() {
		ResponseEntity<List<HrJobVO>> entity = null;
		try {
			entity = new ResponseEntity<List<HrJobVO>>(service.listJob(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	// 인사 기초등록 직책출력
	@RequestMapping(value = "/hr_basic/duty", method = RequestMethod.GET)
	public ResponseEntity<List<HrDutyVO>> list() {
		ResponseEntity<List<HrDutyVO>> entity = null;
		try {
			entity = new ResponseEntity<List<HrDutyVO>>(service.listDuty(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	// 인사 기초등록 삭제
	@RequestMapping(value = "/hr_basic/basic_del", method = RequestMethod.POST)
	public String basicDel(HrBasicVo vo) throws Exception {
		service.basicDel(vo);
		return "redirect:/hr/hr_basic";
	}

	@RequestMapping(value = "/emp/emp_insert", method = RequestMethod.POST)
	public String emp_insert(EmployeeVO vo) throws IllegalStateException, IOException {
		String pass = common.passwordEncoder(vo.getPassword());
		
		vo.setE_pwd(pass);
		
		if (vo.getUploadFile() != null) {
			MultipartFile file = vo.getUploadFile();
			logger.info("originalName: " + file.getOriginalFilename());
			logger.info("size: " + file.getSize());
			logger.info("conetentType: " + file.getContentType());

			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());	
			vo.setE_profile_pic(savedName);
		}
		service.empInsert(vo);
		return "redirect:/hr/emp";
	}
	@RequestMapping(value = "/emp/update", method = RequestMethod.POST)
	public String emp_update(@ModelAttribute("cri") SearchCriteriaHR cri, EmployeeVO vo ,RedirectAttributes rtts) throws IllegalStateException, IOException {
		if (vo.getUploadFile() != null) {
			MultipartFile file = vo.getUploadFile();
			logger.info("originalName: " + file.getOriginalFilename());
			logger.info("size: " + file.getSize());
			logger.info("conetentType: " + file.getContentType());
			
			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
			vo.setE_profile_pic(savedName);
			
			EmployeeVO picvo = service.getEmp(vo.getEmp_id());
			String fpath = "C:\\Users\\pado\\git\\Spring\\springERP\\src\\main\\webapp\\resources\\hr\\images"+picvo.getE_profile_pic();
			File delFile = new File(fpath);
			delFile.delete();	
		}
		else{
			EmployeeVO pvo = service.getEmp(vo.getEmp_id());
			vo.setE_profile_pic(pvo.getE_profile_pic());
		}
		service.empUpdate(vo);
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		return "redirect:/hr/emp";
	}

	private String uploadFile(String originalName, byte[] fileData) throws IOException {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	//직원 삭제
	@RequestMapping("/emp/emp_delete")
	public String emp_delete(@ModelAttribute("cri") SearchCriteriaHR cri, @RequestParam("array") String[] array, RedirectAttributes rtts) throws Exception{
		for(int i=0;i<array.length;i++){
			try {
				EmployeeVO vo =service.getEmp(array[i]);
				if(vo.getE_profile_pic()!=null){
					String fpath = "C:\\Users\\pado\\git\\Spring\\springERP\\src\\main\\webapp\\resources\\hr\\images"+vo.getE_profile_pic();
					File delFile = new File(fpath);
					delFile.delete();
				}						
				service.empDelete(array[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/hr/emp";
	}
	
	
	//indol_info 업데이트
	@RequestMapping(value = "/indol/update_indol", method = RequestMethod.POST)
	public String indol_update(@ModelAttribute("cri") SearchCriteriaHR cri, IndolenceInfoVO vo ,RedirectAttributes rtts) throws IllegalStateException, IOException {
		service.indolUpdate(vo);
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		return "redirect:/hr/indol";
	}
	//직원 삭제
	@RequestMapping("/indol_request/request_approve")
	public String indol_request_approve(@ModelAttribute("cri") SearchCriteriaHR cri, @RequestParam("array") String[] array, RedirectAttributes rtts) throws Exception{
		// ResponseEntity<String> entity = null;
		for(int i=0;i<array.length;i++){
			try {
				service.indolApprove(array[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		rtts.addAttribute("page", cri.getPage());
		rtts.addAttribute("perPageNum", cri.getPerPageNum());
		rtts.addAttribute("searchType", cri.getSearchType());
		rtts.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/hr/indol_request";
	}
	
	@RequestMapping(value = "/emp/emp_print", method = RequestMethod.GET)
	public String emp_print(Model model) throws Exception{
		model.addAttribute("list", service.FullempLIst());
		return "hr/emp_print";
	}
	
	@RequestMapping(value="/emp/showPic", method = RequestMethod.POST)
	public ResponseEntity<EmployeeVO> showPic(@RequestBody EmployeeVO vo){
		ResponseEntity<EmployeeVO> entity = null;
		try{
			vo = service.getEmp(vo.getEmp_id());
			vo.makeFullPath();
			entity = new ResponseEntity<EmployeeVO>(vo, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping(value="/autorityDept", method = RequestMethod.POST)
	public String autorityDept(@RequestParam("dept_id") String dept_id, @RequestParam("authorities") String authorities){
		service.autorityDept(dept_id, authorities);
		return "redirect:/hr/authority";
	}
	
	@RequestMapping(value="/autorityPerson", method = RequestMethod.POST)
	public String autorityPerson(@RequestParam("emp_id") String emp_id, @RequestParam("authorities") String authorities){
		service.autorityEmp(emp_id, authorities);
		return "redirect:/hr/authority";
	}
}


