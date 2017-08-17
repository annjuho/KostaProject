package erp.acc.basic.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card implements Serializable {
	
	@Getter @Setter private int card_id;
	@Getter @Setter private String card_number;
	@Getter @Setter private	String card_name;
	@Getter @Setter private int account_id;
	@Getter @Setter private String type;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String use;
	@Getter @Setter private String remarks;
	@Getter @Setter private int diagnosis_number;

	
}
