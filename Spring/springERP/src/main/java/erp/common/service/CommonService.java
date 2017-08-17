package erp.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import erp.hr.domain.EmployeeVO;


@Service
public class CommonService {
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	// 시큐리티에서 현재 로그인한사람 emp_id 불러오는것
	public static String getEmployeeId(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String emp_id = "";
		if(principal != null && principal instanceof EmployeeVO){
			emp_id = ((EmployeeVO)principal).getEmp_id();
		}
		return emp_id;
	}

	// 현재 로그인 사람 dept_id
	public static String getDeptId(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String dept_id = "";
		if(principal != null && principal instanceof EmployeeVO){
			dept_id = ((EmployeeVO)principal).getDept_id();
		}
		return dept_id;
	}
	
	// 비밀번호 변경시 암호화
	public String passwordEncoder(String pass){
		return passEncoder.encode(pass);
	}
}
