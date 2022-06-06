package pe.edu.upc.Codega.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Clothing;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Integer> {
	
	@Query(value =
            " SELECT pe FROM Clothing pe WHERE pe.list_clothing.id = :id")
	List<Clothing> findByIdListClothing(@Param("id") Integer id);
}

