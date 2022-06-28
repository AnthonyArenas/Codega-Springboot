package pe.edu.upc.Codega.init;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.model.entity.Segment;
import pe.edu.upc.Codega.model.entity.User;
import pe.edu.upc.Codega.model.repository.UserRepository;

@Service
public class InitUser implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		// ROLE_XXXXX	-> Segmento Objetivo
		// ACCESS_YYYYY
		
		// SIEMPRE DEBE DE ESTAR COMENTADO
		// SOLO SE DEBE DESBLOQUEAR CUANDO SE CREAN USUARIO
		/*User carlos = new User();
		carlos.setUsername("carlos");
		carlos.setPassword(bcpe.encode("carlos"));	
		carlos.setSegment(Segment.CLIENT);
		carlos.setIdSegment(1);
		carlos.addAuthority("ROLE_CLIENT");
		carlos.addAuthority("ACCESS_VIEW_MATRI");
		carlos.addAuthority("ACCESS_EDIT_MATRI");
		userRepository.save(carlos);
		
		User maria = new User("maria", bcpe.encode("maria"), Segment.CLIENT, 2);
		maria.addAuthority("ROLE_CLIENT");
		maria.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(maria);
		
		User admin = new User("admin", bcpe.encode("admin"), Segment.CLIENT, 2);
		admin.addAuthority("ROLE_ADMINISTRATOR");
		admin.addAuthority("ACCESS_ALL");
		userRepository.save(admin);
		
		User jhon = new User("jhon", bcpe.encode("jhon"), Segment.SELLER, 2);
		jhon.addAuthority("ROLE_SELLER");
		jhon.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(jhon);*/
	}

}
