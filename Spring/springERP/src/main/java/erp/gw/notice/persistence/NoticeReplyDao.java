package erp.gw.notice.persistence;

import java.util.List;

import erp.gw.notice.domain.NoticeReplyVO;

public interface NoticeReplyDao {
	public void reInsert(NoticeReplyVO reVO)throws Exception;
	public List<NoticeReplyVO> reList(int notice_id) throws Exception;
	public void reDelete(int re_id) throws Exception;
}
