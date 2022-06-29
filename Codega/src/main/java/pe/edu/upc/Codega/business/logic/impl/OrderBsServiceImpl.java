package pe.edu.upc.Codega.business.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.logic.OrderBsService;
import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Order;
import pe.edu.upc.Codega.model.repository.ClientRepository;
import pe.edu.upc.Codega.model.repository.OrderRepository;

@Service
public class OrderBsServiceImpl implements OrderBsService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
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
