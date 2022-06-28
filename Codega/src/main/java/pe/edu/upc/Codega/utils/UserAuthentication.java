package pe.edu.upc.Codega.utils;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pe.edu.upc.Codega.business.crud.ClientService;
import pe.edu.upc.Codega.business.crud.SellerService;
import pe.edu.upc.Codega.model.entity.Segment;
import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Seller;
import pe.edu.upc.Codega.security.MyUserDetails;

@Service
public class UserAuthentication {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private SellerService sellerService;
	
	public boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication instanceof AnonymousAuthenticationToken) { // Si no hay nadie autenticado
			return false;			
		} else {
			return true;
		}
	}
	public void getSegment(Model model) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(!(authentication instanceof AnonymousAuthenticationToken)) {	// Si Hay alguien autenticado
				
				MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
				model.addAttribute("segment", myUserDetails.getSegment());
				System.out.println(myUserDetails.getSegment());
				// Para el segmento 1: Cambiar CLIENT por su segmento
				if (myUserDetails.getSegment().equals(Segment.CLIENT)) {
					if (clientService.existsById(myUserDetails.getIdSegment())) {
						Optional<Client> optional = clientService.findById(myUserDetails.getIdSegment());
						model.addAttribute("client", optional.get());
					}					
				} 
				// Para el segmento 2: Cambiar SELLER por su segmento
				else if (myUserDetails.getSegment().equals(Segment.SELLER)) {
					if (sellerService.existsById(myUserDetails.getIdSegment())) {
						Optional<Seller> optional = sellerService.findById(myUserDetails.getIdSegment());
						model.addAttribute("seller", optional.get());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Integer getIdSegment() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			
			MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
			return myUserDetails.getIdSegment();
		}
		return null;
	}
	
}
