package pe.edu.upc.Codega.business.crud;


import java.util.Optional;

import pe.edu.upc.Codega.model.entity.User;


public interface UserService {
	
	boolean existsByUsername(String username) throws Exception;
	Optional<User> register(User User) throws Exception;	

	
}
