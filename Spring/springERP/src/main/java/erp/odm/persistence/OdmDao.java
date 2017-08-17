package erp.odm.persistence;

import java.util.List;

import erp.odm.domain.DeliveryList;
import erp.odm.domain.OrderList;

public interface OdmDao {

	public void orderInsert(OrderList order) throws Exception;

	public int clientMax() throws Exception;

	public void clientInsert(OrderList order) throws Exception;

	public int orderMax() throws Exception;

	public int orderDetailMax() throws Exception;

	public void orderDetailInsert(OrderList order) throws Exception;

	public DeliveryList deliverySelect(String order_id) throws Exception;

	public int deliveryMax() throws Exception;

	public int deliveryInsert(DeliveryList dv) throws Exception;

	public List<DeliveryList> deliveryList() throws Exception;

	public OrderList selectOrder(String order_id) throws Exception;

	public void sellAmountUpdate(OrderList order) throws Exception;

	public void stockAmountUpdate(OrderList order) throws Exception;

}
