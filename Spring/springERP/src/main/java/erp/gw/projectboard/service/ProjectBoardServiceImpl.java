package erp.gw.projectboard.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.deptboard.domain.DeptScheduleVO;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.gw.projectboard.persistence.ProjectBoardDao;

@Service
public class ProjectBoardServiceImpl implements ProjectBoardService {

	@Inject
	private ProjectBoardDao dao;

	@Override
	public List<ProjectsVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<ProjectsVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<ProjectsVO> listSearchCriteria(Map<String, Object> map) throws Exception {
		return dao.listSearch(map);
	}

	@Override
	public int listSearchCount(String emp_id) throws Exception {
		return dao.listSearchCount(emp_id);
	}

	@Override
	public int allSearchCount(SearchCriteria cri) throws Exception {
		return dao.allSearchCount(cri);
	}

	@Override
	public String enameGet(String emp_id) throws Exception {
		return dao.enameGet(emp_id);
	}

	@Override
	public ProjectsVO read(int proj_id) throws Exception {
		return dao.read(proj_id);
	}

	@Override
	public void write(ProjectsVO project) throws Exception {
		dao.write(project);
	}

	@Override
	public void dsvoWrite(DeptScheduleVO dsvo) throws Exception {
		dao.dsvoWrite(dsvo);
	}

	@Override
	public void updateProj(ProjectsVO project) throws Exception {
		dao.updateProj(project);
	}

	@Override
	public void deleteProj(int proj_id) throws Exception {
		dao.deleteProj(proj_id);
		
	}

	@Override
	public List<ProjectsVO> allSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.allSearchCriteria(cri);
	}

	@Override
	public List<ProjectsVO> getAllPro() throws Exception {
		return dao.getAllPro();
	}
}