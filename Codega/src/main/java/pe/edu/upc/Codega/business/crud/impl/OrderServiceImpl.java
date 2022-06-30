package pe.edu.upc.Codega.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Order;
import pe.edu.upc.Codega.model.entity.OrderDetail;
import pe.edu.upc.Codega.business.crud.OrderService;
import pe.edu.upc.Codega.model.repository.ClientRepository;
import pe.edu.upc.Codega.model.repository.OrderRepository;

@Service

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public JpaRepository<Order, Integer> getJpaRepository() {
		return this.orderRepository;
	}

	@Override
	public List<Order> findByPickUpWay(String pickUpWay) throws Exception {
		return this.orderRepository.findByPickUpWay(pickUpWay);
	}

	@Override
	public List<Order> findByClient(Integer id) throws Exception {
		if(clientRepository.existsById(id)) {
			Optional<Client> optional = clientRepository.findById(id);
			return orderRepository.findByClient(optional.get());
		}else {
			return new ArrayList<Order>();
		}
	}

}
