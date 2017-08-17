package erp.common.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageViewVO implements Serializable{
	@Getter @Setter
	private int message_id;
	@Getter @Setter
	private String	send_id;
	@Getter @Setter
	private String	receive_id;
	@Getter @Setter
	private String	title; 
	@Getter @Setter
	private String	contents;
	@Getter @Setter
	private String	receive_check;
	@Getter @Setter
	private String	e_name;
}
