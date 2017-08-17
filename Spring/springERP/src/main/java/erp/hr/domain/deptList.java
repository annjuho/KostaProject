package erp.hr.domain;

import java.io.Serializable;

public class deptList implements Serializable{
	private String dept_id;
	private String dept_name;
	
	public deptList() {
		super();
	}
	public deptList(String dept_id, String dept_name) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
	}
	public String getdept_id() {
		return dept_id;
	}
	public void setdept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getdept_name() {
		return dept_name;
	}
	public void setdept_name(String dept_name) {
		this.dept_name = dept_name;
	}
}
