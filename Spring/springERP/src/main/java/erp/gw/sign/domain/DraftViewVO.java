package erp.gw.sign.domain;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DraftViewVO {
	@Getter @Setter private String draft_id;
	@Getter @Setter private String draft_title;
	@Getter @Setter private String draft_content;
	@Getter @Setter private String draft_type;
	@Getter @Setter private Date draft_date;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String e_name;
	@Getter @Setter private String draft_state;
	@Getter @Setter private List<String> approval;
	@Getter @Setter private List<String> reference;
}
