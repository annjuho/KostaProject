package erp.gw.deptboard.service;

import java.util.List;

import erp.common.domain.FolderFileVO;

public interface ShareFolderService {
	public void insertFile(FolderFileVO folderFile) throws Exception;
	public List<FolderFileVO> listFile() throws Exception;
	public FolderFileVO selectFile(int file_id) throws Exception;
	public void deleteFile(int file_id) throws Exception;
	public String getEname(String emp_id) throws Exception;
}
