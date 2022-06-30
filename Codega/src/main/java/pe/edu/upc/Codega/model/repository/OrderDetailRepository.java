package pe.edu.upc.Codega.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.ListClothing;
import pe.edu.upc.Codega.model.entity.Order;
import pe.edu.upc.Codega.model.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
	//List<OrderDetail> findByClient(Client client) throws Exception;
	//List<OrderDetail> findByOrder(Order order) throws Exception;
	
	//@Query(value = "SELECT pe FROM OrderDetail pe INNER JOIN Orders ord ON pe.id = ord.id WHERE ord.client.id = :id")
	//List<OrderDetail> findByClient(@Param("id") Integer id);
	
	@Query(value = "SELECT pe FROM OrderDetail pe WHERE pe.order.id = :id")
	List<OrderDetail> findByClient(@Param("id") Integer id);
	
	//@Query(value = "SELECT pe FROM OrderDetail pe JOIN Orders ord ON pe.id = ord.id WHERE pe.order.id = :id")
	//List<OrderDetail> findByClient(@Param("id") Integer id);
	
	//@Query(value = "SELECT pe FROM OrderDetail pe " + "INNER JOIN Orders O on pe.OrderDetail=O.OrderDetail WHERE O.client.id = :id")
	//List<OrderDetail> findByClient(@Param("id") Integer id);
}
