package erp.gw.deptboard.persistence;

import java.util.List;

import erp.common.domain.FolderFileVO;

public interface ShareFolderDao {
	public void insertFile(FolderFileVO folderFile) throws Exception;
	public List<FolderFileVO> listFile() throws Exception;
	public FolderFileVO selectFile(int share_folder_id) throws Exception;
	public void deleteFile(int share_folder_id) throws Exception;
	public String getEname(String emp_id) throws Exception;
}
