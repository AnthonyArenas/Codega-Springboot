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


import pe.edu.upc.Codega.business.crud.ClientService;
import pe.edu.upc.Codega.business.crud.ClothingService;
import pe.edu.upc.Codega.business.crud.OrderDetailService;
import pe.edu.upc.Codega.business.crud.OrderService;
import pe.edu.upc.Codega.business.crud.SaleService;
import pe.edu.upc.Codega.model.entity.Clothing;
import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Order;
import pe.edu.upc.Codega.model.entity.OrderDetail;
import pe.edu.upc.Codega.model.entity.Sale;
import pe.edu.upc.Codega.utils.UserAuthentication;


@Controller
@RequestMapping("/orders")
@SessionAttributes("{order}")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private UserAuthentication userAuthentication;
	
	
	@Autowired
	public ClothingService clothingService;
	
	public Integer idNew;
	
	
	
	@GetMapping("/list")
	public String listOrder(Model model) {
		if(userAuthentication.isAuthenticated()) {
			Integer id = userAuthentication.getIdSegment();
			try {				
				List<Order> orders= orderService.findByClient(id);
				model.addAttribute("orders", orders);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return "orders/list-orders";
		}
		return "orders/list-orders";
		
		
	}
	
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
		if(userAuthentication.isAuthenticated()) {
			Integer id = userAuthentication.getIdSegment();
				float total;
				try {
						
							
							Optional<Clothing> optional = clothingService.findById(idNew);
				            Optional<Client> optionalClient = clientService.findById(id);
				            order.setClient(optionalClient.get());
							orderService.create(order);
							OrderDetail orderDetail = new OrderDetail();
							model.addAttribute("orderDetail", orderDetail);
							Sale sale = new Sale();
							model.addAttribute("sale", sale);
							orderDetail.setOrder(order);
							orderDetail.setClothing(optional.get());
							total = optional.get().getPrice() * order.getQuantity();
							orderDetail.setTotal(total);
							orderDetailService.create(orderDetail);
							sale.setOrderDetail(orderDetail);
							saleService.create(sale);			
					 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return "redirect:/orders/list";
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