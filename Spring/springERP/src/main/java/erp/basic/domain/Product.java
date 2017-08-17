package erp.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Product{
	@Getter @Setter
	private String product_id;
	@Getter @Setter
	private String product_name;
	@Getter @Setter
	private String pgroup_id;
	@Getter @Setter
	private int price_in;
	@Getter @Setter
	private int price_out;
	@Getter @Setter
	private String barcode;
	@Getter @Setter
	private String standard_id;
	@Getter @Setter
	private String made_in;
}
