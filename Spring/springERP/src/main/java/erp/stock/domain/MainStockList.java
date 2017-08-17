package erp.stock.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class MainStockList {
	@Getter @Setter private String product_name;
	@Getter @Setter private int stock_amount;
	@Getter @Setter private String inout_type;
	@Getter @Setter private int inout_amount;
	@Getter @Setter private Date inout_date;
}
