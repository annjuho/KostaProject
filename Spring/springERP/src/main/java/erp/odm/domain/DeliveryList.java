package erp.odm.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class DeliveryList {

	@Getter @Setter
	private String delivery_id;
	@Getter @Setter
	private String order_id;
	@Getter @Setter
	private String addressee;
	@Getter @Setter
	private String addressee_address;
	@Getter @Setter
	private String client_name;
	@Getter @Setter
	private String client_address;
	@Getter @Setter
	private String delivery_state;
	
}
