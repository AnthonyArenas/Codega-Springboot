package pe.edu.upc.Codega.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Codega.business.crud.ClientService;
import pe.edu.upc.Codega.business.crud.SellerService;
import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Seller;
import pe.edu.upc.Codega.utils.UserAuthentication;

@Controller
@RequestMapping("/clients")
@SessionAttributes("{client}")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private UserAuthentication userAuthentication;

	@GetMapping
	public String listClients(Model model) {
		
		try {
			List<Client> clients = clientService.getAll();
			model.addAttribute("clients", clients);
			List<Seller> sellers = sellerService.getAll();
			model.addAttribute("sellers", sellers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "clients/list-clients";
	}
	
	@GetMapping("/new")
	public String newClient(Model model) {
		try {
			model.addAttribute("client", new Client());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "clients/new-client";
	}
	
	@PostMapping("/save")
	public String saveClient(Model model, @ModelAttribute("client") Client client) {
		try {
			Client clientSaved = clientService.create(client);
			return "redirect:/clients/godetail/"+clientSaved.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/clients";
		}
	}
	
	
	@GetMapping("{id}/edit")
	public String editClient(Model model, @PathVariable("id") Integer id) {

			try {
				Optional<Client> optional = clientService.findById(id);
				model.addAttribute("client", optional.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "clients/detail-client";		
		
	
	}
	
	@PostMapping("{id}/update")
	public String updateClient(Model model, @ModelAttribute("client") Client client, @PathVariable("id") Integer id) {
		try {
			if(clientService.existsById(id)) {
				clientService.update(client);
			}
			return "users/view-profile";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "users/view-profile";
	}
	

	@RequestMapping("/delete")
	public String delete(Map<String,Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id != null && id>0) {
				//List<Label> labels = labelService.findByClientId(id);
				//for(int i = 0; i < labels.size(); i++) {
					//labelService.deleteById(labels.get(i).getId());
				//}
				//clientService.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/clients";
	}
	
	
	
}