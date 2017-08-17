package erp.gw.projectboard.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.deptboard.domain.DeptScheduleVO;
import erp.gw.projectboard.domain.ProjectsVO;

@Repository
public class ProjectBoardDaoImpl implements ProjectBoardDao {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.gw.mapper.pBoardMapper";
	
	@Override
	public List<ProjectsVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<ProjectsVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", null, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public int listSearchCount(String emp_id) throws Exception {
		return session.selectOne(namespace+".listSearchCount", emp_id);
	}

	@Override
	public int allSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".allSearchCount", cri);
	}

	@Override
	public List<ProjectsVO> listSearch(Map<String, Object> map) throws Exception {
		SearchCriteria cri = (SearchCriteria)map.get("cri");
		return session.selectList(namespace+".listSearch", map, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public List<ProjectsVO> allSearchCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".allSearchCriteria", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public String enameGet(String emp_id) throws Exception {
		return session.selectOne(namespace+".enameGet", emp_id);
	}

	@Override
	public ProjectsVO read(int proj_id) throws Exception {
		return session.selectOne(namespace + ".read", proj_id);
	}

	@Override
	public void write(ProjectsVO project) throws Exception {
		session.insert(namespace + ".writeProj", project);
	}

	@Override
	public void dsvoWrite(DeptScheduleVO dsvo) throws Exception {
		session.insert(namespace + ".dsvoWrite", dsvo);
	}
	
	@Override
	public void updateProj(ProjectsVO project) throws Exception {
		session.update(namespace + ".updateProj", project);
	}

	@Override
	public void deleteProj(int proj_id) throws Exception {
		session.delete(namespace + ".deleteProj", proj_id);
	}

	@Override
	public List<ProjectsVO> getAllPro() throws Exception {
		return session.selectList(namespace + ".getAllPro");
	}

}