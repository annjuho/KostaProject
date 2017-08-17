package erp.common.domain;

import lombok.Setter;

import lombok.Getter;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FolderFileVO {
	@Getter @Setter private int file_id;
	@Getter @Setter private String emp_id;
	@Getter @Setter private String file_type;
	@Getter @Setter private String file_name;
	@Getter @Setter private int file_size;
	@Getter @Setter private Date file_date;
	@Getter @Setter private int down_amount;
	@Getter @Setter private String upload_file;
}
