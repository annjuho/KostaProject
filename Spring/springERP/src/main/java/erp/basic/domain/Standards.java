package erp.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Standards{
	@Getter @Setter
	private String standard_id;
	@Getter @Setter
	private String standard_name;
}
