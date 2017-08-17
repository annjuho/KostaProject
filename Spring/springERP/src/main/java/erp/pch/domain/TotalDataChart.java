package erp.pch.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class TotalDataChart implements Serializable{
	@Getter @Setter private String name;
	@Getter @Setter private long[] data;	
}
