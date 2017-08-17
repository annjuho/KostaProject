package erp.gw.notice.service;

import java.util.List;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.notice.domain.NoticeVO;
import erp.gw.projectboard.domain.ProjectsVO;

public interface NoticeService {
	   public List<NoticeVO> listAll()throws Exception;
	   public List<NoticeVO> listCriteria(Criteria cri)throws Exception;
	   public int listCountCriteria(Criteria cri)throws Exception;
	   public List<NoticeVO> listSearchCriteria(SearchCriteria cri)throws Exception;
	   public int listSearchCount(SearchCriteria cri) throws Exception;
	   public String enameGet(String emp_id) throws Exception;
	   public NoticeVO read(int notice_id)throws Exception;
	   public void write(NoticeVO notice)throws Exception;
	   public void updateNotice(NoticeVO notice)throws Exception;
	   public void deleteNotice(int notice_id)throws Exception;
}