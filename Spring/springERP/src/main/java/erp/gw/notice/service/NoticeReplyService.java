package erp.gw.notice.service;

import java.util.List;

import erp.gw.notice.domain.NoticeReplyVO;

public interface NoticeReplyService {
	public void reInsert(NoticeReplyVO reVO)throws Exception;
	public List<NoticeReplyVO> reList(int notice_id) throws Exception;
	public void reDelete(int re_id)throws Exception;
}
