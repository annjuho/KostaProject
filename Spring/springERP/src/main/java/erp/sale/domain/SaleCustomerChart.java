package erp.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class SaleCustomerChart {
	@Getter @Setter
	private String customer_name;
	@Getter @Setter
	private int total;
}
