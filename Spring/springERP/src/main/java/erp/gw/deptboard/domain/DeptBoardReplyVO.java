package erp.gw.deptboard.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeptBoardReplyVO {
	@Getter @Setter private int dept_breply_id;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String dept_breply_content;
	@Getter @Setter private Date dept_breply_date;
	@Getter @Setter private int dept_breply_ref;
	@Getter @Setter private int dept_breply_step;
	@Getter @Setter private int dept_breply_level;
	@Getter @Setter private int dept_board_id;
	@Getter @Setter private String dept_id;
}
