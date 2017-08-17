package erp.gw.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.gw.notice.domain.NoticeReplyVO;
import erp.gw.notice.persistence.NoticeReplyDao;

@Service
public class NoticeReplyServiceImpl implements NoticeReplyService {

	@Inject
	NoticeReplyDao dao;
	
	@Override
	public void reInsert(NoticeReplyVO reVO) throws Exception {
		dao.reInsert(reVO);
	}

	@Override
	public List<NoticeReplyVO> reList(int notice_id) throws Exception {
		return dao.reList(notice_id);
	}

	@Override
	public void reDelete(int re_id) throws Exception {
		dao.reDelete(re_id);
	}

}
