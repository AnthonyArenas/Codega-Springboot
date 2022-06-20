package pe.edu.upc.Codega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/orderDetails")
@SessionAttributes("{orderDetail}")
public class OrderDetailController {
	
	@Autowired
	public OrderDetailService orderDetailService;
	
	@Autowired
	public OrderService orderService;
	
	@Autowired
	public ProductService productService;
	
	@GetMapping
	public String getOrderDetails(Model model) {
		
		try {
			List<OrderDetail> orderDetails= orderDetailService.getAll();
			model.addAttribute("orderDetails", orderDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "orderDetails/list-orderDetails";
	}
	
	/*@GetMapping("confirm")
	public String confirmOrderDetail(Model model) {
		OrderDetail orderDetail = new OrderDetail();
		model.addAttribute("orderDetail", orderDetail);
		
		try {
			List<Product> products = productService.getAll();
			model.addAttribute("products", products);
			
			List<Order> orders = orderService.getAll();
			model.addAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "orders/confirm-order";
	}*/

	/*@PostMapping("savenew")
	public String saveOrderDetail(Model model) {
		
		
		return "";
	}*/
}
