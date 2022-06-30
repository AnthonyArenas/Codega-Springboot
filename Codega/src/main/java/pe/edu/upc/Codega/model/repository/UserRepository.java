package pe.edu.upc.Codega.model.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	
	/*@Query(value =
            " SELECT u FROM User u WHERE u.segment = 0")
	List<User> getAllClients();
	
	@Query(value =
            " SELECT u FROM User u WHERE u.segment = 1")
	List<User> getAllSellers();*/
	
	
	
}
