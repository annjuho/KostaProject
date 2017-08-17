package erp.basic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import erp.basic.domain.Customer;
import erp.basic.persistence.BasicCustomerDAO;
import erp.common.domain.Criteria;
import erp.pch.domain.GetCustomer;
import erp.pch.domain.PurchaseListView;

@Service
public class BasicCustomerServiceImpl implements BasicCustomerService {
	
	@Inject
	private BasicCustomerDAO dao;
	
	@Override
	public void customerInsert(Customer customer) throws Exception {
		dao.customerInsert(customer);
	}
	@Override
	public void customerDelete(String customer_id) throws Exception {
		dao.customerDelete(customer_id);
	}	

	@Override
	public void customerUpdate(Customer customer) throws Exception {
		dao.customerUpdate(customer);
	}
	@Override
	public List<Customer> customerList() throws Exception {
		return dao.customerList();
	}
	@Override
	public List<Customer> getCustomer(String customer_id) throws Exception {
		return dao.getCustomer(customer_id);
	}
	@Override
	public List<Customer> listAll() throws Exception {
		return dao.listAll();
	}
	@Override
	public List<Customer> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

}
