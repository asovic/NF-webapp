package com.andrej.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.andrej.test.entities.BottleEntity;
import com.andrej.test.entities.OrderEntity;
import com.andrej.test.entities.UserEntity;
import com.andrej.test.repository.AromeRepo;
import com.andrej.test.repository.BottleRepository;
import com.andrej.test.repository.Ddmenu;
import com.andrej.test.repository.OrderRepository;
import com.andrej.test.repository.UserRepository;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	BottleRepository bottleRepo;
	
	@Autowired
	Ddmenu menu;
	
	@GetMapping
	public String adminPage() {
		return "admin/admin";
	}
	
	@GetMapping(value="/allUsers")
	public String allUsers(Model model) {
		List<UserEntity> listOfAllUsers = userRepo.findAll();
		model.addAttribute("allUsers", listOfAllUsers);
		return "admin/allUsers";
	}
	
	@GetMapping(value="/allUsers/{username}")
	public String ordersByUsers(Model model, @PathVariable String username) {
		List<OrderEntity> userDetail = orderRepo.findByUsername(username);
		model.addAttribute("ordersByUser", userDetail);
		return "admin/allOrdersByUser";
	}
	
	@GetMapping(value="/allUsers/{username}/{id}")
	public String orderDetails(Model model, @PathVariable("id") Long id, @PathVariable("username") String name) {
		List<BottleEntity> order_detail = bottleRepo.findByOrderid(id, name);
		model.addAttribute("order_detail", order_detail);
		model.addAttribute("oid", id);
		return "admin/orderDetail";
	}
	
	public String toggleUsers() {
		return null;
	}
	
	@GetMapping(value="/unfilledOrders")
	public String unfilledOrders(Model model) {
		List<OrderEntity> unfilled = orderRepo.findUnfilled();
		model.addAttribute("unfilled_orders", unfilled);
		return "/admin/unfilledOrders";
	}
	
	@GetMapping(value="/markCompleted/{oid}")
	public String setOrderStatus(@PathVariable Long oid) {
		orderRepo.markAsFilled(oid);
		return "redirect:/admin/unfilledOrders";
	}
	@GetMapping(value="addFlavor")
	public String addFlavor(Model model) {
		model.addAttribute("addFlavor", new AromeRepo());
		return "/admin/addFlavor";
	}
	
	@PostMapping(value="addFlavor")
	public String addFlavor(@RequestBody AromeRepo aroma) {
		menu.addAroma(aroma.getAroma());
		return null;
	}
}
