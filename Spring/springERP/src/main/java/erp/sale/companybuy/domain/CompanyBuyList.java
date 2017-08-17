package erp.sale.companybuy.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CompanyBuyList implements Serializable{
	@Getter @Setter private String cbuy_id;
	@Getter @Setter private String customer_name;
	@Getter @Setter private String product_name;
	@Getter @Setter private Timestamp cbuy_date;
	@Getter @Setter private String warehouse_name;
	@Getter @Setter private String pay_type;
	@Getter @Setter private int cbuy_priceout;
	@Getter @Setter private int cbuy_amount;
}
