package erp.pch.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class GetCustomer implements Serializable{
	@Getter @Setter
	private String customer_id;
	@Getter @Setter
	private String customer_name;
	@Getter @Setter
	private String repre_name;
	@Getter @Setter
	private String phone_number;
	@Getter @Setter
	private String customer_address;
	@Getter @Setter
	private String copy_bankbook;
	@Getter @Setter
	private String bankbook_check;
	@Getter @Setter
	private String customer_email;
	@Getter @Setter
	private String customer_fax;
	@Getter @Setter
	private String checkman;
}
