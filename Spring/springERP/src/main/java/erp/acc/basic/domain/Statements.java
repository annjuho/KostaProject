package erp.acc.basic.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Statements implements Serializable {

	@Getter @Setter private Date red_date;
	@Getter @Setter private String customer_name;
	@Getter @Setter private String statement_id;
	@Getter @Setter private int diagnosis_number;
	@Getter @Setter private int cash_id;
	@Getter @Setter private String note_id;
	@Getter @Setter private int card_id;
	@Getter @Setter private int sums;
	@Getter @Setter private int charge;
	@Getter @Setter private int total;
	@Getter @Setter private String state;
	@Getter @Setter private String typelist;
	@Getter @Setter private String remarks;
	
	
}
