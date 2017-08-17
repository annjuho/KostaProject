package erp.common.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.common.domain.MessageCriteria;
import erp.common.domain.MessageVO;
import erp.common.domain.MessageViewVO;
import erp.common.persistence.CommonDAO;
import erp.hr.domain.EmployeeVO;
import erp.hr.domain.EmployeeViewVO;

@Service
public class MessageServiceImpl implements MessageService {
	@Inject
	private CommonDAO dao;

	@Override
	public List<MessageViewVO> getMessageList(MessageCriteria cri) {
		return dao.getMessageList(cri);
	}

	@Override
	public int messageListCount(MessageCriteria cri) {
		return dao.messageListCount(cri);
	}

	@Override
	public void messageDelete(String string) {
		dao.msgDel(string);
	}

	@Override
	public List<EmployeeViewVO> getEmpID(String e_name) {
		return dao.getEmpID(e_name);
	}

	@Override
	public void sendMessage(MessageVO vo) {
		dao.sendMessage(vo);
	}

	@Override
	public MessageViewVO getMessage(int message_id) {
		MessageViewVO msgViewVO = dao.getMessage(message_id);
		dao.updateState(message_id);
		
		return msgViewVO;
	}

	@Override
	public int getNotReadCnt(String emp_id) {
		return dao.NotReadCnt(emp_id);
	}	
}
