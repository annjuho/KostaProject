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
public class DeptBoardVO {
	@Getter @Setter private int dept_board_id;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String dept_board_title;
	@Getter @Setter private String dept_board_content;
	@Getter @Setter private Date dept_board_date;
	@Getter @Setter private int dept_board_hit;
	@Getter @Setter private String dept_board_file;
	@Getter @Setter private String dept_id;
}
