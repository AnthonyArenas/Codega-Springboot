package pe.edu.upc.Codega.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.OrderDetailService;
import pe.edu.upc.Codega.model.entity.OrderDetail;
import pe.edu.upc.Codega.model.repository.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public JpaRepository<OrderDetail, Integer> getJpaRepository() {
		return this.orderDetailRepository;
	}

}
