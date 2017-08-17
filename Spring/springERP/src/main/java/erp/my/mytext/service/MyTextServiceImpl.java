package erp.my.mytext.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.my.mytext.persistence.MytextDao;

@Service
public class MyTextServiceImpl implements MyTextService {

	@Inject
	private MytextDao dao;
	
	@Override
	public String enameGet(String emp_id) throws Exception {
		return dao.enameGet(emp_id);
	}

	@Override
	public List<DeptBoardVO> getDeptBoardList(Map<String, Object> map) throws Exception {
		return dao.getDeptBoardList(map);
	}

	@Override
	public int deptBoardCount(String emp_id) throws Exception {
		return dao.deptBoardCount(emp_id);
	}

	@Override
	public List<ProjectsVO> getMyProjList(Map<String, Object> map) throws Exception {
		return dao.getMyProjList(map);
	}

	@Override
	public int myProjCount(String emp_id) throws Exception {
		return dao.myProjCount(emp_id);
	}

}
