package pe.edu.upc.Codega.controller;

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

import pe.edu.upc.Codega.business.crud.SellerService;
import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Seller;


@Controller
@RequestMapping("/sellers")
@SessionAttributes("{seller}")
public class SellerController {	

	@Autowired
	private SellerService sellerService;
	
	@GetMapping("{id}/edit")
	public String editSeller(Model model, @PathVariable("id") Integer id) {

			try {
				Optional<Seller> optional = sellerService.findById(id);
				model.addAttribute("seller", optional.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "sellers/detail-seller";		
		
	
	}
	
	@PostMapping("{id}/update")
	public String updateSeller(Model model, @ModelAttribute("seller") Seller seller, @PathVariable("id") Integer id) {
		try {
			if(sellerService.existsById(id)) {
				sellerService.update(seller);
			}
			return "users/view-profile";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "users/view-profile";
	}

}
