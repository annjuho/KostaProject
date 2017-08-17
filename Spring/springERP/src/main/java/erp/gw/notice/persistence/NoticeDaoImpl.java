package erp.gw.notice.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.notice.domain.NoticeVO;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.gw.mapper.noticeMapper";
	
	@Override
	public List<NoticeVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<NoticeVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", null, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".listSearchCount", cri);
	}

	@Override
	public List<NoticeVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public String enameGet(String emp_id) throws Exception {
		return session.selectOne(namespace+".enameGet", emp_id);
	}

	@Override
	public NoticeVO read(int notice_id) throws Exception {
		return session.selectOne(namespace + ".read", notice_id);
	}

	@Override
	public void write(NoticeVO notice) throws Exception {
		session.insert(namespace + ".writeNotice", notice);
	}

	@Override
	public void updateNotice(NoticeVO notice) throws Exception {
		session.update(namespace + ".updateNotice", notice);
	}

	@Override
	public void deleteNotice(int notice_id) throws Exception {
		session.delete(namespace + ".deleteNotice", notice_id);
	}

}