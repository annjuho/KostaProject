package erp.gw.notice.domain;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO {
	@Getter @Setter private int notice_id;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String notice_title;
	@Getter @Setter private String notice_content;
	@Getter @Setter private Date notice_date;
	@Getter @Setter private int notice_hit;
}
