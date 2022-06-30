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

import pe.edu.upc.Codega.business.crud.ClothingService;
import pe.edu.upc.Codega.business.crud.ListClothingService;
import pe.edu.upc.Codega.model.entity.Clothing;
import pe.edu.upc.Codega.model.entity.ListClothing;
import pe.edu.upc.Codega.utils.UserAuthentication;


@Controller
@RequestMapping("/inventory")	// GET y POST
@SessionAttributes("{inventory}")
public class InventoryController {
	
	@Autowired
	private ClothingService clothingService;
	
	@Autowired
	private ListClothingService listClothingService; 
	
	@Autowired
	private UserAuthentication userAuthentication;

	@GetMapping("{id}/list-clothing")
	public String listClothes(Model model, @PathVariable("id") Integer id) {
		
		try {
			List<Clothing> clothes = clothingService.findByIdListClothing(id);
			model.addAttribute("clothes", clothes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "inventory/list-clothes";
	}
	
	@GetMapping("{id}/view")
	public String viewClothing(Model model, @PathVariable("id") Integer id) {
		try {
			if(clothingService.existsById(id)) {
				Optional<Clothing> optional = clothingService.findById(id);
				model.addAttribute("clothing", optional.get());
			}
			else {
				return "redirect:/inventory";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "inventory/view-clothing";
	}
	
	@GetMapping
	public String allClothes(Model model) {
		
		try {
			List<Clothing> allclothes = clothingService.getAll();
			model.addAttribute("allclothes", allclothes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "inventory/all-clothes";
	}
	
	@GetMapping("new")	//	
	public String newClothing(Model model) {
		Clothing clothing = new Clothing();
		model.addAttribute("clothing", clothing);
		try {
			List<ListClothing> listClothing = listClothingService.getAll();
			model.addAttribute("listClothing", listClothing);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "inventory/new-clothing";
	}
	
	@PostMapping("savenew")	//	
	public String saveClothing(Model model, @ModelAttribute("clothing") Clothing clothing) {
		try {
			Clothing studentSaved = clothingService.create(clothing);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/inventory";
	}
	
	@GetMapping("{id}/edit")	
	public String editClothing(Model model, @PathVariable("id") Integer id) {				
		try {
			if (clothingService.existsById(id)) {
				Optional<Clothing> optional = clothingService.findById(id);
				model.addAttribute("clothing", optional.get());
				List<ListClothing> listClothing = listClothingService.getAll();
				model.addAttribute("listClothing", listClothing);
			} else {
				return "redirect:/inventory";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "inventory/edit-clothing";
	}
	
	@PostMapping("{id}/update")	
	public String updateClothing(Model model, @ModelAttribute("clothing") Clothing clothing, 
			@PathVariable("id") Integer id) {
		try {
			if (clothingService.existsById(id)) {
				clothingService.update(clothing);
			} else {
				return "redirect:/inventory";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/inventory";
	}
	
	@GetMapping("{id}/del")	//	
	public String deleteClothing(Model model, @PathVariable("id") Integer id) {
		try {
			if (clothingService.existsById(id)) {
				clothingService.deleteById(id);
			} else {
				return "redirect:/inventory";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/inventory";
	}

}
