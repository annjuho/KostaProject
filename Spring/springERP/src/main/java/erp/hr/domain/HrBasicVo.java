package erp.hr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HrBasicVo {
	@Getter @Setter
	private String basic_id;
	@Getter @Setter
	private String basic_type;
	@Getter @Setter
	private String basic_name;	
}
