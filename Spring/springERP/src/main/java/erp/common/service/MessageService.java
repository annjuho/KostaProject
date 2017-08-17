package erp.common.service;

import java.util.List;

import erp.common.domain.MessageCriteria;
import erp.common.domain.MessageVO;
import erp.common.domain.MessageViewVO;
import erp.hr.domain.EmployeeViewVO;

public interface MessageService {

	List<MessageViewVO> getMessageList(MessageCriteria cri);

	int messageListCount(MessageCriteria cri);

	void messageDelete(String string);

	List<EmployeeViewVO> getEmpID(String e_name);

	void sendMessage(MessageVO vo);

	MessageViewVO getMessage(int message_id);

	int getNotReadCnt(String emp_id);
}
