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

import pe.edu.upc.Codega.business.crud.CategoriesService;
import pe.edu.upc.Codega.model.entity.Categories;


@Controller
@RequestMapping("/categoriess")
@SessionAttributes("{categories}")
public class CategoriesController {
	
	@Autowired CategoriesService categoriesService;
	
	@GetMapping
	public String listProducts(Model model) {
		try {
			List<Categories> categoriess = categoriesService.getAll();
			model.addAttribute("categoriess", categoriess);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "categoriess/list-categoriess";
	}
	
	
	@GetMapping("new")
	public String newCategories(Model model) {
		
		Categories categories = new Categories();
		model.addAttribute("categories", categories);
		return "categoriess/new-categories";
	}
	
	@PostMapping("savenew")
	public String saveCategories(Model model, @ModelAttribute("categories") Categories categories) {
		
		try {
			Categories categoriesSaved=categoriesService.create(categories);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/categoriess";
		
	}
	
	@GetMapping("{id}/edit")
	public String editCategories(Model model, @PathVariable("id") Integer id) {
		
		try {
			if(categoriesService.existsById(id)) {
				Optional<Categories> optional = categoriesService.findById(id);
				model.addAttribute("categories", optional.get());
			}
			else {
				return "redirect:/categoriess";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "categoriess/edit-categories";
	}
	
	@PostMapping("{id}/update")
	public String updateCategories(Model model, @ModelAttribute("categories") Categories categories ,@PathVariable("id") Integer id) {
		try {
			if(categoriesService.existsById(id)) {
				categoriesService.update(categories);
			}
			else {
				return "redirect:/categoriess";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/categoriess";
	}
	
	@GetMapping("{id}/del")
	public String deleteCategories(Model model, @PathVariable("id") Integer id ) {
		try {
			if(categoriesService.existsById(id)) {
				categoriesService.deleteById(id);
			}
			else {
				return "redirect:/categoriess";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/categoriess";
	}
	
	@GetMapping("{id}/view")
	public String viewCategories(Model model, @PathVariable("id") Integer id) {
		try {
			if(categoriesService.existsById(id)) {
				Optional<Categories> optional = categoriesService.findById(id);
				model.addAttribute("categories", optional.get());
			}
			else {
				return "redirect:/categoriess";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "categoriess/view-categoriess";
	}
	
}
