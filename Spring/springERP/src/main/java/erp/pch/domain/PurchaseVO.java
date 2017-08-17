package erp.pch.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseVO implements Serializable{
	@Getter	@Setter
	private String buy_id;
	@Getter	@Setter
	private String customer_id;
	@Getter	@Setter
	private String product_id;
	@Getter	@Setter
	private Timestamp buy_date;
	@Getter	@Setter
	private String warehouse_id;
	@Getter	@Setter
	private String pay_type;
	@Getter	@Setter
	private int buy_price;
	@Getter	@Setter
	private int buy_amount;
	@Getter	@Setter
	private String emp_id;
}
