package pe.edu.upc.Codega.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByPickUpWay(String pickUpWay) throws Exception;
	List<Order> findByClient(Client client) throws Exception;
}