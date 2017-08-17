package erp.common.persistence;

import java.util.List;

import erp.common.domain.MessageCriteria;
import erp.common.domain.MessageVO;
import erp.common.domain.MessageViewVO;
import erp.hr.domain.EmployeeVO;
import erp.hr.domain.EmployeeViewVO;

public interface CommonDAO {

	List<MessageViewVO> getMessageList(MessageCriteria cri);

	int messageListCount(MessageCriteria cri);

	void msgDel(String string);

	List<EmployeeViewVO> getEmpID(String e_name);

	void sendMessage(MessageVO vo);

	MessageViewVO getMessage(int message_id);

	int NotReadCnt(String emp_id);

	void updateState(int message_id);

}
