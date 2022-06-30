package pe.edu.upc.Codega.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Categories;
import pe.edu.upc.Codega.model.entity.Clothing;
import pe.edu.upc.Codega.model.entity.ListClothing;

@Repository
public interface ListClothingRepository extends JpaRepository<ListClothing, Integer> {
	//List<ListClothing> findByCategorie (Categories categories) throws Exception;
	
	@Query(value = "SELECT pe FROM ListClothing pe WHERE pe.categorie.id = :id")
	List<ListClothing> findByCategorie(@Param("id") Integer id);
	
	@Query(value = "SELECT pe FROM ListClothing pe WHERE pe.seller.id = :id")
	List<ListClothing> findBySeller(@Param("id") Integer id);
}
