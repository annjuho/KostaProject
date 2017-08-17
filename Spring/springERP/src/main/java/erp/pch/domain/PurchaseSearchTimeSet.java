package erp.pch.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class PurchaseSearchTimeSet implements Serializable{
	@Getter @Setter private Timestamp start_date;
	@Getter @Setter private Timestamp end_date;
	@Getter @Setter private String customer_id;
	@Getter @Setter private String product_id;
	@Getter @Setter private String warehouse_id;
}
