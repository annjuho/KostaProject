package erp.gw.notice.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.gw.notice.domain.NoticeReplyVO;

@Repository
public class NoticeReplyDaoImpl implements NoticeReplyDao {
	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.gw.mapper.noticeMapper";
	
	@Override
	public void reInsert(NoticeReplyVO reVO) throws Exception {
		session.insert(namespace + ".reInsert", reVO);
	}

	@Override
	public List<NoticeReplyVO> reList(int notice_id) throws Exception {
		return session.selectList(namespace + ".reList", notice_id);
	}

	@Override
	public void reDelete(int re_id) throws Exception {
		session.delete(namespace+".reDelete", re_id);
	}

}
