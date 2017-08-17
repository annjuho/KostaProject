package erp.pch.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

public class PurchaseExcelUp implements Serializable{
	@Getter @Setter private String buy_id;
	@Getter @Setter	private String customer_name;
	@Getter @Setter	private String product_name;
	@Getter @Setter	private Date buy_date;
	@Getter @Setter	private String warehouse_name;
	@Getter @Setter	private String pay_type;
	@Getter @Setter	private int buy_price;
	@Getter @Setter	private int buy_amount;
}
