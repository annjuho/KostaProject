package erp.gw.deptboard.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeptScheduleVO {
	@Getter @Setter private int dept_schedule_id;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String schedule_name;
	@Getter @Setter private Date start_schedule_date;
	@Getter @Setter private Date end_schedule_date;
	@Getter @Setter private String schedule_content;
	@Getter @Setter private int proj_id;
	@Getter @Setter private String dept_id;
}
