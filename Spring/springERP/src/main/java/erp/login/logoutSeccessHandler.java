package erp.login;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import erp.hr.domain.EmployeeVO;
import erp.login.persistence.LoginDao;

public class logoutSeccessHandler implements LogoutSuccessHandler {
	private String leave;

	@Inject
	private LoginDao dao;

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		leave = request.getParameter(leave);

		EmployeeVO emp = (EmployeeVO) auth.getPrincipal();
		String emp_id = emp.getEmp_id();
		
		String inTime   = new java.text.SimpleDateFormat("HH").format(new java.util.Date());
		int time = Integer.parseInt(inTime);
		

		if (leave != null) {
			if(time < 18){
				try {
					dao.halfAnnual(emp_id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				dao.leave(emp_id);
				dao.dateReset(emp_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("/login");
	}
}
