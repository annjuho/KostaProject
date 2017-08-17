package erp.gw.projectboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectTeamVO {
	@Getter @Setter private int proj_id;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String dept_id;
	@Getter @Setter private int proj_role;
}
