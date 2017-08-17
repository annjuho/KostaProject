package erp.basic.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import erp.basic.domain.Product;
import erp.basic.service.BasicProductService;

@RestController
@RequestMapping("/basic/product/*")
public class ProductJsonController {

	@Inject
	private BasicProductService service;
	
	/*품목 중복 체크 JSON - MJ*/
	@RequestMapping("/codeJson")
	public List<Product> productCodeJson(@RequestParam("searchKey") String searchKey) throws Exception{		
		return service.productCodeJson(searchKey);
	}
}
