package erp.acc.basic.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountAllViewDateSet {

	@Getter @Setter private String customer_id;
	@Getter @Setter private String customer_name;
	@Getter @Setter private int cash_id;
	@Getter @Setter private String note_id;
	@Getter @Setter private String typelist;
	@Getter @Setter private String state;
	@Getter @Setter private String remarks;
	@Getter @Setter private int sums;
	@Getter @Setter private int total;
	@Getter @Setter private Date red_date;
	@Getter @Setter private String emp_id;
	@Getter @Setter private int sal;
	@Getter @Setter private int empcount;
	@Getter @Setter private int transportation;
	@Getter @Setter private int postage;
	@Getter @Setter private int supplies;
	@Getter @Setter private int premium;
	@Getter @Setter private int costtotal;
}
