package erp.odm.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class OrderList {

	@Getter @Setter
	private String order_id;
	@Getter @Setter
	private String client_id;
	@Getter @Setter
	private String client_name;
	@Getter @Setter
	private Timestamp order_date;
	@Getter @Setter
	private int settlement_price;
	@Getter @Setter
	private String order_detail_id;
	@Getter @Setter
	private String product_id;
	@Getter @Setter
	private int order_amount;
	@Getter @Setter
	private String client_phonenumber;
	@Getter @Setter
	private String addressee;
	@Getter @Setter
	private String client_address;
	@Getter @Setter
	private String invoice_number;
	@Getter @Setter
	private String status;
	
}
