package pe.edu.upc.Codega.business.crud.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.model.entity.Order;

import pe.edu.upc.Codega.business.crud.OrderService;
import pe.edu.upc.Codega.model.repository.OrderRepository;

@Service

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public JpaRepository<Order, Integer> getJpaRepository() {
		return this.orderRepository;
	}

	@Override
	public List<Order> findByPickUpWay(String pickUpWay) throws Exception {
		return this.orderRepository.findByPickUpWay(pickUpWay);
	}

}
