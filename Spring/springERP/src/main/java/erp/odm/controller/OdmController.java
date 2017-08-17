package erp.odm.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import erp.odm.domain.DeliveryList;
import erp.odm.domain.OrderList;
import erp.odm.service.OdmService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("/odm/*")
public class OdmController {

	@Inject
	private OdmService service;

	@RequestMapping("/test")
	public String test(Model model) throws Exception {

		model.addAttribute("left", "odm/odm.jsp");
		model.addAttribute("contents", "odm/odmTest.jsp");

		return "/main";
	}

	@RequestMapping("/odm_collectForm")
	public String odm_collectForm(Model model) throws Exception {

		// Date date = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//
		// String day = sdf.format(date);
		//
		// System.out.println(day);
		//
		// model.addAttribute("day", day);
		model.addAttribute("left", "odm/odm.jsp");
		model.addAttribute("contents", "odm/odm_orderCollect.jsp");

		return "/main";
	}

	@RequestMapping("/orderCollect")
	public String orderCollect(@RequestParam(value = "checks", defaultValue = "godo") String checks, Model model)
			throws Exception {

		model.addAttribute("checks", checks);
		model.addAttribute("left", "odm/odm.jsp");
		model.addAttribute("contents", "odm/odm_orderList.jsp");

		return "/main";
	}

	@RequestMapping(value = "/orderListAdd", method = RequestMethod.POST)
	@ResponseBody
	public void orderListAdd(@RequestParam("orderList") String ol, @RequestParam("itemList") String il) throws Exception {

		System.out.println("컨트롤러");
		System.out.println("컨트롤러");
		System.out.println("컨트롤러");
		System.out.println(il);
		JSONArray orderArray = (JSONArray) JSONSerializer.toJSON(ol);
		JSONArray itemArray = (JSONArray) JSONSerializer.toJSON(il);
		
		for (int j = 0; j < orderArray.size(); j++) {
			OrderList order = new OrderList();
			// System.out.println(orderArray.getJSONObject(i).getString("order_date"));
			Timestamp order_date = Timestamp.valueOf(orderArray.getJSONObject(j).getString("order_date"));

			// System.out.println(order_date);
			order.setOrder_id(orderArray.getJSONObject(j).getString("order_id"));
			order.setOrder_date(order_date);
			order.setClient_name(orderArray.getJSONObject(j).getString("client_name"));
			order.setSettlement_price(Integer.parseInt(orderArray.getJSONObject(j).getString("settlement_price")));
			order.setClient_phonenumber(orderArray.getJSONObject(j).getString("client_phonenumber"));
			order.setAddressee(orderArray.getJSONObject(j).getString("addressee"));
			order.setClient_address(orderArray.getJSONObject(j).getString("addressee_address"));
			order.setInvoice_number(orderArray.getJSONObject(j).getString("invoice_number"));

			service.orderInsert(order);
		}
		for (int i = 0; i < itemArray.size(); i++) {
			OrderList order = new OrderList();

			order.setOrder_id(itemArray.getJSONObject(i).getString("order_id"));
			order.setOrder_amount(Integer.parseInt(itemArray.getJSONObject(i).getString("order_amount")));
			order.setProduct_id(itemArray.getJSONObject(i).getString("product_id"));
			order.setStatus(itemArray.getJSONObject(i).getString("status"));

			service.orderDetailInsert(order);
		}
	}
	
	@RequestMapping("/odm_deliveryList")
	private String deliveryList(Model model) throws Exception{
		List<DeliveryList> list = service.deliverylist();
		for(int i=0;i<list.size();i++){
			System.out.println("delivery_id : ");
			System.out.println(list.get(i).getDelivery_id());
		}
		
		model.addAttribute("list", list);
		model.addAttribute("left", "odm/odm.jsp");
		model.addAttribute("contents", "odm/odm_deliveryList.jsp");

		return "/main";
	}
	
	@RequestMapping(value="/deliveryInsert",method=RequestMethod.POST)
	@ResponseBody
	private void deleveryInsert(@RequestParam("order_id") String order_id, @RequestParam("status") String delivery_state) throws Exception{
		
		System.out.println(order_id);
		System.out.println(delivery_state);
		System.out.println("deliverycontroller");

		service.deliveryInsert(order_id, delivery_state);

	}

}

