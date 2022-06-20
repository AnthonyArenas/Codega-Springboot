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

import pe.edu.upc.Codega.business.crud.OrderDetailService;
import pe.edu.upc.Codega.business.crud.OrderService;
import pe.edu.upc.Codega.business.crud.ProductService;
import pe.edu.upc.Codega.model.entity.Order;
import pe.edu.upc.Codega.model.entity.OrderDetail;
import pe.edu.upc.Codega.model.entity.Product;

@Controller
@RequestMapping("/orders")
@SessionAttributes("{order}")
public class OrderController {
	
	@Autowired
	public OrderService orderService;
	
	@Autowired
	public OrderDetailService orderDetailService;
	
	@Autowired
	public ProductService productService;
	
	public Integer idNuevo;
	

	@GetMapping
	public String listOrders(Model model) {//en mi trabajo final no necesitare un list orden
		
		try {
			List<Order> orders= orderService.getAll();
			model.addAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "orders/list-orders";
	}
	
	/*@GetMapping("new")
	public String newOrder(Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		return "orders/new-order";
	}*/
	

	
	@GetMapping("{id}/new")
	public String addProductoToOrder(Model model, @PathVariable("id") Integer id) {

					
		try {
			if(productService.existsById(id)) {
				Order order = new Order();
				model.addAttribute("order", order);
				Optional<Product> optional = productService.findById(id);
				model.addAttribute("product", optional.get());
				idNuevo=optional.get().getId();			
					
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
		
				Optional<Product> optional = productService.findById(idNuevo);
				orderService.create(order);
				OrderDetail orderDetail = new OrderDetail();
				model.addAttribute("orderDetail", orderDetail);
				orderDetail.setOrder(order);
				orderDetail.setProduct(optional.get());
				total = optional.get().getPrice() * order.getQuantity();
				orderDetail.setTotal(total);
				orderDetailService.create(orderDetail);
				idNuevo=0;
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/orderDetails";
	}
	
	/*@PostMapping("savenew")
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
		
	}*/

}