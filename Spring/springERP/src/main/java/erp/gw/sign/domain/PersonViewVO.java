package erp.gw.sign.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonViewVO implements Serializable{
	@Getter @Setter private String emp_id;
	@Getter @Setter private String e_name;
	@Getter @Setter private String e_email;
	@Getter @Setter private String dept_name;
	@Getter @Setter private String position_name;
	@Getter @Setter private String job_name;
	@Getter @Setter private String duty_name;
}
