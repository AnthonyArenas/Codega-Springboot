package pe.edu.upc.Codega.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.OrderDetailService;
import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.Order;
import pe.edu.upc.Codega.model.entity.OrderDetail;
import pe.edu.upc.Codega.model.repository.ClientRepository;
import pe.edu.upc.Codega.model.repository.OrderDetailRepository;
import pe.edu.upc.Codega.model.repository.OrderRepository;


@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public JpaRepository<OrderDetail, Integer> getJpaRepository() {
		return this.orderDetailRepository;
	}

	/*@Override
	public List<OrderDetail> findByOrder(Integer id) throws Exception {
		if(orderRepository.existsById(id)) {
			Optional<Order> optional = orderRepository.findById(id);
			return orderDetailRepository.findByOrder(optional.get());
		}else {
			return new ArrayList<OrderDetail>();
		}
	}*/

	@Override
	public List<OrderDetail> findByClient(Integer id) throws Exception {
		if(clientRepository.existsById(id)) {
			Optional<Client> optional = clientRepository.findById(id);
			return orderDetailRepository.findByClient(optional.get().getId());
		}else {
			return new ArrayList<OrderDetail>();
		}
	}



}