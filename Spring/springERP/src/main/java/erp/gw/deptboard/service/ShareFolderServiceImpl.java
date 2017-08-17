package erp.gw.deptboard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.common.domain.FolderFileVO;
import erp.gw.deptboard.persistence.ShareFolderDao;

@Service
public class ShareFolderServiceImpl implements ShareFolderService {

	@Inject
	private ShareFolderDao dao;
	
	@Override
	public void insertFile(FolderFileVO folderFile) throws Exception {
		dao.insertFile(folderFile);
	}

	@Override
	public List<FolderFileVO> listFile() throws Exception {
		return dao.listFile();
	}

	@Override
	public FolderFileVO selectFile(int file_id) throws Exception {
		return dao.selectFile(file_id);
	}

	@Override
	public void deleteFile(int file_id) throws Exception {
		dao.deleteFile(file_id);
	}

	@Override
	public String getEname(String emp_id) throws Exception {
		return dao.getEname(emp_id);
	}
}
