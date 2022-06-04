package pe.edu.upc.Codega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Codega.business.crud.ProductService;
import pe.edu.upc.Codega.model.entity.Product;

@Controller
@RequestMapping("/products")
@SessionAttributes("{product}")
public class ProductController {
	
	@Autowired ProductService productService;
	
	@GetMapping
	public String listProducts(Model model) {
		try {
			List<Product> products = productService.getAll();
			model.addAttribute("products", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "products/list-products";
	}
	
	@GetMapping("new")
	public String newProduct(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		return "products/new-product";
	}
	
	@PostMapping("savenew")
	public String saveProduct(Model model, @ModelAttribute("product") Product product) {
		
		try {
			Product productSaved=productService.create(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/products";
		
	}
	
}
