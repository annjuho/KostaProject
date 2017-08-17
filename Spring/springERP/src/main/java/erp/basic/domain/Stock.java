package erp.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Stock {

	@Getter @Setter
	private String product_id;
	@Getter @Setter
	private int stock_amount;
	@Getter @Setter
	private String warehouse_id;
	@Getter @Setter
	private String stock_loc;
}
