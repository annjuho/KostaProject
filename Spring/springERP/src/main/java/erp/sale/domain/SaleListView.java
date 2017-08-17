package erp.sale.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SaleListView {
	@Getter @Setter private String sell_id;
	@Getter @Setter private String customer_name;
	@Getter @Setter private String product_name;
	@Getter @Setter private Timestamp sell_date;
	@Getter @Setter private String warehouse_name;
	@Getter @Setter private String pay_type;
	@Getter @Setter private int sell_price;
	@Getter @Setter private int sell_amount;
}
