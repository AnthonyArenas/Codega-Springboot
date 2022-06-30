package pe.edu.upc.Codega.business.crud.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.UserService;
import pe.edu.upc.Codega.model.entity.Segment;
import pe.edu.upc.Codega.model.entity.User;
import pe.edu.upc.Codega.model.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean existsByUsername(String username) throws Exception {
		Optional<User> optional = userRepository.findByUsername(username);
		if (optional.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Optional<User> register(User user) throws Exception {
		// Agregar los Authorities por defecto
		if (user.getSegment().equals(Segment.CLIENT)) {
			user.addAuthority("ROLE_CLIENT");
		} else if (user.getSegment().equals(Segment.SELLER)) {
			user.addAuthority("ROLE_SELLER");
		}			
		user.addAuthority("ACCESS_VIEW_MATRI");
		
		// Cifrar el password
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		user.setPassword(bcpe.encode(user.getPassword()));
		
		// Grabar el usuario			
		return Optional.of(userRepository.save(user)); 
	}

	/*@Override
	public List<User> getAllClients() {
		return userRepository.getAllClients();
	}

	@Override
	public List<User> getAllSellers() {
		return userRepository.getAllSellers();
	}*/
	
	

}
