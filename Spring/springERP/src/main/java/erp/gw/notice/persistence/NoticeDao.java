package erp.gw.notice.persistence;

import java.util.List;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.notice.domain.NoticeVO;

public interface NoticeDao {
	  public List<NoticeVO> listAll() throws Exception;
	  public List<NoticeVO> listCriteria(Criteria cri) throws Exception;
	  public int countPaging(Criteria cri)throws Exception;
	  public int listSearchCount(SearchCriteria cri)throws Exception;
	  public List<NoticeVO> listSearch(SearchCriteria cri)throws Exception;
	  public String enameGet(String emp_id) throws Exception;
	  public NoticeVO read(int notice_id) throws Exception;
	  public void write(NoticeVO notice)throws Exception;
	  public void updateNotice(NoticeVO notice)throws Exception;
	  public void deleteNotice(int notice_id)throws Exception;
}