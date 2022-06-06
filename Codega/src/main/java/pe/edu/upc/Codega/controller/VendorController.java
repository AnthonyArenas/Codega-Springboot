package pe.edu.upc.Codega.controller;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.Codega.business.crud.CategoriesService;
import pe.edu.upc.Codega.business.crud.LabelService;
import pe.edu.upc.Codega.business.crud.VendorService;
import pe.edu.upc.Codega.model.entity.Categories;
import pe.edu.upc.Codega.model.entity.Label;
import pe.edu.upc.Codega.model.entity.Vendor;

@Controller
@RequestMapping("/vendors")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private CategoriesService categoriesService;

	@GetMapping
	public String listVendors(Model model) {
		
		try {
			List<Vendor> vendors = vendorService.getAll();
			model.addAttribute("vendors", vendors);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "vendors/list-vendors";
	}
	
	@GetMapping("/new")
	public String newVendor(Model model) {
		try {
			model.addAttribute("vendor", new Vendor());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "vendors/new-vendor";
	}
	
	@PostMapping("/save")
	public String saveVendor(Model model, @ModelAttribute("vendor") Vendor vendor) {
		try {
			Vendor vendorSaved = vendorService.create(vendor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/vendors";
	}
	
	@GetMapping("/goupdate/{id}")
	public String updateVendor(@PathVariable int id, Model model) {
		try {
			Vendor vendor = vendorService.findById(id).get();
			model.addAttribute("vendor", vendor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "vendors/new-vendor";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String,Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id != null && id>0) {
				List<Categories> categories = categoriesService.findByVendorId(id);
				for(int i = 0; i < categories.size(); i++) {
					categoriesService.deleteById(categories.get(i).getId());
				}
				vendorService.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/vendors";
	}

}