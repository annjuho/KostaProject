package erp.gw.projectboard.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectsVO {
	@Getter @Setter private int proj_id;
	@Getter @Setter private String proj_name;
	@Getter @Setter private String proj_content;
	@Getter @Setter private int proj_period;
	@Getter @Setter private Date proj_start_date;
	@Getter @Setter private Date proj_end_date;
	@Getter @Setter private String emp_id;
	@Getter @Setter private int sums;
	@Getter @Setter private int account_id;
	@Getter @Setter private String account_number;
	@Getter @Setter private String remarks;
}