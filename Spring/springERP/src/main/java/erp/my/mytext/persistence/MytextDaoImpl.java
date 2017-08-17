package erp.my.mytext.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.my.mytext.domain.MyDeptTextCriteria;

@Repository
public class MytextDaoImpl implements MytextDao {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.mypage.mapper.myTextMapper";
	
	@Override
	public String enameGet(String emp_id) throws Exception {
		return session.selectOne(namespace+".enameGet", emp_id);
	}

	@Override
	public List<DeptBoardVO> getDeptBoardList(Map<String, Object> map) throws Exception {
		MyDeptTextCriteria deptCri = (MyDeptTextCriteria)map.get("deptCri");
		return  session.selectList(namespace+".getDeptBoardList", map, new RowBounds(deptCri.getPageStart(), deptCri.getDeptPerPageNum()));
	}

	@Override
	public int deptBoardCount(String emp_id) throws Exception {
		return session.selectOne(namespace+".deptBoardCount", emp_id);
	}

	@Override
	public List<ProjectsVO> getMyProjList(Map<String, Object> map) throws Exception {
		Criteria cri = (Criteria)map.get("projCri");
		return  session.selectList(namespace+".getMyProjList", map, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int myProjCount(String emp_id) throws Exception {
		return session.selectOne(namespace+".myProjCount", emp_id);
	}

}
