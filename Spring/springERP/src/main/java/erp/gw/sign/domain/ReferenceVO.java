package erp.gw.sign.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReferenceVO {
	@Getter @Setter private String draft_id;
	@Getter @Setter private String emp_id;
}
