package erp.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class StockList {

	@Getter @Setter
	private String product_id;
	@Getter @Setter
	private String product_name;
	@Getter @Setter
	private String stock_amount;
	@Getter @Setter
	private String warehouse_name;
	@Getter @Setter
	private String warehouse_loc;
	
}
