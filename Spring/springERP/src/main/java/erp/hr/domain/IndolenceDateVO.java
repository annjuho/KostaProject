package erp.hr.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IndolenceDateVO {
	@Getter @Setter private String emp_id;
	@Getter @Setter private Date arrive_time;
	@Getter @Setter private Date leave_time;
	@Getter @Setter private Date day_info;
}
