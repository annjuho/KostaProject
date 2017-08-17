package erp.pch.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PurchaseListView implements Serializable{
	@Getter @Setter	private String buy_id;
	@Getter @Setter	private String customer_name;
	@Getter @Setter	private String product_name;
	@Getter @Setter	private String buy_date;
	@Getter @Setter	private String warehouse_name;
	@Getter @Setter	private String pay_type;
	@Getter @Setter	private int buy_price;
	@Getter @Setter	private int buy_amount;
}
