package pe.edu.upc.Codega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Codega.business.crud.OrderDetailService;
import pe.edu.upc.Codega.model.entity.OrderDetail;


@Controller
@RequestMapping("/orderDetails")
@SessionAttributes("{orderDetail}")
public class OrderDetailController {
	
	@Autowired
	public OrderDetailService orderDetailService;
	

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
	
}
