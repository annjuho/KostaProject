package erp.odm.service;

import java.util.List;

import erp.odm.domain.DeliveryList;
import erp.odm.domain.OrderList;

public interface OdmService {

	public void orderInsert(OrderList order) throws Exception;

	public void orderDetailInsert(OrderList order) throws Exception;

	public void deliveryInsert(String order_id, String delivery_state) throws Exception;

	public List<DeliveryList> deliverylist() throws Exception;


}
