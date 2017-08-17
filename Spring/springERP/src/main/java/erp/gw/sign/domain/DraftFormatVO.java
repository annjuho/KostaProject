package erp.gw.sign.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DraftFormatVO {
	@Getter @Setter private String draft_format_id;
	@Getter @Setter private String draft_format_title;
	@Getter @Setter private String draft_format_content;
	@Getter @Setter private String draft_format_type;
}
