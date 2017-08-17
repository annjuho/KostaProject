package erp.basic.persistence;

import java.util.List;

import erp.basic.domain.Customer;
import erp.common.domain.Criteria;
import erp.pch.domain.PurchaseListView;

public interface BasicCustomerDAO {

	public void customerInsert(Customer customer)throws Exception;
	public void customerUpdate(Customer customer)throws Exception;
	public void customerDelete(String customer_id)throws Exception;
	public List<Customer> customerList()throws Exception;
	public List<Customer> getCustomer(String customer_id)throws Exception;
	public List<Customer> listAll() throws Exception;
	public List<Customer> listCriteria(Criteria cri) throws Exception;
	public int countPaging(Criteria cri) throws Exception;
}
