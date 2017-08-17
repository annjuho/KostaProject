package erp.acc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import erp.acc.basic.domain.MoneyPlanTimeSet;
import erp.acc.basic.service.MoneyPlanService;

@RestController
@RequestMapping("/accounting/moneyCal/*")
public class MoneyCalController {
	@Inject
	private MoneyPlanService service;
	
	@RequestMapping(value="/getAll", method=RequestMethod.POST)
	public List<MoneyPlanTimeSet> moneyAllList() throws Exception {
		return service.moneyAllList();
	}
}
