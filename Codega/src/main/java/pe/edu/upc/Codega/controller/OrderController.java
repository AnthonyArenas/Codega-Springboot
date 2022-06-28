package pe.edu.upc.Codega.controller;


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

import pe.edu.upc.Codega.business.crud.ClothingService;
import pe.edu.upc.Codega.business.crud.OrderDetailService;
import pe.edu.upc.Codega.business.crud.OrderService;
import pe.edu.upc.Codega.model.entity.Clothing;
import pe.edu.upc.Codega.model.entity.Order;
import pe.edu.upc.Codega.model.entity.OrderDetail;


@Controller
@RequestMapping("/orders")
@SessionAttributes("{order}")
public class OrderController {
	
	@Autowired
	public OrderService orderService;
	
	@Autowired
	public OrderDetailService orderDetailService;
	
	
	@Autowired
	public ClothingService clothingService;
	
	public Integer idNew;
	

	
	@GetMapping("{id}/new")
	public String newOrder(Model model, @PathVariable("id") Integer id) {

					
		try {
			if(clothingService.existsById(id)) {
				Order order = new Order();
				model.addAttribute("order", order);
				Optional<Clothing> optional = clothingService.findById(id);
				model.addAttribute("clothing", optional.get());
				idNew =optional.get().getId();			
					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "orders/new-order";
	}
	
	@PostMapping("savenew")
	public String saveOrder(Model model, @ModelAttribute("order") Order order) {
		float total;
		try {
		
				Optional<Clothing> optional = clothingService.findById(idNew);
				orderService.create(order);
				OrderDetail orderDetail = new OrderDetail();
				model.addAttribute("orderDetail", orderDetail);
				orderDetail.setOrder(order);
				orderDetail.setClothing(optional.get());
				total = optional.get().getPrice() * order.getQuantity();
				orderDetail.setTotal(total);
				orderDetailService.create(orderDetail);
				
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/orderDetails";
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
