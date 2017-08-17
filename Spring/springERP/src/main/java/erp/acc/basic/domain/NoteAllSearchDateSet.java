package erp.acc.basic.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class NoteAllSearchDateSet {
	@Getter @Setter private Date start_date;
	@Getter @Setter private Date end_date;
	@Getter @Setter private Date standard_date;
	@Getter @Setter private String dept_id;
	@Getter @Setter private String project_number;
	@Getter @Setter private String typelist;
	@Getter @Setter private String card_number;
}
