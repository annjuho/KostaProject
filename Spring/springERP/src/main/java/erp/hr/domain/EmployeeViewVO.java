package erp.hr.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeViewVO implements Serializable{
	@Getter @Setter
	private String emp_id;
	@Getter @Setter
	private String e_name;
	@Getter @Setter
	private int e_age;
	@Getter @Setter
	private int e_sal;
	@Getter @Setter
	private String e_address;
	@Getter @Setter
	private String e_email;
	@Getter @Setter
	private String phone_number;
	@Getter @Setter
	private String dept_id;
	@Getter @Setter
	private String position_id;
	@Getter @Setter
	private String job_id;
	@Getter @Setter
	private String duty_id;
	@Getter @Setter
	private String e_pwd;
	@Getter @Setter
	private String dept_name;
	@Getter @Setter
	private String position_name;
	@Getter @Setter
	private String job_name;
	@Getter @Setter
	private String duty_name;
	@Setter
	private String e_hiredate;
	@Getter @Setter
	private String authorities;
	public String getE_hiredate() {
		return e_hiredate.substring(0,10);
	}
	
	
}
