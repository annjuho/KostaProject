package erp.pch.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

public class Slip implements Serializable{
	@Getter @Setter private long slip_amount;
	@Getter @Setter private String customer_id;
	@Getter @Setter private String product_id;
	@Getter @Setter private String slip_id;
	@Getter @Setter private Date slip_date;
}
