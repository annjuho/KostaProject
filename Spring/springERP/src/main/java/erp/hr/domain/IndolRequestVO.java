package erp.hr.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IndolRequestVO implements Serializable{
	@Getter @Setter private int indol_request_id;
	@Getter @Setter private String emp_id;
	@Getter @Setter private Date start_nowork_date;
	@Getter @Setter private Date end_nowork_date;
	@Getter @Setter private String request_type;
	@Getter @Setter private Date request_date;
	@Getter @Setter private String approve;
}
