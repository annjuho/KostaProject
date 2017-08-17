package erp.acc.basic.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Diagnosiss implements Serializable {

	@Getter @Setter private String diagnosis_number;
	@Getter @Setter private String diagnosis_name;
	@Getter @Setter private String searchkey;
	@Getter @Setter private String sort;
	@Getter @Setter private String diagnosis_type;
	@Getter @Setter private String use;
	@Getter @Setter private String remarks;

}
