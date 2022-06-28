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
			model.addAttribute("productSearch", new Product());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "products/list-products";
	}
	
	@GetMapping("{id}/view")
	public String viewProduct(Model model, @PathVariable("id") Integer id) {
		try {
			if(productService.existsById(id)) {
				Optional<Product> optional = productService.findById(id);
				model.addAttribute("product", optional.get());
			}
			else {
				return "redirect:/products";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "products/view-products";
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
	
	@GetMapping("{id}/edit")
	public String editProduct(Model model, @PathVariable("id") Integer id) {
		
		try {
			if(productService.existsById(id)) {
				Optional<Product> optional = productService.findById(id);
				model.addAttribute("product", optional.get());
			}
			else {
				return "redirect:/products";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "products/edit-product";
	}
	
	@PostMapping("{id}/update")
	public String updateProduct(Model model, @ModelAttribute("product") Product product ,@PathVariable("id") Integer id) {
		try {
			if(productService.existsById(id)) {
				productService.update(product);
			}
			else {
				return "redirect:/products";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/products";
	}
	
	@GetMapping("{id}/del")
	public String deleteProduct(Model model, @PathVariable("id") Integer id ) {
		try {
			if(productService.existsById(id)) {
				productService.deleteById(id);
			}
			else {
				return "redirect:/products";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/products";
	}
	
	@PostMapping("search")
	public String searchProduct(Model model, @ModelAttribute("productSearch") Product productSearch) {
		try {
			List<Product> products = productService.findByBrand(productSearch.getBrand());
			model.addAttribute("products", products);
			model.addAttribute("productSearch", new Product());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "products/list-products";
	}
}
