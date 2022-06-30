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
		
			
		User julio = new User("julio", bcpe.encode("julio"), Segment.CLIENT, 3);
		julio.addAuthority("ROLE_CLIENT");
		julio.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(julio);
		
		User zack = new User("zack", bcpe.encode("zack"), Segment.CLIENT, 4);
		zack.addAuthority("ROLE_CLIENT");
		zack.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(zack);
		
		User jose = new User("jose", bcpe.encode("jose"), Segment.CLIENT, 5);
		jose.addAuthority("ROLE_CLIENT");
		jose.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(jose);
		
		User jhon = new User("jhon", bcpe.encode("jhon"), Segment.SELLER, 1);
		jhon.addAuthority("ROLE_SELLER");
		jhon.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(jhon); 
		
		User carmen = new User("carmen", bcpe.encode("carmen"), Segment.SELLER, 2);
		carmen.addAuthority("ROLE_SELLER");
		carmen.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(carmen); 
		
		User paola = new User("paola", bcpe.encode("paola"), Segment.SELLER, 3);
		paola.addAuthority("ROLE_SELLER");
		paola.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(paola); 
		
		User miguel = new User("miguel", bcpe.encode("miguel"), Segment.SELLER, 4);
		miguel.addAuthority("ROLE_SELLER");
		miguel.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(miguel); 
		
		User bruno = new User("bruno", bcpe.encode("bruno"), Segment.SELLER, 5);
		bruno.addAuthority("ROLE_SELLER");
		bruno.addAuthority("ACCESS_VIEW_MATRI");
		userRepository.save(bruno); */
	}

}