package erp.my.mytext.service;

import java.util.List;
import java.util.Map;

import erp.gw.deptboard.domain.DeptBoardVO;
import erp.gw.projectboard.domain.ProjectsVO;

public interface MyTextService {
	public String enameGet(String emp_id) throws Exception;

	public List<DeptBoardVO> getDeptBoardList(Map<String, Object> map)throws Exception;
	public int deptBoardCount(String emp_id) throws Exception;
	
	public List<ProjectsVO> getMyProjList(Map<String, Object> map)throws Exception;
	public int myProjCount(String emp_id)throws Exception;
}
