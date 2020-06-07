package com.andrej.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.andrej.test.entities.BottleEntity;
import com.andrej.test.entities.OrderEntity;
import com.andrej.test.entities.UserEntity;
import com.andrej.test.repository.BottleRepository;
import com.andrej.test.repository.OrderRepository;
import com.andrej.test.service.SecurityServiceImpl;



@Controller
public class WebController {
	
	Logger logger = LoggerFactory.getLogger(WebController.class);
	Ddmenu dd = new Ddmenu();
	ObjectMapper mapper = new ObjectMapper();
	SecurityServiceImpl securityService;
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	@Autowired
	private BottleRepository bottleRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "index";
		}
	
	@GetMapping(value = "/userpage")
	public String userpage() {
		//String username = securityService.findLoggedInUsername();
		//System.out.println(username);
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
		OrderEntity order = new OrderEntity();
		//System.out.println(securityService.getLoggedInName());
		try {
			order = mapper.readValue(json_input, OrderEntity.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//order.setUsername(securityService.getLoggedInName());
		order.setOrder_date(LocalDate.now());
		orderRepo.save(order);
		return "order";
	}
	
	@GetMapping(value = "/allHistory")
	public String allHistory(Model model) {
		//String username = securityService.getLoggedInName();
		List<OrderEntity> listOfOrders = orderRepo.findByUsername("andrej");
		model.addAttribute("allHistory", listOfOrders);
		return "allHistory";
	}
	
	@GetMapping(value="/allHistory/{oid}")
	public String order_detail(Model model, @PathVariable Long oid) {
		List<BottleEntity> order_detail = bottleRepo.findByOrderid(oid, "andrej");
		model.addAttribute("order_detail", order_detail);
		model.addAttribute("order_id", oid);
		return "singleOrder";
	}
	
	//Kontroler za brisanje
	@GetMapping(value="allHistory/delete/{oid}")
	public String delete_order(@PathVariable Long oid) {
		orderRepo.deleteByIdAndUsername(oid, "andrej");
		return "redirect:/allHistory";
	}
	
	//(TODO) Kontroler za ponovno naročilo
	@GetMapping(value="allHistory/reorder/{oid}")
	public String reorder(@PathVariable Long oid) {
		return "redirect:/allHistory";
	}
	
}
