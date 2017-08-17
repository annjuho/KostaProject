package erp.gw.deptboard.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.common.domain.FolderFileVO;

@Repository
public class ShareFolderDaoImpl implements ShareFolderDao{
	
	private static String namespace ="springERP.gw.mapper.shareFolderMapper";

	@Inject
	private SqlSession session;
	
	// 파일 업로드  - 보람
	@Override
	public void insertFile(FolderFileVO folderFile) throws Exception {
		session.insert(namespace + ".insertFile", folderFile);
	}

	// 파일 리스트 불러오기 - 보람
	@Override
	public List<FolderFileVO> listFile() throws Exception {
		return session.selectList(namespace + ".listFile");
	}
	
	// 파일 하나의 정보 불러오기 - 보람
	@Override
	public FolderFileVO selectFile(int file_id) throws Exception {
		return session.selectOne(namespace + ".selectFile", file_id);
	}

	// 파일 삭제하기 - 보람
	@Override
	public void deleteFile(int file_id) throws Exception {
		session.delete(namespace + ".deleteFile", file_id);
	}

	@Override
	public String getEname(String emp_id) throws Exception {
		return session.selectOne(namespace + ".getEname", emp_id);
	}

}
