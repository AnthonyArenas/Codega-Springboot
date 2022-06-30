package pe.edu.upc.Codega.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.Codega.model.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
	
	@Query(value = "SELECT pe FROM OrderDetail pe WHERE pe.order.id = :id")
	List<OrderDetail> findByClient(@Param("id") Integer id);
	
	
}
