package pe.edu.upc.Codega.business.logic;

import java.util.List;

import pe.edu.upc.Codega.model.entity.Order;

public interface OrderBsService {
	List<Order> findByClient(Integer id) throws Exception;

}
