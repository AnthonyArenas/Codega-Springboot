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
import pe.edu.upc.Codega.business.crud.ListClothingService;
import pe.edu.upc.Codega.business.crud.SellerService;

import pe.edu.upc.Codega.model.entity.Categories;
import pe.edu.upc.Codega.model.entity.Clothing;
import pe.edu.upc.Codega.model.entity.ListClothing;
import pe.edu.upc.Codega.model.entity.Seller;


@Controller
@RequestMapping("/listClothing")	// GET y POST
@SessionAttributes("{listClothing}")
public class ListClothingController {
	
	@Autowired
	private ListClothingService listClothingService;
	
	@Autowired
	private CategoriesService categoriesService; 

	
	@Autowired
	private SellerService sellerService; 
	
	
	
	@GetMapping
	public String listListClothings(Model model) {
		
		try {
			List<ListClothing> listClothing = listClothingService.getAll();
			model.addAttribute("listClothing", listClothing);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listClothing/list-listClothing";
	}
	
	@GetMapping("{id}/view")
	public String viewlistListClothing(Model model, @PathVariable("id") Integer id) {
		try {
			if(listClothingService.existsById(id)) {
				Optional<ListClothing> optional = listClothingService.findById(id);
				model.addAttribute("listClothing", optional.get());
			}
			else {
				return "redirect:/inventory";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "inventory/view-list-clothing";
	}
	
	@GetMapping("new")	//	/ListClothings/new
	public String newListClothing(Model model) {
		ListClothing listClothing = new ListClothing();
		model.addAttribute("listClothing", listClothing);
		try {
			List<Categories> categories = categoriesService.getAll();
			model.addAttribute("categories", categories);
			
			List<Seller> sellers = sellerService.getAll();
			model.addAttribute("sellers", sellers);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listClothing/new-listClothing";
	}
	
	@PostMapping("savenew")	//	/ListClothings/savenew
	public String saveListClothing(Model model, @ModelAttribute("listClothing") ListClothing listClothing) {
		try {
			ListClothing listClothingSaved = listClothingService.create(listClothing);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/listClothing";
	}
	
	@GetMapping("{id}/edit")	//	/ListClothings/1/edit
	public String editListClothing(Model model, @PathVariable("id") Integer id) {				
		try {
			if (listClothingService.existsById(id)) {
				Optional<ListClothing> optional = listClothingService.findById(id);
				model.addAttribute("listClothing", optional.get());
				List<Categories> categories = categoriesService.getAll();
				model.addAttribute("categories", categories);
				List<Seller> sellers = sellerService.getAll();
				model.addAttribute("sellers", sellers);
			} else {
				return "redirect:/listClothing";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listClothing/edit-listClothing";
	}
	
	@PostMapping("{id}/update")	//	/ListClothings/1/update
	public String updateListClothing(Model model, @ModelAttribute("listClothing") ListClothing listClothing, 
			@PathVariable("id") Integer id) {
		try {
			if (listClothingService.existsById(id)) {
				listClothingService.update(listClothing);
			} else {
				return "redirect:/listClothing";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/listClothing";
	}
	
	@GetMapping("{id}/del")	//	/ListClothings/1/del
	public String deleteListClothing(Model model, @PathVariable("id") Integer id) {
		try {
			if (listClothingService.existsById(id)) {
				listClothingService.deleteById(id);
			} else {
				return "redirect:/listClothing";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/listClothing";
	}
}


