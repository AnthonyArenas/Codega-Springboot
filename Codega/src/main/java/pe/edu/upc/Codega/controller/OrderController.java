package pe.edu.upc.Codega.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Codega.business.crud.OrderService;
import pe.edu.upc.Codega.model.entity.Order;

@Controller
@RequestMapping("/orders")
@SessionAttributes("{order}")
public class OrderController {
	
	@Autowired
	public OrderService orderService;
	
	@GetMapping
	public String listOrders(Model model) {
		
		try {
			List<Order> orders= orderService.getAll();
			model.addAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "orders/list-orders";
	}
	
	@GetMapping("new")
	public String newOrder(Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		return "orders/new-order";
	}
	
	@PostMapping("savenew")
	public String saveOrder(Model model, @ModelAttribute("order") Order order) {
		
		try {
			 orderService.create(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/orders";
	}
	
	@GetMapping("{id}/edit")
	public String editOrder(Model model, @PathVariable("id") Integer id) {
		
		try {
			if(orderService.existsById(id)) {
				Optional<Order> optional = orderService.findById(id);
				model.addAttribute("order", optional.get());
			}
			else {
				return "redirect:/orders";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "orders/edit-order";
		
	}
	
	@PostMapping("{id}/update")
	public String updateOrder(Model model, @ModelAttribute("order") Order order, @PathVariable("id") Integer id) {
		try {
			if(orderService.existsById(id)) {
				orderService.update(order);
			}
			else {
				return "redirect:/orders";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/orders";
	}
	
	@GetMapping("{id}/del")
	public String deleteOrder(Model model, @PathVariable("id") Integer id) {
		
		try {
			if(orderService.existsById(id)) {
				orderService.deleteById(id);
			}
			else {
				return "redirect:/orders";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/orders";
		
	}

}
