package erp.odm.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.odm.domain.DeliveryList;
import erp.odm.domain.OrderList;

@Repository
public class OdmDaoImpl implements OdmDao {

	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.odm.mapper.odmMapper";

	@Override
	public int clientMax() throws Exception {
		return session.selectOne(namespace+".clientMax");
	}

	@Override
	public void clientInsert(OrderList order) throws Exception {
		session.insert(namespace+".clientInsert",order);
	}

	@Override
	public int orderMax() throws Exception {
		return session.selectOne(namespace+".orderMax");
	}
	
	@Override
	public void orderInsert(OrderList order) throws Exception {
		session.insert(namespace+".orderInsert", order);
	}

	@Override
	public int orderDetailMax() throws Exception {
		return session.selectOne(namespace+".orderDetailMax");
	}

	@Override
	public void orderDetailInsert(OrderList order) throws Exception {
		session.insert(namespace+".orderDetailInsert",order);
	}

	@Override
	public DeliveryList deliverySelect(String order_id) throws Exception {
		return session.selectOne(namespace+".deliverySelect", order_id);
	}

	@Override
	public int deliveryMax() throws Exception {
		return session.selectOne(namespace+".deliveryMax");
	}

	@Override
	public int deliveryInsert(DeliveryList dv) throws Exception {
		return session.insert(namespace+".deliveryInsert",dv);
	}

	@Override
	public List<DeliveryList> deliveryList() throws Exception {
		return session.selectList(namespace+".deliveryList");
	}

	@Override
	public OrderList selectOrder(String order_id) throws Exception {
		return session.selectOne(namespace+".selectOrder", order_id);
	}

	@Override
	public void sellAmountUpdate(OrderList order) throws Exception {
		session.update(namespace+".sellUpdate", order);
	}

	@Override
	public void stockAmountUpdate(OrderList order) throws Exception {
		session.update(namespace+".stockUpdate",order);
	}


}
