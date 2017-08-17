package erp.acc.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erp.acc.basic.domain.NoteAllSearch;
import erp.acc.basic.domain.NoteAllSearchDateSet;
import erp.acc.basic.domain.Promissory;
import erp.acc.basic.service.SearchService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class NoteAllSearchTest {
	@Inject
	private SearchService service;
	/*@Test
	public void test() throws Exception {
		NoteAllSearchDateSet nas = new NoteAllSearchDateSet();
		nas.setEnd_date(Date.valueOf("2016-06-05"));
		nas.setStart_date(Date.valueOf("2016-05-05"));
		
		List<Promissory> list = service.promissoryNoteAll(nas);
		
		System.out.println(list);
	}*/

}
