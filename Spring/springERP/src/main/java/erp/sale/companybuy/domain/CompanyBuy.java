package erp.sale.companybuy.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class CompanyBuy {
	@Getter @Setter private String cbuy_id;
	@Getter @Setter private String customer_id;
	@Getter @Setter private String product_id;
	@Getter @Setter private Timestamp cbuy_date;
	@Getter @Setter private String warehouse_id;
	@Getter @Setter private String pay_type;
	@Getter @Setter private int cbuy_priceout;
	@Getter @Setter private int cbuy_amount;
}
