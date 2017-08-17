package erp.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ProductGroup{
	@Getter @Setter
	private String pgroup_id;
	@Getter @Setter
	private String ptype;
	@Getter @Setter
	private String pgroup_name;
}
