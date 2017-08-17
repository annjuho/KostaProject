package erp.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class SaleGoodsDataXml {
	@Getter @Setter
	private String pgroup_name;
	@Getter @Setter
	private String product_name;
	@Getter @Setter
	private String product_id;
	@Getter @Setter
	private int price_out;
	@Getter @Setter
	private int sell_amount;
}
