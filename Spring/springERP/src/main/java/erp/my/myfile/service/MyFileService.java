package erp.my.myfile.service;

import java.util.List;

import erp.common.domain.FolderFileVO;

public interface MyFileService {
	public void insertFile(FolderFileVO folderFile) throws Exception;
	public List<FolderFileVO> listFile() throws Exception;
	public FolderFileVO selectFile(int share_folder_id) throws Exception;
	public void deleteFile(int share_folder_id) throws Exception;
}
