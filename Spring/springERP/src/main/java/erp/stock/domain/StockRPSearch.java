package erp.stock.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class StockRPSearch {
	@Getter @Setter
	private String customer_id;
	@Getter @Setter
	private String product_id;
	@Getter @Setter
	private Date start_date;
	@Getter @Setter
	private Date end_date;
	@Getter @Setter
	private String customer_name;
	@Getter @Setter
	private String product_name;
	@Getter @Setter
	private Date inout_date;
	@Getter @Setter
	private int inout_amount;
	@Getter @Setter
	private String inout_type;
	@Getter @Setter
	private int stock_amount;

}
