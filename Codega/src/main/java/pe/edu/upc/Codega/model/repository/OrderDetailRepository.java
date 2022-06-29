package pe.edu.upc.Codega.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Order;
import pe.edu.upc.Codega.model.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
	//List<OrderDetail> findByClient(Client client) throws Exception;
	//List<OrderDetail> findByClient(Integer id) throws Exception;
	List<OrderDetail> findByOrder(Order order) throws Exception;
	//List<OrderDetail> findByClient(Client client)throws Exception;

}
