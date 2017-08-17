package erp.pch.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class PurchaseSearch implements Serializable{
	@Getter @Setter private String start_date;
	@Getter @Setter private String end_date;
	@Getter @Setter private String customer_id;
	@Getter @Setter private String product_id;
	@Getter @Setter private String warehouse_id;
}
