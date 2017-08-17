package erp.acc.basic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import erp.acc.basic.domain.Diagnosiss;

public interface DiagnosissService {

	public void diagnosisInsert(Diagnosiss diagnosiss) throws Exception;

	public void diagnosisUpdate(Diagnosiss diagnosiss) throws Exception;

	public void diagnosisDelete(String diagnosis_number) throws Exception;

	public ArrayList<Map<String, Object>> getJsonMap() throws Exception;

	public List<Diagnosiss> diagnosisList() throws Exception;
}
