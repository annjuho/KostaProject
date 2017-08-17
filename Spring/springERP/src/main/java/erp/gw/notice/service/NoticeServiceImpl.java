package erp.gw.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.notice.domain.NoticeVO;
import erp.gw.notice.persistence.NoticeDao;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.gw.projectboard.persistence.ProjectBoardDao;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	private NoticeDao dao;

	@Override
	public List<NoticeVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<NoticeVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<NoticeVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public String enameGet(String emp_id) throws Exception {
		return dao.enameGet(emp_id);
	}

	@Override
	public NoticeVO read(int notice_id) throws Exception {
		return dao.read(notice_id);
	}

	@Override
	public void write(NoticeVO notice) throws Exception {
		//dao
		dao.write(notice);
	}

	@Override
	public void updateNotice(NoticeVO notice) throws Exception {
		dao.updateNotice(notice);
	}

	@Override
	public void deleteNotice(int notice_id) throws Exception {
		dao.deleteNotice(notice_id);
		
	}
}