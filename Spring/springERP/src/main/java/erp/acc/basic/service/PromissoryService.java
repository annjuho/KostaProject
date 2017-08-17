package erp.acc.basic.service;

import java.util.List;

import erp.acc.basic.domain.Promissory;


public interface PromissoryService {
	
	public void promissoryInsert(Promissory promissory) throws Exception;

	public void promissoryUpdate(Promissory promissory) throws Exception;

	public void promissoryDelete(String note_id) throws Exception;

	public List<Promissory> promissoryList() throws Exception;

	public void promissorygiveUpdate(Promissory promissory)throws Exception;
}