package pe.edu.upc.Codega.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Codega.business.crud.impl.UserServiceImpl;
import pe.edu.upc.Codega.model.entity.Segment;
import pe.edu.upc.Codega.model.entity.User;
import pe.edu.upc.Codega.utils.UserAuthentication;


@Controller
@RequestMapping("/users")	
@SessionAttributes("{user}")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserAuthentication userAuthentication;
	
	@GetMapping("sign-up")
	public String signUp(Model model) {
		User user = new User();
		user.setEnable(true);
		model.addAttribute("user", user);		
		model.addAttribute("segments", getSegments());
		return "users/sign-up";
	}
	
	@PostMapping("register-user")
	public String registerUser(Model model, @ModelAttribute("user") User user) {
		try {
			if (!userService.existsByUsername(user.getUsername())) {
				userService.register(user);
				return "redirect:/login";
			}
		} catch (Exception e) {
		}
		return "redirect:/";
	}
	
	@GetMapping("view-profile")
	public String getIndex(Model model) {	
		
		if (userAuthentication.isAuthenticated()) {
			userAuthentication.getSegment(model);
		}
				
		return "users/view-profile";
	}
	
	private List<Segment> getSegments() {
		List<Segment> segments = new ArrayList<>();
		segments.add(Segment.CLIENT);
		segments.add(Segment.SELLER);
		return segments;
	}	
}
