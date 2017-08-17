package erp.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class SaleProductChart {
	@Getter @Setter
	private String product_name;
	@Getter @Setter
	private int total_price;
}
