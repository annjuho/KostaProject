package erp.hr.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IndolenceInfoVO implements Serializable{
	@Getter @Setter private String emp_id;
	@Getter @Setter private int lateness;
	@Getter @Setter private int vacation;
	@Getter @Setter private int half_annual;
	@Getter @Setter private int absence;
	@Getter @Setter private int annual;
}
