package erp.common.domain;

public class MessageCriteria extends Criteria{

	private String searchType;
	private String keyword;
	private String emp_id;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	@Override
	public String toString() {
		return "MessageCriteria [searchType=" + searchType + ", keyword=" + keyword + ", emp_id=" + emp_id + "]";
	}
}


