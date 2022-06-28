package pe.edu.upc.Codega.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Codega.utils.UserAuthentication;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private UserAuthentication userAuthentication;

	@GetMapping
	public String getIndex(Model model) {	
		
		if (userAuthentication.isAuthenticated()) {	// Enviar los datos del Segmento al html
			userAuthentication.getSegment(model);
		}
				
		return "index";
	}
}
