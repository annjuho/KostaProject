package erp.acc.basic.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.acc.basic.domain.Promissory;

@Repository
public class PromissoryDAOImpl implements PromissoryDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "erp.acc.mapper.PromissoryMapper";

	@Override
	public void promissoryInsert(Promissory promissory) throws Exception {
		session.insert(namespace + ".promissoryInsert", promissory);

	}

	@Override
	public void promissoryUpdate(Promissory promissory) throws Exception {
		session.update(namespace + ".promissoryUpdate", promissory);

	}

	@Override
	public void promissoryDelete(String note_id) throws Exception {
		session.update(namespace + ".promissoryDelete", note_id);

	}

	@Override
	public List<Promissory> promissoryList() throws Exception {
		return session.selectList(namespace + ".promissoryList");
	}

	@Override
	public void promissorygiveUpdate(Promissory promissory) throws Exception {
		session.update(namespace+".promissorygiveUpdate", promissory);
		
	}

}
