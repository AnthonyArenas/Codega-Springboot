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

import pe.edu.upc.Codega.business.crud.ClientService;
import pe.edu.upc.Codega.business.crud.LabelService;
import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Label;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LabelService labelService;

	@GetMapping
	public String listClients(Model model) {
		
		try {
			List<Client> clients = clientService.getAll();
			model.addAttribute("clients", clients);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/clients";
	}
	
	@GetMapping("/goupdate/{id}")
	public String updateClient(@PathVariable int id, Model model) {
		try {
			Client client = clientService.findById(id).get();
			model.addAttribute("client", client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "clients/new-client";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String,Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id != null && id>0) {
				List<Label> labels = labelService.findByClientId(id);
				for(int i = 0; i < labels.size(); i++) {
					labelService.deleteById(labels.get(i).getId());
				}
				clientService.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/clients";
	}

}