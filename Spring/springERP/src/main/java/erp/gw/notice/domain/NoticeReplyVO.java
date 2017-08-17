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
public class NoticeReplyVO {
	@Getter @Setter private int nreply_id;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String nreply_content;
	@Getter @Setter private Date nreply_date;
	@Getter @Setter private int nreply_ref;
	@Getter @Setter private int nreply_step;
	@Getter @Setter private int nreply_level;
	@Getter @Setter private int notice_id;
}
