package com.andrej.test;

import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WebController {
	
	Logger logger = LoggerFactory.getLogger(WebController.class);
	Ddmenu dd = new Ddmenu();
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private BaseDao dao;

	@GetMapping(value = "/userpage")
	public String userpage() {
		return "userpage";
		}

	
	@GetMapping(value = "/order")
	public String order() {
		return "order";
		}
	
	@RequestMapping(value = "/newOrder", method = RequestMethod.GET)
	public String show(Model model) {
		List<String> dd_aroma = dd.getArome();
		List<String> dd_nic = dd.getNic();
		model.addAttribute("dd_aroma", dd_aroma);
		model.addAttribute("dd_nic", dd_nic);
		return "newOrder";
	}
	
	@RequestMapping(value = "/order/", method = RequestMethod.POST, consumes="application/json")
	public String save_order(@RequestBody String json_input) {
		Order order = new Order();
		try {
			order = mapper.readValue(json_input, Order.class);
			List<Bottle> obj_out = order.getBottle();
			for (Bottle obj : obj_out) {
				System.out.println("Aroma: " + obj.getAroma());
				System.out.println("Nic: " + obj.getNic());
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.save(order);
		return "order";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "index";
		}
}
