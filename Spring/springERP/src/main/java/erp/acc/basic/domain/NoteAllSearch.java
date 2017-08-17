package erp.acc.basic.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
public class NoteAllSearch implements Serializable{
	@Getter @Setter private String start_date;
	@Getter @Setter private String end_date;
	@Getter @Setter private String standard_date;
	@Getter @Setter private String dept_id;
	@Getter @Setter private String project_number;
	@Getter @Setter private String typelist;
	@Getter @Setter private String card_number;
	
}
