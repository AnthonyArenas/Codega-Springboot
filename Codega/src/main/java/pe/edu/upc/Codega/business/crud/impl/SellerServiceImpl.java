package pe.edu.upc.Codega.business.crud.impl;

import java.io.Serializable;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.SellerService;
import pe.edu.upc.Codega.model.entity.Seller;
import pe.edu.upc.Codega.model.repository.SellerRepository;



@Service
public class SellerServiceImpl implements SellerService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private  SellerRepository sellerRepository;
	
	@Override
	public JpaRepository<Seller, Integer> getJpaRepository() {
		return this.sellerRepository;
	}
	
	@Transactional
	@Override
	public Seller update(Seller entity) throws Exception {
		return sellerRepository.save(entity);
	}
	
}
