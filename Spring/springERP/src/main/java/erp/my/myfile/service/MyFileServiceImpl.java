package erp.my.myfile.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.common.domain.FolderFileVO;
import erp.my.myfile.persistence.MyFileDao;

@Service
public class MyFileServiceImpl implements MyFileService {

	@Inject
	private MyFileDao dao;
	
	@Override
	public void insertFile(FolderFileVO folderFile) throws Exception {
		dao.insertFile(folderFile);
	}

	@Override
	public List<FolderFileVO> listFile() throws Exception {
		return dao.listFile();
	}

	@Override
	public FolderFileVO selectFile(int share_folder_id) throws Exception {
		return dao.selectFile(share_folder_id);
	}

	@Override
	public void deleteFile(int share_folder_id) throws Exception {
		dao.deleteFile(share_folder_id);
	}
}
