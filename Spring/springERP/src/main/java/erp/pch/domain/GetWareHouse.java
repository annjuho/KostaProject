package erp.pch.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class GetWareHouse implements Serializable{
	@Getter @Setter private String warehouse_id;
	@Getter @Setter private String warehouse_name;
	@Getter @Setter private String warehouse_loc;
}
