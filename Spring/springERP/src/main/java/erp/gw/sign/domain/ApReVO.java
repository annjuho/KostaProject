package erp.gw.sign.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApReVO {
	@Getter @Setter private List<String> approval_emp;
	@Getter @Setter private List<String> reference_emp;
}
