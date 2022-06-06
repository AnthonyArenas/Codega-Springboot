package pe.edu.upc.Codega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Codega.business.crud.ClientService;
import pe.edu.upc.Codega.business.crud.LabelService;
import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Label;

@Controller
@RequestMapping("/labels")
public class LabelController {
	
	@Autowired
	private LabelService labelService;
	
	@Autowired
	private ClientService clientService;

	@GetMapping
	public String listLabels(Model model) {
		
		try {
			List<Label> labels = labelService.getAll();
			model.addAttribute("labels", labels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "labels/list-labels";
	}
	
	@GetMapping("/new")
	public String newLabel(Model model) {
		try {
			List<Client> clients = clientService.getAll();
			model.addAttribute("clients", clients);
			model.addAttribute("label", new Label());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "labels/new-label";
	}
	
	@PostMapping("/save")
	public String saveLabel(Model model, @ModelAttribute("label") Label label) {
		try {
			Label labelSaved = labelService.create(label);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/labels";
	}
	
}