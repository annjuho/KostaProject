package erp.acc.basic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.acc.basic.domain.Promissory;
import erp.acc.basic.persistence.PromissoryDAO;

@Service
public class PromissoryServiceImpl implements PromissoryService {

	@Inject
	private PromissoryDAO dao;
	
	@Override
	public void promissoryInsert(Promissory promissory) throws Exception {
		dao.promissoryInsert(promissory);

	}

	@Override
	public void promissoryUpdate(Promissory promissory) throws Exception {
		dao.promissoryUpdate(promissory);

	}

	@Override
	public void promissoryDelete(String note_id) throws Exception {
		dao.promissoryDelete(note_id);

	}

	@Override
	public List<Promissory> promissoryList() throws Exception {
		return dao.promissoryList();
	}

	@Override
	public void promissorygiveUpdate(Promissory promissory) throws Exception {
		dao.promissorygiveUpdate(promissory);
		
	}

}
