package pe.edu.upc.Codega.model.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> { 
	
	/*@Query(value = "SELECT pe FROM Sale pe WHERE pe.seller.id = :id")
	List<Sale> findBySeller(@Param("id") Integer id);*/
	//List<Sale> findBySeller(Seller seller) throws Exception;
}
