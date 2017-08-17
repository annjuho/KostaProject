package erp.basic.domain;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ListModelProduct {
	
	@Getter @Setter
	private List<ProductList> list;
	@Getter @Setter
	private int requestPage;
	@Getter @Setter
	private int totalPageCount;
	@Getter @Setter
	private int startPage;
	@Getter @Setter
	private int endPage;

	
	
}
