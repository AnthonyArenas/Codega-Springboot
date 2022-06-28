package pe.edu.upc.Codega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Codega.business.crud.SaleService;
import pe.edu.upc.Codega.model.entity.Sale;

@Controller
@RequestMapping("/sales")
@SessionAttributes("{sale}")
public class SaleController {
	
	@Autowired
	public SaleService saleService;
	

	@GetMapping
	public String getSales(Model model) {
		
		try {
			List<Sale> sales= saleService.getAll();
			model.addAttribute("sales", sales);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sales/list-sales";
	}
	
}
