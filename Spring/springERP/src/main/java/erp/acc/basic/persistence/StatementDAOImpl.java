package erp.acc.basic.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.acc.basic.domain.Statements;

@Repository
public class StatementDAOImpl implements StatementDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.acc.mapper.Statement";
	//전표 전체 조회
	@Override
	public List<Statements> StatementAllList() throws Exception {
		return session.selectList(namespace+".StatementAllList");
	}
	//현금매출
	@Override
	public List<Statements> StatementAllSalesList() throws Exception {
		return session.selectList(namespace+".StatementAllSalesList");
	}
	/*//어음매출
	@Override
	public List<Statements> StatementPromissorySalesList() throws Exception {
		return session.selectList(namespace+".StatementPromissorySalesList");
	}*/
	//현급매입
	@Override
	public List<Statements> StatementAllPurchaseList() throws Exception {
		return session.selectList(namespace+".StatementAllPurchaseList");
	}
	/*//어음매입
	@Override
	public List<Statements> StatementPromissoryPurchaseList() throws Exception {
		return session.selectList(namespace+".StatementPromissoryPurchaseList");
	}*/
	
	
	

}
