package erp.common.message;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erp.common.domain.MessageVO;
import erp.common.service.MessageService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Message {
	
	@Inject
	private MessageService ms;
	
	@Test
	public void test() throws Exception{
		MessageVO vo = new MessageVO();
		vo.setContents("1");
		vo.setReceive_check("1");
		vo.setReceive_id("1");
		vo.setSend_id("1");
		vo.setTitle("1");
		ms.sendMessage(vo);
	}

}
