package erp.odm.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.odm.domain.DeliveryList;
import erp.odm.domain.OrderList;
import erp.odm.persistence.OdmDao;

@Service
public class OdmServiceImpl implements OdmService {
   
   @Inject
   private OdmDao dao;

   @Transactional
   @Override
   public void orderInsert(OrderList order) throws Exception {
      int client_id = dao.clientMax();
      //int order_id = dao.orderMax();
      order.setClient_id("client_id_"+(client_id+1));
      //order.setOrder_id("order_id_"+(order_id+1));

      try {
         dao.clientInsert(order);
         dao.orderInsert(order);
      } catch (Exception e) {
         e.printStackTrace();
         TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      }

   }

   @Override
   public void orderDetailInsert(OrderList order) throws Exception {
      int detail_id = dao.orderDetailMax();
      order.setOrder_detail_id("order_detail_id_"+(detail_id+1));
      
      dao.orderDetailInsert(order);   
      
   }

//   @Override
//   public DeliveryList deliverySelect(String order_id) throws Exception {
//      return dao.deliverySelect(order_id);
//   }

   @Transactional
   @Override 
   public void deliveryInsert(String order_id, String delivery_state) throws Exception{

      System.out.println(order_id);
      System.out.println(delivery_state);
      
      DeliveryList dv = new DeliveryList();
      dv = dao.deliverySelect(order_id);
      
      int delivery_id = dao.deliveryMax();

      dv.setDelivery_id("delivery_id_"+(delivery_id+1));
      dv.setDelivery_state(delivery_state);
      dv.setAddressee(dv.getClient_name());
      dv.setAddressee_address(dv.getClient_address());

      try { 
         dao.deliveryInsert(dv);
         OrderList order = dao.selectOrder(order_id);
         System.out.println(order.getOrder_amount());
         System.out.println(order.getProduct_id());
         dao.sellAmountUpdate(order);
         dao.stockAmountUpdate(order);
      } catch (Exception e){
         e.printStackTrace();
         TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      }

   }

   @Override
   public List<DeliveryList> deliverylist() throws Exception {
      return dao.deliveryList();
   }
   
   
}