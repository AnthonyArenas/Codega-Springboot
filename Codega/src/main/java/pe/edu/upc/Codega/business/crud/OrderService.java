package pe.edu.upc.Codega.business.crud;

import java.util.List;

import pe.edu.upc.Codega.model.entity.Order;

public interface OrderService extends CrudService<Order, Integer>{
	List<Order> findByPickUpWay(String pickUpWay) throws Exception;
}
