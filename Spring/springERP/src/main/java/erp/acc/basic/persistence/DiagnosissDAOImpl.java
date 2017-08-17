package erp.acc.basic.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.acc.basic.domain.Diagnosiss;

@Repository
public class DiagnosissDAOImpl implements DiagnosissDAO {

	@Inject SqlSession session;
	
	private static String namespace = "erp.acc.mapper.Diagnosis";
	
	@Override
	public void diagnosisInsert(Diagnosiss diagnosiss) throws Exception {
		session.insert(namespace+".diagnosisInsert", diagnosiss);
		
	}

	@Override
	public void diagnosisUpdate(Diagnosiss diagnosiss) throws Exception {
		session.update(namespace+".diagnosisUpdate", diagnosiss);
		
	}

	@Override
	public void diagnosisDelete(String diagnosis_number) throws Exception {
		session.delete(namespace+".diagnosisDelete");
		
	}

	@Override
	public List<Diagnosiss> diagnosisList() throws Exception {
		return session.selectList(namespace+".diagnosisList");
	}

	@Override
	public ArrayList<Map<String, Object>> getJsonMap() throws Exception {
		return ((ArrayList)session.selectList(namespace+".getJsonMap"));
		
	}

}
